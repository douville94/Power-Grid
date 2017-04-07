package cs301.power_grid;

import java.io.Serializable;

/**
 * @author Luchini Guilian, Tibbetts Nathan, Douville Luke, Hoang Paul
 */

public class ResourceStore implements Serializable {
    // to satisfy Serializable interface
    private static final long serialVersionUID = 31848692918354L;

    public boolean[] coal = new boolean[15];
    public boolean[] oil = new boolean[10];
    public boolean[] trash = new boolean[15];
    public boolean[] uranium = new boolean[5];

}
