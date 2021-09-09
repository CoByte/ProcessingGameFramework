package main.misc;

/**
 * Represents a thing that can trigger, like a button or timer. Has a few methods for determining useful stuff.
 */
public class Trigger {
    private boolean wasTriggered = false;
    private boolean isTriggered = false;

    /**
     * Call when the trigger is activated.
     */
    public void activate() {
        wasTriggered = isTriggered;
        isTriggered = true;
    }

    /**
     * Call when the trigger is deactivated
     */
    public void deactivate() {
        wasTriggered = isTriggered;
        isTriggered = false;
    }

    /**
     * @return if the trigger is on the rising edge of its activation (e.g. if a button was just pressed)
     */
    public boolean rising() {
        return !wasTriggered && isTriggered;
    }

    /**
     * @return if the trigger is on the falling edge of its activation (e.g. if a button was just released)
     */
    public boolean falling() {
        return wasTriggered && !isTriggered;
    }

    public boolean triggered() {
        return isTriggered;
    }
}
