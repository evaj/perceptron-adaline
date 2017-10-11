import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Dell on 2017-10-09.
 */
public class AdalineTest {

    Matrix andWeights;
    Matrix orWeights;

    @Before
    public void learnAnd(){
        Map<String, Double> map = ParamReaderKt.getData("params");
        Vector initWeights = new Vector(new double [] {Math.random()*map.get("weightRangeMin"),
                Math.random()*map.get("weightRangeMax")});
        Matrix data = new Matrix(DataGeneratorKt.generateDataArray(map.get("trainSize").intValue(),
                map.get("precision"), LogicFunctionsKt.getAND_VALUES_BIPOLAR()));
        Perceptron perceptron = new UnipolarPerceptron(initWeights, map.get("bias"));
        andWeights = Optimiser.adalineLearn(perceptron, data, map.get("learningRate"), map.get("desiredError"));
    }

    @Before
    public void learnOr(){
        Map<String, Double> map = ParamReaderKt.getData("params");
        Vector initWeights = new Vector(new double [] {Math.random()*map.get("weightRangeMin"),
                Math.random()*map.get("weightRangeMax")});
        Matrix data = new Matrix(DataGeneratorKt.generateDataArray(map.get("trainSize").intValue(),
                map.get("precision"), LogicFunctionsKt.getOR_VALUES_BIPOLAR()));
        Perceptron perceptron = new BipolarPerceptron(initWeights, map.get("bias"));
        orWeights = Optimiser.adalineLearn(perceptron, data, map.get("learningRate"), map.get("desiredError"));
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
