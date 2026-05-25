import javax.swing.*;

public class Ventana extends JFrame  {

    private Tablero tablero;

    public Ventana(){

        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void setTablero(Tablero tablero){
        this.tablero = tablero;
        add(this.tablero);

    }

}
