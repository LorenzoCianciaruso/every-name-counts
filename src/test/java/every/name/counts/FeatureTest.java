package every.name.counts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FeatureTest {

    private String input;
    private boolean output;

    public FeatureTest(String input, boolean output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "1.4.13", true },
                { "11.04.13", true },
                { "5.8.1943", true },
                { "06.09.1919", true },
                { "6. Dez. 1942", true },
                { "06. Dez. 42", true },
                { "06. Dez. 1942", true },
                { "06.Dez.1942", true },
                { "06. dez. 1942", true },
                { "06.dez.1942", true },
                { "6. Dez. 1942 hatas", true}
//                ,
//                { "6. Des. 1942 hatas", true}
        });
    }

    @Test
    public void isADate() {
        Feature feature = Feature.builder()
                .text(input)
                .build();

        assert feature.isADate() == output;
    }

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
