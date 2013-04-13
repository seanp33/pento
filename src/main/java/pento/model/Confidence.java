package pento.model;

public enum Confidence {

    NONE(0, "None"),
    LOCAL(1, "Local"),
    GLOBAL(2, "Global"),
    UNIVERSAL(3, "Universal");

    private final double level;
    private final String name;

    Confidence(double level, String name) {
        this.level = level;
        this.name = name;
    }
}
