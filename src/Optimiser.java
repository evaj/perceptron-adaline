/**
 * Created by Dell on 2017-10-08.
 */
public class Optimiser {

    public static Matrix learn(Perceptron perceptron, Matrix data, double learningRate, double threshold, int epochs){
        for(int i = 0; i < epochs; i++){
            data.shuffle();
            Matrix trainX = data.getFirstColumns(2);
            Vector trainY = (Vector)data.getLastColumns(1);
            double epochError = 0;
            for(int j = 0; j < trainX.getRows(); j++) {
                double error = Error.binary(trainY.getElem(j), perceptron.predict(trainX.getRow(j), threshold));
                updateWages(perceptron, error, learningRate, trainX.getRow(j));
                epochError += error;
            }
//            System.out.println("Error: "+epochError);
        }
        return new Vector(new double[] {perceptron.getBias()}).joinVertically(perceptron.getWages());
    }

    public static Matrix adalineLearn(Perceptron perceptron, Matrix data, double desiredError, double learningRate){
        double error = Integer.MAX_VALUE;
        while(Math.abs(error) > desiredError) {
            error = 0;
            data.shuffle();
            Matrix trainX = data.getFirstColumns(2);
            Vector trainY = (Vector)data.getLastColumns(1);
            for(int j = 0; j < trainX.getRows(); j++) {
                double currentError = Error.meanSquare(trainY.getElem(j), perceptron.net(trainX.getRow(j)));
                error += currentError;
                updateWages(perceptron, currentError, learningRate, trainX.getRow(j));
            }
        }
        return new Vector(new double[] {perceptron.getBias()}).joinVertically(perceptron.getWages());
    }

    private static void updateWages(Perceptron perceptron, double error, double learningRate, Vector sample){
        perceptron.setWages(perceptron.getWages().add(MatrixOperationKt.operate(
                learningRate*error, sample, MatrixOperationKt.getMultiply())));
        perceptron.setBias(perceptron.getBias()+(learningRate*error));
    }
}
