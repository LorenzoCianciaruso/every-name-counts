package every.name.counts;

import java.util.List;

public class Matcher {
    public Prisoner match(List<String> features){
        return Prisoner.builder()
                .lastName(features.get(0))
                .prisonerNumber(features.get(1))
                .category(features.get(2))
                .build();
    }
}
