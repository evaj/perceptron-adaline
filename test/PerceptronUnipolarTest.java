import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Dell on 2017-10-09.
 */
public class PerceptronUnipolarTest {

    Matrix andWeights;
    Matrix orWeights;

    @Before
    public void learnAnd(){
        Map<String, Double> map = ParamReaderKt.getData("params");
        Vector initWeights = new Vector(new double [] {Math.random()*map.get("weightRangeMin"),
                Math.random()*map.get("weightRangeMax")});
        Matrix data = new Matrix(DataGeneratorKt.generateDataArray(map.get("trainSize").intValue(),
                map.get("precision"), LogicFunctionsKt.getAND_VALUES()));
        Perceptron perceptron = new UnipolarPerceptron(initWeights, map.get("bias"));
        andWeights = Optimiser.learn(perceptron, data, map.get("learningRate"), map.get("theta"), map.get("epochs").intValue());
    }

    @Before
    public void learnOr(){
        Map<String, Double> map = ParamReaderKt.getData("params");
        Vector initWeights = new Vector(new double [] {Math.random()*map.get("weightRangeMin"),
                Math.random()*map.get("weightRangeMax")});
        Matrix data = new Matrix(DataGeneratorKt.generateDataArray(map.get("trainSize").intValue(),
                map.get("precision"), LogicFunctionsKt.getOR_VALUES()));
        Perceptron perceptron = new UnipolarPerceptron(initWeights, map.get("bias"));
        orWeights = Optimiser.learn(perceptron, data, map.get("learningRate"), map.get("theta"), map.get("epochs").intValue());
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
