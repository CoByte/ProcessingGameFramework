package lib.misc;

import lib.core.Displayable;
import processing.core.PVector;

/**
 * Adds a bound on the displayable, so that it can be rendered orthographically.
 */
public interface BoundedDisplayable extends Displayable {
    /**
     * @return the the size of the display bounding box, NOT the collision box.
     */
    public PVector getDisplaySize();
}
