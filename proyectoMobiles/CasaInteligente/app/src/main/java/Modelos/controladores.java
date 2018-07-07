package Modelos;


import java.io.Serializable;

public class controladores  implements Serializable{
    private String tipo;
    private String id;
    private String accion;

    public controladores(String tipo, String id, String accion) {
        this.tipo = tipo;
        this.id = id;
        this.accion = accion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    @Override
    public String toString() {
        return "controladores{" +
                "tipo='" + tipo + '\'' +
                ", id='" + id + '\'' +
                ", accion='" + accion + '\'' +
                '}';
    }
}
