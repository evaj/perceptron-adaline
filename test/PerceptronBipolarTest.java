import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Dell on 2017-10-09.
 */
public class PerceptronBipolarTest extends LogicFunctionTest{

    @Before
    public void learnAnd(){
        reloadData(LogicFunctionsKt.getAND_VALUES_BIPOLAR());
        Perceptron perceptron = new BipolarPerceptron(initWeights, parameters.get("bias"));
        andWeights = Optimiser.learn(perceptron, data, parameters.get("learningRate"),
                parameters.get("theta"), parameters.get("epochs").intValue());
    }

    @Before
    public void learnOr(){
        reloadData(LogicFunctionsKt.getOR_VALUES_BIPOLAR());
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
