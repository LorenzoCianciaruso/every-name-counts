package every.name.counts;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LastNameDachauTest {

    private Feature feature1 = Feature.builder()
            .text("Celesnik")
            .left(0.06868945062160492f)
            .top(0.03985276818275452f)
            .height(0.10106863081455231f)
            .width(0.3162499666213989f)
            .build();

    private Feature feature2 = Feature.builder()
            .text("41014")
            .left(0.08785675466060638f)
            .top(0.48806053400039673f)
            .height(0.08209396153688431f)
            .width(0.1909058392047882f)
            .build();

    private Feature feature3 = Feature.builder()
            .text("Sch")
            .left(0.09671636670827866f)
            .top(0.745970606803894f)
            .height(0.10697268694639206f)
            .width(0.07995697855949402f)
            .build();

    private List<Feature> features = Arrays.asList(feature1, feature2, feature3);

    @Test
    public void match() {
        assert new LastNameMatcher().match(features) == feature1;
    }
}
