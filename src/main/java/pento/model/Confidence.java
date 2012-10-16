package pento.model;

/**
 * Created by IntelliJ IDEA.
 * User: smonaghan
 * Date: 10/13/12
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
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
