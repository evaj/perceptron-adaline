/**
 * Created by Dell on 2017-10-09.
 */
abstract class Perceptron {
    private Matrix wages;
    private double bias;

    public Perceptron(){
        wages = new Matrix();
        bias = 0.0;
    }

    public Perceptron(Matrix wages, double bias) {
        this.wages = wages;
        this.bias = bias;
    }

    abstract double predict(Vector inputs, double threshold);

    public double net(Vector inputs){
        return wages.transpose().multiply(inputs).getSingleValue() + bias;
    }

    public Matrix getWages() {
        return wages;
    }

    public void setWages(Matrix wages) {
        this.wages = wages;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }
}
