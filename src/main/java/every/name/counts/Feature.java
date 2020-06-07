package every.name.counts;

import lombok.Getter;

@Getter
public class Feature {
    private String feature;
    private Position position;

    public Feature(String feature, double top, double left) {
        this.feature = feature;
        this.position = new Position(top, left);
    }
}
