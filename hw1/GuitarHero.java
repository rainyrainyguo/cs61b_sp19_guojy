/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
import es.datastructur.synthesizer.GuitarString;

public class GuitarHero {
    private static  final double F = 440.0;
    private static double[] C = new double[37];
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static void assign(){
        for(int i=0; i < 37; i++){
            C[i] = F * Math.pow(2, (i - 24.0)/12.0);
        }
    }

    public static void main(String[] args) {

        /* create two guitar strings, for concert A and C */
        GuitarString[] strings = new GuitarString[37];
        assign();
        for (int i=0; i < 37; i++) {
            strings[i] = new GuitarString(C[i]);
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                strings[keyboard.indexOf(key)].pluck();
                double sample = strings[keyboard.indexOf(key)].sample() + strings[keyboard.indexOf(key)+1].sample();
                StdAudio.play(sample);
            }

            /* compute the superposition of samples */
            //double sample = strings[keyboard.indexOf(k)].sample();

            /* play the sample on standard audio */

            /* advance the simulation of each guitar string by one step */
            //stringA.tic();
            //stringC.tic();
        }
    }
}

