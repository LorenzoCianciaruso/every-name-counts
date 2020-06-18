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
        return features.stream()
                .filter(Feature::isLeftColumn)
                .filter(Feature::isSecondRow)
                .findFirst().orElse(null);
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

    @Override
    public Feature matchDateOfBirth(List<Feature> features) {
        return features.stream()
                .filter(Feature::isRightColumn)
                .filter(Feature::isSecondRow)
                .filter(Feature::isADate)
                .findFirst().orElse(null);
    }

    @Override
    public Feature matchProfession(List<Feature> features) {
        return features.stream()
                .filter(Feature::isLeftColumn)
                .filter(Feature::isThirdRow)
                .findFirst().orElse(null);
    }

    @Override
    public Feature matchImprisonmentDate(List<Feature> features) {
        return features.stream()
                .filter(Feature::isLeftColumn)
                .filter(Feature::isFourthRow)
                .filter(Feature::isADate)
                .findFirst().orElse(null);
    }

}
