/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
import es.datastructur.synthesizer.GuitarString;

public class GuitarHeroLite {
    //private static final double CONCERT_A = 440.0;
    //private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        double[] Cs = new double[37];
        for (int i=0; i < 37; i++){
            Cs[i] = 440.0 * Math.pow(2, (i - 24.0) / 12.0);
        }
        GuitarString stringq = new GuitarString(Cs[keyboard.indexOf('q')]);
        GuitarString string2 = new GuitarString(Cs[keyboard.indexOf('2')]);

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (key == 'q') {
                    stringq.pluck();
                } else if (key == '2') {
                    string2.pluck();
                }
            }

        /* compute the superposition of samples */
            //double sample = stringq.sample()+ string2.sample();

        /* play the sample on standard audio */
            //StdAudio.play(sample);

        /* advance the simulation of each guitar string by one step */
            stringq.tic();
            string2.tic();
            StdAudio.play(stringq.sample());
        }
    }
}

