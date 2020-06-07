package every.name.counts;

import lombok.Getter;

@Getter
public class Position {
    private double top;
    private double left;

    public Position(double top, double left) {
        this.top = top;
        this.left = left;
    }
}
