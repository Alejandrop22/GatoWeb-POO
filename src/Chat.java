import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JPanel implements ActionListener {
    private JTextArea txtarea;
    private JTextField txtfield;
    private JButton btnenviar;
    private Chat otroChat;
    private String nombre;
    private Tablero tableroPanel;

    private Cliente cliente = new Cliente();
    private String ipRival;
    private int puertoLocalChat;
    private int puertoRivalChat;

    public Chat(Chat otroChat, String nombre, Tablero tableroPanel) {
        this.tableroPanel = tableroPanel;
        this.otroChat = otroChat;
        this.nombre = nombre;
        initComponent();
    }

    public Chat(Chat otroChat, String nombre) {
        this(otroChat, nombre, null);
    }

    private void initComponent() {
        txtarea = new JTextArea();
        txtarea.setEditable(false);
        txtfield = new JTextField();
        btnenviar = new JButton("Enviar");

        btnenviar.addActionListener(this);

        setLayout(new BorderLayout(10, 10));

        JScrollPane scrollPane = new JScrollPane(txtarea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout(8, 8));
        panelInferior.add(txtfield, BorderLayout.CENTER);
        panelInferior.add(btnenviar, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);

        txtarea.setLineWrap(true);
        txtarea.setWrapStyleWord(true);
    }

    public void configurarChatRed(String ipRival, int puertoLocalChat, int puertoRivalChat) {
        this.ipRival = ipRival;
        this.puertoLocalChat = puertoLocalChat;
        this.puertoRivalChat = puertoRivalChat;
        iniciarServidorChat();
    }

    private void iniciarServidorChat() {
        new Thread(() -> {
            while (true) {
                Servidor servidor = new Servidor(puertoLocalChat);
                String mensaje = servidor.mensajeEntrante();

                if (mensaje == null) {
                    continue;
                }

                SwingUtilities.invokeLater(() -> procesarMensajeDeRed(mensaje));
            }
        }).start();
    }

    private void procesarMensajeDeRed(String mensaje) {

        String[] partes = mensaje.split("\\|", 3);

        String remitente = partes[1];
        String texto = partes[2];

        Mensje msg = codificar(texto);
        recibirMensaje(msg, remitente, false);
    }

    private void enviarChatPorRed(Mensje msg) {
        String mensajeRed = "CHAT|" + nombre + "|" + msg.getMensaje();

        new Thread(() -> {
            cliente.mensaje_Saliente(ipRival, mensajeRed, puertoRivalChat);
        }).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnenviar) {
            String texto = txtfield.getText();

            Mensje msg = codificar(texto);

            this.recibirMensaje(msg, this.nombre, true);
            enviarChatPorRed(msg);

            txtfield.setText("");
        }
    }

    public void setOtroChat(Chat otroChat) {
        this.otroChat = otroChat;
    }

    public Chat getOtroChat() {
        return otroChat;
    }

    public void setTableroPanel(Tablero tableroPanel) {
        this.tableroPanel = tableroPanel;
    }

    public Tablero getTableroPanel() {
        return tableroPanel;
    }

    public void acutualizarChat(String mensaje, String nombreRemitente, boolean esLocal) {
        if (esLocal) {
            txtarea.append("yo: " + mensaje + "\n");
        } else {
            txtarea.append(nombreRemitente + ": " + mensaje + "\n");
        }
    }

    public Mensje codificar(String texto) {

        String cmd = texto;

        if (!cmd.startsWith("/")) {
            return new Mensje(2, 0, texto);
        }

        if (cmd.equals("/exit")) {
            return new Mensje(1, 1, texto);
        }

        if (cmd.equals("/help")) {
            return new Mensje(1, 2, texto);
        }

        if (cmd.equals("/reset")) {
            return new Mensje(1, 3, texto);
        }

        return new Mensje(1, 0, texto);
    }

    public void recibirMensaje(Mensje msg, String remitente, boolean esLocal) {
        if (msg.getTipo() == 2) {
            acutualizarChat(msg.getMensaje(), remitente, esLocal);
            return;
        }

        if (msg.getTipo() != 1) return;

        if (msg.getComando() == 1) {
            txtarea.append("Cerrando\n");
            System.exit(0);

        } else if (msg.getComando() == 2) {
            txtarea.append("Comandos:, /exit, /help, /reset\n");

        } else if (msg.getComando() == 3) {
            txtarea.append("Reiniciando tablero...\n");

            if (tableroPanel != null) {
                tableroPanel.reiniciarTablero();
            } else {
                txtarea.append("No hay tablero conectado al chat\n");
            }

        } else  {
            txtarea.append("Comando desconocido. Usa /help\n");
        }
    }
}