import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Dell on 2017-10-09.
 */
public class PerceptronUnipolarTest extends LearningTest{

    Matrix andWeights;
    Matrix orWeights;

    @Before
    public void learnAnd(){
        Matrix data = new Matrix(DataGeneratorKt.generateDataArray(parameters.get("trainSize").intValue(),
                parameters.get("precision"), LogicFunctionsKt.getAND_VALUES()));
        Perceptron perceptron = new UnipolarPerceptron(initWeights, parameters.get("bias"));
        andWeights = Optimiser.learn(perceptron, data, parameters.get("learningRate"), parameters.get("theta"), parameters.get("epochs").intValue());
    }

    @Before
    public void learnOr(){
        Matrix data = new Matrix(DataGeneratorKt.generateDataArray(parameters.get("trainSize").intValue(),
                parameters.get("precision"), LogicFunctionsKt.getOR_VALUES()));
        Perceptron perceptron = new UnipolarPerceptron(initWeights, parameters.get("bias"));
        orWeights = Optimiser.learn(perceptron, data, parameters.get("learningRate"), parameters.get("theta"), parameters.get("epochs").intValue());
    }

    @Test
    public void checkAndUnipolar(){
        FunctionTestCases.checkAndUnipolar(andWeights);
    }

    @Test
    public void checkOrUnipolar(){
        FunctionTestCases.checkOrUnipolar(orWeights);
    }
}
