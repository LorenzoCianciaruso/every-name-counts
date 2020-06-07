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

    public boolean isTopHeader() {
        return position.getTop() < (1.0 / 8);
    }

    public boolean isLeftColumn() {
        return position.getLeft() < 0.4;
    }
}
