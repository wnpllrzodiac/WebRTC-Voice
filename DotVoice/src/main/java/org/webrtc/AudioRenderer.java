

package org.webrtc;


public class AudioRenderer {
    //    ,size_t number_of_channels,size_t number_of_frames
    public static class AudioFrame {
        public byte[] audio_data;
        public int bits_per_sample;
        public int sample_rate;
        public int number_of_channels;
        public int number_of_frames;


        public AudioFrame(byte[] audio_data, int bits_per_sample, int sample_rate, int number_of_channels, int number_of_frames) {
            this.audio_data = audio_data;
            this.sample_rate = sample_rate;
            this.bits_per_sample = bits_per_sample;
            this.number_of_channels = number_of_channels;
            this.number_of_frames = number_of_frames;
        }
    }


    public static interface Callbacks {

        public void onAudioFrame(AudioFrame frame);
    }


    long nativeAudioRenderer;

    public AudioRenderer(Callbacks callbacks) {

        nativeAudioRenderer = nativeWrapAudioRenderer(callbacks);
    }

    public void dispose() {

        if (nativeAudioRenderer == 0) {

            return;
        }

        // todo  free native audio renderer
        nativeAudioRenderer = 0;
    }

    private static native long nativeWrapAudioRenderer(Callbacks callbacks);

}
