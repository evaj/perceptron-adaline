/**
 * Created by Dell on 2017-10-08.
 */
public final class Error {

    public static int binary(double expected, double received){
        return (int)Math.round(expected - received);
    }
    public static double meanSquare(double expected, double net){
        return (int)Math.round(expected - net);
    }
}
