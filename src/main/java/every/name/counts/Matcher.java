package every.name.counts;

import java.util.List;

public interface Matcher {

    Feature matchLastName(List<Feature> features);

    Feature matchFirstName(List<Feature> features);

    Feature matchPrisonerNumber(List<Feature> features);

    Feature matchCategory(List<Feature> features);
}
