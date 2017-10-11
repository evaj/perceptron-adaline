/**
 * Created by Dell on 2017-10-09.
 */
public class UnipolarPerceptron extends Perceptron {

    public UnipolarPerceptron(Matrix wages, double bias) {
        super(wages, bias);
    }

    public double predict(Vector inputs, double threshold){
        return Activation.unipolar(net(inputs), threshold);
    }
}
