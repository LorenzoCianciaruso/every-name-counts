package every.name.counts;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DachauMatcherTest {

    private Feature feature1 = Feature.builder()
            .text("Celesnik")
            .left(0.06868945062160492f)
            .top(0.03985276818275452f)
            .height(0.10106863081455231f)
            .width(0.3162499666213989f)
            .build();

    private Feature feature2 = Feature.builder()
            .text("41014")
            .left(0.48806053400039673f)
            .top(0.08785675466060638f)
            .height(0.08209396153688431f)
            .width(0.1909058392047882f)
            .build();

    private Feature feature3 = Feature.builder()
            .text("Sch")
            .left(0.745970606803894f)
            .top(0.09671636670827866f)
            .height(0.07995697855949402f)
            .width(0.10697268694639206f)
            .build();

    private Feature feature4 = Feature.builder()
            .text("RudolJ")
            .width(0.178743377327919f)
            .height(0.05900321900844574f)
            .left(0.06391783803701401f)
            .top(0.21229708194732666f)
            .build();

    private Feature feature5 = Feature.builder()
            .text("1.8505")
            .width(0.16593046486377716f)
            .height(0.07100813090801239f)
            .left(0.7893207669258118f)
            .top(0.20976382493972778f)
            .build();

    private List<Feature> features = Arrays.asList(feature1, feature2, feature3, feature4, feature5);

    private Matcher matcher = new DachauMatcher();

    @Test
    public void matchLastName() {
        assert matcher.matchLastName(features) == feature1;
    }

    @Test
    public void matchPrisonerNumber() {
        assert matcher.matchPrisonerNumber(features) == feature2;
    }

    @Test
    public void matchCategory() {
        assert matcher.matchCategory(features) == feature3;
    }

    @Test
    public void matchFirstName() {
        assert matcher.matchFirstName(features) == feature4;
    }

    @Test
    public void matchDateOfBirth() {
        assert matcher.matchDateOfBirth(features) == feature5;
    }
}
