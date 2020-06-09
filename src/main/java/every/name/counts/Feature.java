package every.name.counts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Feature {
    private String text;

    private Float top;
    private Float left;
    private Float height;
    private Float width;

    public boolean isTopHeader() {
        return this.getCentre().getY() < 0.15;
    }

    public boolean isLeftColumn() {
        return this.getCentre().getX() < 0.5;
    }

    public boolean isRightColumn() {
        return this.getCentre().getX() >= 0.5;
    }

    public Point getCentre() {
        return new Point(left + (width / 2), top + (height / 2));
    }

    public boolean containsNumberOnly() {
        return this.getText().matches("[0-9]{3,6}");
    }

    public boolean containsLettersOnly() {
        return this.getText().matches("[a-zA-Z]{2,5}");
    }
}
