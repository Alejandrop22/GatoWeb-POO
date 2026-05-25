import javax.swing.*;

public class Ventana extends JFrame  {

    private Tablero tablero;
    private boolean empiezaDeshabilitado;

    public Ventana(boolean empiezaDeshabilitado){
        this.empiezaDeshabilitado = empiezaDeshabilitado;

        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void setTablero(Tablero tablero){
        this.tablero = tablero;
        add(this.tablero);

        if (empiezaDeshabilitado) {
            this.tablero.deshabilitarBotones();
        } else {
            this.tablero.habilitarBotones();
        }
    }

}
