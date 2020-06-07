package every.name.counts;

import java.util.List;

public class Matcher {
    public Prisoner match(List<Feature> features){
        return Prisoner.builder()
                .lastName(features.get(0).getFeature())
                .prisonerNumber(features.get(1).getFeature())
                .category(features.get(2).getFeature())
                .build();
    }
}
