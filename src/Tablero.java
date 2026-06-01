import javax.swing.*;
import java.awt.*;

public class Tablero extends JPanel {

    Cliente cliente = new Cliente();
    Juego juego = new Juego();
    JButton[][] tablero;

    String ipRival;
    int puertoLocal;
    int puertoRival;

    public Tablero() {
        setLayout(new GridLayout(3, 3));
        tablero = new JButton[3][3];
        generarTablero();
    }

    public void configurar(String ipRival, int puertoLocal, int puertoRival) {
        this.ipRival = ipRival;
        this.puertoLocal = puertoLocal;
        this.puertoRival = puertoRival;
        escucharMensaje(puertoLocal);
    }

    public void generarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton boton = new JButton();
                final int x = i;
                final int y = j;

                tablero[i][j] = boton;
                add(boton);

                boton.addActionListener(e -> {
                    if (boton.getText().equals("X") || boton.getText().equals("O")) return;

                    int ganador = juego.recibirCoordenadas(x, y);
                    actualizarBoton(x, y);

                    enviarMensaje(ipRival, x + "," + y, puertoRival);
                    deshabilitarBotones();

                    if (ganador == 1 || ganador == -1) {
                        reiniciarTablero();
                        juego.reiniciarJuego();
                    }
                });
            }
        }
    }

    public void escucharMensaje(int puerto) {
        new Thread(() -> {
            while (true) {
                Servidor servidor = new Servidor(puerto);
                String mensaje = servidor.mensajeEntrante();

                int x = mensaje.charAt(0) - 48;
                int y = mensaje.charAt(2) - 48;

                SwingUtilities.invokeLater(() -> {
                    int ganador = juego.recibirCoordenadas(x, y);
                    actualizarBoton(x, y);
                    habilitarBotones();

                    if (ganador == 1 ) {
                        JOptionPane.showMessageDialog(null, "X gano");
                        reiniciarTablero();
                        juego.reiniciarJuego();
                    }
                    if (ganador == -1) {
                        JOptionPane.showMessageDialog(null, "O gano");
                        reiniciarTablero();
                        juego.reiniciarJuego();
                    }
                });
            }
        }).start();
    }

    public void enviarMensaje(String ip, String mensaje, int puerto) {
        new Thread(() -> {
            cliente.mensaje_Saliente(ip, mensaje, puerto);
        }).start();
    }

    public void actualizarBoton(int x, int y) {
        if (juego.tablero[x][y] == 1) {
            tablero[x][y].setText("X");
        } else if (juego.tablero[x][y] == -1) {
            tablero[x][y].setText("O");
        }
    }

    public void reiniciarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j].setText("");
            }
        }
        habilitarBotones();
        juego.reiniciarJuego();
    }

    public void habilitarBotones() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].getText().equals("")) {
                    tablero[i][j].setEnabled(true);
                }
            }
        }
    }

    public void deshabilitarBotones() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j].setEnabled(false);
            }
        }
    }
}