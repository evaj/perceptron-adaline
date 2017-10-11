/**
 * Created by Dell on 2017-10-08.
 */
public class BipolarPerceptron extends Perceptron{

    public BipolarPerceptron(Matrix wages, double bias) {
        super(wages, bias);
    }

    public double predict(Vector inputs, double threshold){
        return Activation.bipolar(net(inputs), threshold);
    }
}
