package lib.entity;

import lib.core.Displayable;
import lib.misc.Transform;
import lib.core.Updatable;

public abstract class Entity implements Updatable, Displayable {
    public Transform position;
}
