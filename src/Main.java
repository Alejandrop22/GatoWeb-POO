import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            String ipRival = JOptionPane.showInputDialog("IP del rival:");
            String puertoLocalStr = JOptionPane.showInputDialog("Tu puerto (ej: 5000):");
            String puertoRivalStr = JOptionPane.showInputDialog("Puerto del rival (ej: 5001):");

            int puertoLocal = Integer.parseInt(puertoLocalStr);
            int puertoRival = Integer.parseInt(puertoRivalStr);

            Tablero tablero = new Tablero();
            tablero.configurar(ipRival, puertoLocal, puertoRival);
            tablero.escucharMensaje(puertoLocal);

            Ventana ventana = new Ventana();
            ventana.setTablero(tablero);
            ventana.setVisible(true);
        });
    }
}