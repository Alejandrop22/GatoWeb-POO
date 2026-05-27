import java.io.Serializable;

public class Mensje implements Serializable {
    private String mensaje;
    private int tipo;
    private int comando;
    private String extra;

    public Mensje(int tipo, int comando, String mensaje) {
        this(tipo, comando, mensaje, null);
    }

    public Mensje(int tipo, int comando, String mensaje, String extra) {

        this.extra = extra;
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

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}