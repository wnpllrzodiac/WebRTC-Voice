package cc.dot.engine;

import org.webrtc.IceCandidate;
import org.webrtc.Logging;
import org.webrtc.MediaConstraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by linSir
 * date at 2017/4/4.
 * describe:
 */

public class DotEngineSDPFactory {

    private static final String TAG = "DotEngineSDPFactory";

    private static final String VIDEO_CODEC_PARAM_START_BITRATE =
            "x-google-start-bitrate";
    private static final String AUDIO_CODEC_PARAM_BITRATE = "maxaveragebitrate";


    public static MediaConstraints offerConstraints(boolean audio, boolean video, boolean... restart) {
        MediaConstraints constraints = new MediaConstraints();
        String audioString = audio ? "true" : "false";
        String videoString = video ? "true" : "false";

        constraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", audioString));
        constraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", videoString));
        constraints.optional.add(new MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "true"));
        constraints.optional.add(new MediaConstraints.KeyValuePair("VoiceActivityDetection", "true"));

        if (restart.length == 1 && restart[0]) {
            constraints.optional.add(new MediaConstraints.KeyValuePair("IceRestart", "true"));
        }

        return constraints;
    }


    public static MediaConstraints answerConstraints(boolean audio, boolean video) {


        MediaConstraints constraints = new MediaConstraints();
        String audioString = String.valueOf(audio);
        String videoString = String.valueOf(video);

        constraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", audioString));
        constraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", videoString));
        constraints.optional.add(new MediaConstraints.KeyValuePair("VoiceActivityDetection", "true"));
        return constraints;

    }


    public static MediaConstraints connectionConstraints() {
        MediaConstraints constraints = new MediaConstraints();
        constraints.optional.add(new MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "true"));
        constraints.optional.add(new MediaConstraints.KeyValuePair("googSuspendBelowMinBitrate", "false"));
        constraints.optional.add(new MediaConstraints.KeyValuePair("googCombinedAudioVideoBwe", "true"));

        return constraints;
    }





    public static MediaConstraints audioConstraints() {
        MediaConstraints constraints = new MediaConstraints();
        return constraints;
    }


    public static IceCandidate filteredIceCandidate(IceCandidate iceCandidate) {
        Boolean sendCandidate = false;
        DotVoice.DotEngineICEFilter iceFilter = DotVoice.DotEngineICEFilter.DotEngineICEFilter_Local;

//        if (iceFilter == DotVoice.DotEngineICEFilter.DotEngineICEFilter_Local) {
//            sendCandidate = iceCandidate.sdp.contains("typ host");
//        }
//
//        if (iceFilter == DotVoice.DotEngineICEFilter.DotEngineICEFilter_Stun) {
//            sendCandidate = iceCandidate.sdp.contains("typ srflx");
//        }
//
//        if (iceFilter == DotVoice.DotEngineICEFilter.DotEngineICEFilter_Turn) {
//            sendCandidate = iceCandidate.sdp.contains("typ relay");
//        }
//
//        if (iceFilter == DotVoice.DotEngineICEFilter.DotEngineICEFilter_Any) {
//
//            sendCandidate = true;
//        }

        return sendCandidate ? iceCandidate : null;

    }


    public static String setStartBitrate(String codec, boolean isVideoCodec,
                                         String sdpDescription, int bitrateKbps) {


        String[] lines = sdpDescription.split("\r\n");
        int rtpmapLineIndex = -1;
        boolean sdpFormatUpdated = false;
        String codecRtpMap = null;
        // Search for codec rtpmap in format
        // a=rtpmap:<payload type> <encoding name>/<clock rate> [/<encoding parameters>]
        String regex = "^a=rtpmap:(\\d+) " + codec + "(/\\d+)+[\r]?$";
        Pattern codecPattern = Pattern.compile(regex);
        for (int i = 0; i < lines.length; i++) {
            Matcher codecMatcher = codecPattern.matcher(lines[i]);
            if (codecMatcher.matches()) {
                codecRtpMap = codecMatcher.group(1);
                rtpmapLineIndex = i;
                break;
            }
        }
        if (codecRtpMap == null) {
            Logging.w(TAG, "No rtpmap for " + codec + " codec");
            return sdpDescription;
        }
        Logging.d(TAG, "Found " + codec + " rtpmap " + codecRtpMap
                + " at " + lines[rtpmapLineIndex]);

        // Check if a=fmtp string already exist in remote SDP for this codec and
        // update it with new bitrate parameter.
        regex = "^a=fmtp:" + codecRtpMap + " \\w+=\\d+.*[\r]?$";
        codecPattern = Pattern.compile(regex);
        for (int i = 0; i < lines.length; i++) {
            Matcher codecMatcher = codecPattern.matcher(lines[i]);
            if (codecMatcher.matches()) {
                Logging.d(TAG, "Found " + codec + " " + lines[i]);
                if (isVideoCodec) {
                    lines[i] += "; " + VIDEO_CODEC_PARAM_START_BITRATE
                            + "=" + bitrateKbps;
                } else {
                    lines[i] += "; " + AUDIO_CODEC_PARAM_BITRATE
                            + "=" + (bitrateKbps * 1000);
                }
                Logging.d(TAG, "Update remote SDP line: " + lines[i]);
                sdpFormatUpdated = true;
                break;
            }
        }

        StringBuilder newSdpDescription = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            newSdpDescription.append(lines[i]).append("\r\n");
            // Append new a=fmtp line if no such line exist for a codec.
            if (!sdpFormatUpdated && i == rtpmapLineIndex) {
                String bitrateSet;
                if (isVideoCodec) {
                    bitrateSet = "a=fmtp:" + codecRtpMap + " "
                            + VIDEO_CODEC_PARAM_START_BITRATE + "=" + bitrateKbps;
                } else {
                    bitrateSet = "a=fmtp:" + codecRtpMap + " "
                            + AUDIO_CODEC_PARAM_BITRATE + "=" + (bitrateKbps * 1000);
                }
                Logging.d(TAG, "Add remote SDP line: " + bitrateSet);
                newSdpDescription.append(bitrateSet).append("\r\n");
            }

        }
        return newSdpDescription.toString();


    }


    public static String preferCodec(String sdpDescription, String codec, boolean isAudio) {


        String[] lines = sdpDescription.split("\r\n");
        int mLineIndex = -1;
        String codecRtpMap = null;
        // a=rtpmap:<payload type> <encoding name>/<clock rate> [/<encoding parameters>]
        String regex = "^a=rtpmap:(\\d+) " + codec + "(/\\d+)+[\r]?$";
        Pattern codecPattern = Pattern.compile(regex);
        String mediaDescription = "m=video ";
        if (isAudio) {
            mediaDescription = "m=audio ";
        }
        for (int i = 0; (i < lines.length)
                && (mLineIndex == -1 || codecRtpMap == null); i++) {
            if (lines[i].startsWith(mediaDescription)) {
                mLineIndex = i;
                continue;
            }
            Matcher codecMatcher = codecPattern.matcher(lines[i]);
            if (codecMatcher.matches()) {
                codecRtpMap = codecMatcher.group(1);
            }
        }
        if (mLineIndex == -1) {
            Logging.w(TAG, "No " + mediaDescription + " line, so can't prefer " + codec);
            return sdpDescription;
        }
        if (codecRtpMap == null) {
            Logging.w(TAG, "No rtpmap for " + codec);
            return sdpDescription;
        }
        Logging.d(TAG, "Found " + codec + " rtpmap " + codecRtpMap + ", prefer at "
                + lines[mLineIndex]);
        String[] origMLineParts = lines[mLineIndex].split(" ");
        if (origMLineParts.length > 3) {
            StringBuilder newMLine = new StringBuilder();
            int origPartIndex = 0;
            // Format is: m=<media> <port> <proto> <fmt> ...
            newMLine.append(origMLineParts[origPartIndex++]).append(" ");
            newMLine.append(origMLineParts[origPartIndex++]).append(" ");
            newMLine.append(origMLineParts[origPartIndex++]).append(" ");
            newMLine.append(codecRtpMap);
            for (; origPartIndex < origMLineParts.length; origPartIndex++) {
                if (!origMLineParts[origPartIndex].equals(codecRtpMap)) {
                    newMLine.append(" ").append(origMLineParts[origPartIndex]);
                }
            }
            lines[mLineIndex] = newMLine.toString();
            Logging.d(TAG, "Change media description: " + lines[mLineIndex]);
        } else {
            Logging.e(TAG, "Wrong SDP media description format: " + lines[mLineIndex]);
        }
        StringBuilder newSdpDescription = new StringBuilder();
        for (String line : lines) {
            newSdpDescription.append(line).append("\r\n");
        }
        return newSdpDescription.toString();

    }


}
