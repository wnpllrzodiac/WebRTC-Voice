package cc.dot.engine;

import org.webrtc.MediaConstraints;

/**
 * Created by linSir
 * date at 2017/4/6.
 * describe:
 */

public class AudioMediaConstrains extends MediaConstraints {
    private static final String AUDIO_CODEC_PARAM_BITRATE = "maxaveragebitrate";
    private static final String AUDIO_ECHO_CANCELLATION_CONSTRAINT = "googEchoCancellation";
    private static final String AUDIO_AUTO_GAIN_CONTROL_CONSTRAINT = "googAutoGainControl";
    private static final String AUDIO_HIGH_PASS_FILTER_CONSTRAINT = "googHighpassFilter";
    private static final String AUDIO_NOISE_SUPPRESSION_CONSTRAINT = "googNoiseSuppression";
    private static final String AUDIO_LEVEL_CONTROL_CONSTRAINT = "levelControl";
    private static final String DTLS_SRTP_KEY_AGREEMENT_CONSTRAINT = "DtlsSrtpKeyAgreement";

    public AudioMediaConstrains() {
        KeyValuePair keyValuePair = new KeyValuePair("OfferToReceiveAudio", "true");
        mandatory.add(keyValuePair);
        mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "false"));
        mandatory.add(new MediaConstraints.KeyValuePair(AUDIO_LEVEL_CONTROL_CONSTRAINT, "true"));
        mandatory.add(new MediaConstraints.KeyValuePair(AUDIO_CODEC_PARAM_BITRATE, "true"));
    }
}
