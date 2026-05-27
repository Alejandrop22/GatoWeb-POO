import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame  {

    private Tablero tablero;
    private Chat chat;
    private boolean empiezaDeshabilitado;

    public Ventana(boolean empiezaDeshabilitado){
        this.empiezaDeshabilitado = empiezaDeshabilitado;

        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 2));
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

    public void setChat(Chat chat) {
        this.chat = chat;
        add(this.chat);
    }

}
