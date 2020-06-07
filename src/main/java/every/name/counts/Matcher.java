package every.name.counts;

import java.util.List;

public class Matcher {
    private LastNameMatcher lastNameMatcher = new LastNameMatcher();

    public Prisoner match(List<Feature> features){
        return Prisoner.builder()
                .lastName(lastNameMatcher.match(features).getFeature())
                .prisonerNumber(features.get(1).getFeature())
                .category(features.get(2).getFeature())
                .build();
    }
}
