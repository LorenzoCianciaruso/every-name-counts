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
        return top < (1.0 / 8);
    }

    public boolean isLeftColumn() {
        return left < 0.4;
    }

    public Point getCentre() {
        return new Point(left + (width / 2), top + (height / 2));
    }
}
