package every.name.counts;

import java.util.List;

public class LastNameMatcher {

    public Feature match(List<Feature> features) {
        return features.stream()
                .filter(Feature::isTopHeader)
                .filter(Feature::isLeftColumn)
                .findFirst().orElse(null);
    }
}
