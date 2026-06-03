public class HiloRecepcion implements Runnable {

    private final int puerto;
    private final Mensajeador handler;

    public HiloRecepcion(int puerto, Mensajeador handler) {
        this.puerto = puerto;
        this.handler = handler;
    }

    @Override
    public void run() {
        while (true) {
            Servidor servidor = new Servidor(puerto);
            String mensaje = servidor.mensajeEntrante();

            if (mensaje != null) {
                handler.recibirMensaje(mensaje);
            }
        }
    }
}