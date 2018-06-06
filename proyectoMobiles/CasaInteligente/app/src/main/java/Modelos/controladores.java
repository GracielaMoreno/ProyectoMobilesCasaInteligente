package Modelos;

public class controladores {
    private String tipo;
    private int id;
   private String accion;

    public controladores(String tipo, int id, String accion) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
                ", id=" + id +
                ", accion='" + accion + '\'' +
                '}';
    }
}
