import java.util.Map;

/**
 * Created by Dell on 2017-10-12.
 */
public class LearningTest {

    protected Map<String, Double> parameters;
    protected Matrix data;
    protected Vector initWeights;

    public LearningTest(){
        init();
    }

    private void init(){
        parameters = ParamReaderKt.getData("params");
        initWeights = new Vector(new double [] {Math.random()*parameters.get("weightRangeMin"),
                Math.random()*parameters.get("weightRangeMax")});

    }
}
