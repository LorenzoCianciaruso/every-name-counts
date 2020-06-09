package every.name.counts;

import java.util.List;

public class Dachau extends Transcriptor {
    private DachauMatcher dachauMatcher = new DachauMatcher();

    public Dachau(List<Feature> features) {
        this.features = features;
    }

    @Override
    public Prisoner transcript(){
        return Prisoner.builder()
                .lastName(dachauMatcher.matchLastName(this.features).getText())
                .prisonerNumber(this.features.get(1).getText())
                .category(this.features.get(2).getText())
                .build();
    }
}
