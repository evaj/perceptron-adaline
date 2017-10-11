/**
 * Created by Dell on 2017-10-09.
 */
public class Predictor {

    public static double predictBipolar(Matrix weights, Vector values){
        if(weights.getRows()!=1)
            weights = weights.transpose().getRow(0);
        return Activation.bipolar(weights.getLastRows(weights.rows-1).transpose().multiply(values)
                .getSingleValue()+weights.getFirstRows(1).getSingleValue(), 0);
    }

    public static double predictUnipolar(Matrix weights, Vector values){
        if(weights.getRows()!=1)
            weights = weights.transpose().getRow(0);
        return Activation.unipolar(weights.getLastRows(weights.rows-1).transpose().multiply(values)
                .getSingleValue()+weights.getFirstRows(1).getSingleValue(), 0);
    }
}
