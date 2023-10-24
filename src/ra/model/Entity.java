package ra.model;

import java.io.Serializable;

public class Entity<ID extends Number> implements Serializable {
    protected ID id;

    public Entity() {

    }

    public Entity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
