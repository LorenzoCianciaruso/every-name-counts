package every.name.counts;

import org.junit.Test;

public class FeatureTest {

    @Test
    public void getCentre(){
        Feature feature = Feature.builder()
                .text("Some text")
                .width(270f)
                .height(100f)
                .left(40f)
                .top(50f)
                .build();

        Point centre = feature.getCentre();

        assert centre.getX() == 40f + (270f / 2);
        assert centre.getY() == 50f + (100f / 2);
    }

}
