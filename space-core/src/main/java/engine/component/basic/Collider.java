package engine.component.basic;

import engine.component.Component;
import engine.entity.Entity;
import engine.util.Vector2D;

import java.util.ArrayList;

public class Collider extends Component {

    public static ArrayList<Collider> colliders = new ArrayList<Collider>();

    private Vector2D size = new Vector2D(0,0);
    private boolean isTrigger = false;
    private boolean isColliding = false;
    Entity parent;

    public Collider(Entity parent) {

        super(parent);
        this.parent = parent;
        colliders.add(this);
    }

    private boolean checkCollision(Collider collider) {
        return !(getPos().getX() + getSize().getX() <= collider.getPos().getX() ||
                getPos().getX() >= collider.getPos().getX() + collider.getSize().getX() ||
                getPos().getY() + getSize().getY() <= collider.getPos().getY() ||
                getPos().getY() >= collider.getPos().getY() + collider.getSize().getY());
    }

    @Override
    public void update() {
        if(!isTrigger) {
            for (Collider collider : colliders) {
                if(collider != this) {
                    isColliding = (checkCollision(collider));
                }

                if(isColliding) {
                    double overlapX = Math.min(getPos().getX() + getSize().getX() - collider.getPos().getX(),
                            collider.getPos().getX() + collider.getSize().getX() - getPos().getX());
                    double overlapY = Math.min(getPos().getY() + getSize().getY() - collider.getPos().getY(),
                            collider.getPos().getY() + collider.getSize().getY() - getPos().getY());

                }
            }
        }
    }


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
