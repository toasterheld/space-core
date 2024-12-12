package engine.component.basic;

import engine.component.Component;
import engine.entity.Entity;
import engine.util.Vector2D;

import java.util.ArrayList;

/**
 * Represents a collider component that detects collisions with other colliders.
 * This component is attached to an entity and can be used to detect overlapping or non-overlapping areas.
 */
public class Collider extends Component {

    // List to hold all colliders for collision checking
    public static ArrayList<Collider> colliders = new ArrayList<Collider>();

    private Vector2D size = new Vector2D(0, 0);
    private boolean isTrigger = false; // Determines if this collider is a trigger
    private boolean isColliding = false; // Tracks whether this collider is colliding with others
    Entity parent;

    /**
     * Constructs a Collider component associated with the specified parent entity.
     * The collider is added to the list of all colliders for collision detection.
     *
     * @param parent the parent entity to which this collider component belongs
     */
    public Collider(Entity parent) {
        super(parent);
        this.parent = parent;
        colliders.add(this);
    }

    /**
     * Checks for a collision between this collider and another collider.
     * A collision occurs if their bounding boxes overlap.
     *
     * @param collider the other collider to check for a collision with
     * @return true if the two colliders overlap, false otherwise
     */
    private boolean checkCollision(Collider collider) {
        return !(getPos().getX() + getSize().getX() <= collider.getPos().getX() ||
                getPos().getX() >= collider.getPos().getX() + collider.getSize().getX() ||
                getPos().getY() + getSize().getY() <= collider.getPos().getY() ||
                getPos().getY() >= collider.getPos().getY() + collider.getSize().getY());
    }

    /**
     * Updates the collider's state, checking for collisions with other colliders.
     * If a collision is detected, the overlap values (X and Y) can be used for further logic.
     */
    @Override
    public void update() {
        if (!isTrigger) {
            for (Collider collider : colliders) {
                if (collider != this) {
                    isColliding = (checkCollision(collider));
                }

                if (isColliding) {
                    // Calculate the overlap in both X and Y axes
                    double overlapX = Math.min(getPos().getX() + getSize().getX() - collider.getPos().getX(),
                            collider.getPos().getX() + collider.getSize().getX() - getPos().getX());
                    double overlapY = Math.min(getPos().getY() + getSize().getY() - collider.getPos().getY(),
                            collider.getPos().getY() + collider.getSize().getY() - getPos().getY());
                    // You can add logic here to resolve the collision
                }
            }
        }
    }

    // Getter and Setter methods

    public void setSize(Vector2D size) {
        this.size = size;
    }

    public Vector2D getSize() {
        return size;
    }

    public void setTrigger(boolean trigger) {
        isTrigger = trigger;
    }

    public boolean isTrigger() {
        return isTrigger;
    }

    public boolean isColliding() {
        return isColliding;
    }
}
