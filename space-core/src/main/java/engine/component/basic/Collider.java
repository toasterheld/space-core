package engine.component.basic;

import engine.component.Component;
import engine.entity.Entity;

import java.util.ArrayList;

public class Collider extends Component {

    public static ArrayList<Collider> colliders = new ArrayList<Collider>();

    public Collider(Entity parent) {

        super(parent);
        colliders.add(this);
    }





}
