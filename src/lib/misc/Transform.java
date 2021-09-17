package lib.misc;

import processing.core.PVector;

/**
 * Represents the position and rotation of an entity.
 * Can be parented to another transform. All movements and rotations of the parent transform will be applied to the
 * child transform.
 */
public class Transform {

    public PVector position;
    public float rotation;

    private Transform parent = null;

    public Transform() {
        position = new PVector();
        rotation = 0;
    }

    public Transform(PVector position) {
        this.position = position;
        rotation = 0;
    }

    public Transform(PVector position, float rotation) {
        this.position = position;
        this.rotation = rotation;
    }

    public Transform(float x, float y) {
        this.position = new PVector(x, y);
        this.rotation = 0;
    }

    public Transform(float x, float y, float rotation) {
        this.position = new PVector(x, y);
        this.rotation = rotation;
    }

    public Transform copy() {
        return new Transform(position.copy(), rotation);
    }

    public void setParent(Transform parent) {
        this.parent = parent;
    }

    public boolean hasParent() {
        return parent != null;
    }

    /**
     * Gets the transform corrected for all parents.
     * @return a new transform that has all parent transforms added into it.
     */
    public Transform getParentedTransform() {
        Transform parentedTransform = hasParent() ? parent.getParentedTransform() : new Transform();
        parentedTransform.add(this);
        return parentedTransform;
    }

    public void add(Transform other) {
        position.add(other.position);
        rotation += other.rotation;
    }
}
