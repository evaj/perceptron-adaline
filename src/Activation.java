/**
 * Created by Dell on 2017-10-08.
 */
public final class Activation {

    public static final int bipolar(double value, double threshold){
        return value > threshold ? 1 : -1;
    }

    public static final int unipolar(double value, double threshold){
        return value > threshold ? 1 : 0;
    }
}
