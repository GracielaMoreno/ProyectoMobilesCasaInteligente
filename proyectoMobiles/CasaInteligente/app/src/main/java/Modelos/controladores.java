package Modelos;


import java.io.Serializable;

public class controladores  implements Serializable{
    private String tipo;
    private int id;
    private String accion;

    public controladores( int id,String tipo, String accion) {
        this.id = id;
        this.tipo = tipo;
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
        return "" +
                "Id= " + id +
                " Tipo= " + tipo + '\'' +
                " Accion= " + accion + '\'';
    }
}
