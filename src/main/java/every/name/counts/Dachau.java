package every.name.counts;

import java.util.List;

public class Dachau extends Transcriptor {
    private LastNameMatcher lastNameMatcher = new LastNameMatcher();

    public Dachau(List<Feature> features) {
        this.features = features;
    }

    @Override
    public Prisoner transcript(){
        return Prisoner.builder()
                .lastName(lastNameMatcher.match(this.features).getText())
                .prisonerNumber(this.features.get(1).getText())
                .category(this.features.get(2).getText())
                .build();
    }
}
