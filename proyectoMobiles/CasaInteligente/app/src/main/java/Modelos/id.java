package Modelos;

import java.io.Serializable;

public class id implements Serializable{
    private String id;

    public id(String id) {
        this.id = id;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id{" +
                "id='" + id + '\'' +
                '}';
    }
}
