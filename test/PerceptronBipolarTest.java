import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Dell on 2017-10-09.
 */
public class PerceptronBipolarTest extends LearningTest{

    Matrix andWeights;
    Matrix orWeights;

    @Before
    public void learnAnd(){
        Matrix data = new Matrix(DataGeneratorKt.generateDataArray(parameters.get("trainSize").intValue(),
                parameters.get("precision"), LogicFunctionsKt.getAND_VALUES_BIPOLAR()));
        Perceptron perceptron = new BipolarPerceptron(initWeights, parameters.get("bias"));
        andWeights = Optimiser.learn(perceptron, data, parameters.get("learningRate"),
                parameters.get("theta"), parameters.get("epochs").intValue());
    }

    @Before
    public void learnOr(){
        Matrix data = new Matrix(DataGeneratorKt.generateDataArray(parameters.get("trainSize").intValue(),
                parameters.get("precision"), LogicFunctionsKt.getOR_VALUES_BIPOLAR()));
        Perceptron perceptron = new BipolarPerceptron(initWeights, parameters.get("bias"));
        orWeights = Optimiser.learn(perceptron, data, parameters.get("learningRate"),
                parameters.get("theta"), parameters.get("epochs").intValue());
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
