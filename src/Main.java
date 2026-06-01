import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            String ipRival = JOptionPane.showInputDialog("IP del rival:");
            String puertoLocalStr = JOptionPane.showInputDialog("Tu puerto ");
            String puertoRivalStr = JOptionPane.showInputDialog("Puerto del rival ");
            String puertoLocalChatStr = JOptionPane.showInputDialog("Tu puerto chat");
            String puertoRivalChatStr = JOptionPane.showInputDialog("Puerto chat del rival");

            int puertoLocal = Integer.parseInt(puertoLocalStr);
            int puertoRival = Integer.parseInt(puertoRivalStr);
            int puertoLocalChat = Integer.parseInt(puertoLocalChatStr);
            int puertoRivalChat = Integer.parseInt(puertoRivalChatStr);

            Tablero tablero = new Tablero();
            tablero.configurar(ipRival, puertoLocal, puertoRival);

            Chat chat = new Chat(null, "Jugador", tablero);
            chat.configurarChatRed(ipRival, puertoLocalChat, puertoRivalChat);

            boolean empiezaDeshabilitado = Boolean.parseBoolean(
                    JOptionPane.showInputDialog("¿Empiezas esperando? true/false:")
            );

            Ventana ventana = new Ventana(empiezaDeshabilitado);
            ventana.setTablero(tablero);
            ventana.setChat(chat);
            ventana.setVisible(true);
        });
    }
}