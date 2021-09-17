package lib.core;

/**
 * Interface to represent a loadable game resource. Examples include {@link lib.sprites.Sprites} and
 * {@link lib.scenes.Scene}. Resources allow for expensive loading processes to take place outside of constructors.
 */
public interface Resource {
    public void load();
}
