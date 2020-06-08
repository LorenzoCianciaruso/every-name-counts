package every.name.counts;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class Transcriptor {
    protected List<Feature> features;

    public abstract Prisoner transcript();
}
