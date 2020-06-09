package every.name.counts;

import java.util.List;

public class DachauMatcher implements Matcher {

    @Override
    public Feature matchLastName(List<Feature> features) {
        return features.stream()
                .filter(Feature::isTopHeader)
                .filter(Feature::isLeftColumn)
                .findFirst().orElse(null);
    }

    @Override
    public Feature matchFirstName(List<Feature> features) {
        return null;
    }

    @Override
    public Feature matchPrisonerNumber(List<Feature> features) {
        return features.stream()
                .filter(Feature::isTopHeader)
                .filter(Feature::isRightColumn)
                .filter(Feature::containsNumberOnly)
                .findFirst().orElse(null);
    }

    @Override
    public Feature matchCategory(List<Feature> features) {
        return features.stream()
                .filter(Feature::isTopHeader)
                .filter(Feature::isRightColumn)
                .filter(Feature::containsLettersOnly)
                .findFirst().orElse(null);
    }
}