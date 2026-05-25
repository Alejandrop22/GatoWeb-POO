import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Emmanuelle Ruelas
 *
 */
public class Servidor {
    private final int puerto;

    /** Crea una nueva instancia para el servidor */
    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    public String mensajeEntrante() {
        try (
                ServerSocket servidor = new ServerSocket(puerto);
                Socket socket = servidor.accept();
                ObjectInputStream flujoEntrada = new ObjectInputStream(socket.getInputStream())
        ) {
            System.out.println("Servidor [" + InetAddress.getLocalHost().getHostAddress() + "] listo y escuchando...");
            System.out.println(socket.getInetAddress());

            return (String) flujoEntrada.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}