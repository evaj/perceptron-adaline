import org.junit.Assert;

/**
 * Created by Dell on 2017-10-09.
 */
public class FunctionTestCases {

    public static void checkAndBipolar(Matrix weights){
        Vector vector1 = new Vector(new double[]{0.99, 1.02});
        Vector vector2 = new Vector(new double[]{1., -0.99});
        Vector vector3 = new Vector(new double[]{-1.02, -0.98});
        Vector vector4 = new Vector(new double[]{-1., 1.});
        Assert.assertEquals(1.0, Predictor.predictBipolar(weights, vector1));
        Assert.assertEquals(-1.0, Predictor.predictBipolar(weights, vector2));
        Assert.assertEquals(-1.0, Predictor.predictBipolar(weights, vector3));
        Assert.assertEquals(-1.0, Predictor.predictBipolar(weights, vector4));
    }

    public static void checkAndUnipolar(Matrix weights){
        Vector vector1 = new Vector(new double[]{0.99, 1.02});
        Vector vector2 = new Vector(new double[]{1.03, -0.01});
        Vector vector3 = new Vector(new double[]{-0.2, -0.98});
        Vector vector4 = new Vector(new double[]{-0.02, 1.});
        Assert.assertEquals(1.0, Predictor.predictUnipolar(weights, vector1));
        Assert.assertEquals(0.0, Predictor.predictUnipolar(weights, vector2));
        Assert.assertEquals(0.0, Predictor.predictUnipolar(weights, vector3));
        Assert.assertEquals(0.0, Predictor.predictUnipolar(weights, vector4));
    }

    public static void checkOrBipolar(Matrix weights){
        Vector vector1 = new Vector(new double[]{0.99, 1.02});
        Vector vector2 = new Vector(new double[]{1., -0.97});
        Vector vector3 = new Vector(new double[]{-1.2, -0.98});
        Vector vector4 = new Vector(new double[]{-1., 1.});
        Assert.assertEquals(1.0, Predictor.predictBipolar(weights, vector1));
        Assert.assertEquals(1.0, Predictor.predictBipolar(weights, vector2));
        Assert.assertEquals(-1.0, Predictor.predictBipolar(weights, vector3));
        Assert.assertEquals(1.0, Predictor.predictBipolar(weights, vector4));
    }

    public static void checkOrUnipolar(Matrix weights){
        Vector vector1 = new Vector(new double[]{0.99, 1.02});
        Vector vector2 = new Vector(new double[]{1., 0.02});
        Vector vector3 = new Vector(new double[]{0.01, -0.01});
        Vector vector4 = new Vector(new double[]{-0.02, 1.});
        Assert.assertEquals(1.0, Predictor.predictUnipolar(weights, vector1));
        Assert.assertEquals(1.0, Predictor.predictUnipolar(weights, vector2));
        Assert.assertEquals(0.0, Predictor.predictUnipolar(weights, vector3));
        Assert.assertEquals(1.0, Predictor.predictUnipolar(weights, vector4));
    }
}
