import java.io.Serializable;

public class Mensje implements Serializable {
    private String mensaje;
    private int tipo;
    private int comando;

    public Mensje(int tipo, int comando, String mensaje) {
        this.tipo = tipo;
        this.comando = comando;
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getComando() {
        return comando;
    }

    public void setComando(int comando) {
        this.comando = comando;
    }
}