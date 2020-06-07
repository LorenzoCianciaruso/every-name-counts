package every.name.counts;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LastNameMatcherTest {

    private Feature feature1 = new Feature("Celesnik", 0.06868945062160492, 0.03985276818275452);
    private Feature feature2 = new Feature("41014", 0.08785675466060638, 0.48806053400039673);
    private Feature feature3 = new Feature("Sch", 0.09671636670827866, 0.745970606803894);
    private Feature feature4 = new Feature("RudolJ", 0.21229708194732666, 0.06391783803701401);
    private Feature feature5 = new Feature("1.8505", 0.20976382493972778, 0.7893207669258118);
    private Feature feature6 = new Feature("alkwalger", 0.32737958431243896, 0.07391248643398285);
    private Feature feature7 = new Feature("Ass ing", 0.3322693705558777, 0.5208075642585754);
    private Feature feature8 = new Feature("6. Des. 1942 hatas", 0.4207049012184143, 0.06321512162685394);
    private Feature feature9 = new Feature("-decies", 0.5346527099609375, 0.05920212343335152);
    private Feature feature10 = new Feature("20.Feb. 1943", 0.6124176383018494, 0.12120800465345383);
    private Feature feature11 = new Feature("0.2 rk.Jugoslawe", 0.6624932289123535, 0.5232762098312378);
    private Feature feature12 = new Feature("L.R.O", 0.7770298719406128, 0.011111151427030563);
    private Feature feature13 = new Feature("Jterbeuvlunde Jterbeuwl hunde", 0.8260374665260315, 0.011868102476000786);

    private List<Feature> features = Arrays.asList(
            feature2,
            feature1,
            feature3,
            feature4,
            feature5,
            feature6,
            feature7,
            feature8,
            feature9,
            feature10,
            feature11,
            feature12,
            feature13
    );

    @Test
    public void match() {
        assert new LastNameMatcher().match(features) == feature1;
    }
}
