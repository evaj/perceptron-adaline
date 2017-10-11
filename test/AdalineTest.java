import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Dell on 2017-10-09.
 */
public class AdalineTest extends LearningTest{

    Matrix andWeights;
    Matrix orWeights;

    @Before
    public void learnAnd(){
        Matrix data = new Matrix(DataGeneratorKt.generateDataArray(parameters.get("trainSize").intValue(),
                parameters.get("precision"), LogicFunctionsKt.getAND_VALUES_BIPOLAR()));
        Perceptron perceptron = new UnipolarPerceptron(initWeights, parameters.get("bias"));
        andWeights = Optimiser.adalineLearn(perceptron, data,
                parameters.get("learningRate"), parameters.get("desiredError"));
    }

    @Before
    public void learnOr(){
        Matrix data = new Matrix(DataGeneratorKt.generateDataArray(parameters.get("trainSize").intValue(),
                parameters.get("precision"), LogicFunctionsKt.getOR_VALUES_BIPOLAR()));
        Perceptron perceptron = new BipolarPerceptron(initWeights, parameters.get("bias"));
        orWeights = Optimiser.adalineLearn(perceptron, data,
                parameters.get("learningRate"), parameters.get("desiredError"));
    }

    @Test
    public void checkAndBipolar(){
        FunctionTestCases.checkAndBipolar(andWeights);
    }

    @Test
    public void checkOrBipolar(){
        FunctionTestCases.checkOrBipolar(orWeights);
    }
}
