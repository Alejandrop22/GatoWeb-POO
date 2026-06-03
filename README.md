GatoWeb-POO es un juego de Gato (Tic-Tac-Toe) multijugador en tiempo real desarrollado en Java, donde dos jugadores se conectan entre sí directamente mediante sockets para jugar desde distintas computadoras en red. El proyecto cuenta con una interfaz gráfica construida con Java Swing que integra tanto el tablero de juego como un chat en tiempo real, permitiendo a los jugadores comunicarse durante la partida.
Este proyecto nos sirvió para aplicar los conceptos de Programación Orientada a Objetos como herencia, interfaces y encapsulamiento, así como para comprender el funcionamiento de la comunicación cliente-servidor mediante sockets, el manejo de hilos para la recepción de mensajes en paralelo y la construcción de interfaces gráficas con componentes de Swing.

Para jugar en dos computadores diferentes sigue los siguientes pasos:

1. Descarga este repositorio en ambas computadoras.
2. Selecciona tu IDE de confianza y abre el proyecto en ambas computadoras nuevamente.
3. Asegúrate de que ambas computadoras estén conectadas a la misma red.
4. Compila el Main en ambas computadoras.
5. Cada jugador tendrá que ingresar el IP del contrincante.
6. Asegúrate de ingresar el mismo puerto de tablero para ambos jugadores.
7. Asegúrate de ingresar un puerto distinto que el anterior pero el mismo puerto de tablero para ambos jugadores.
8. Si seguiste bien los pasos, ¡ya estarás conectado con tu contrincante en el tablero! Ahora utiliza los siguientes comandos para disfrutar tu partida.

Ejemplo:

Ventana 1   -> Cliente 9000
            -> Servidor 9000
            
Ventana 2   -> CLiente 9000
            -> Servidor 9000

Para jugar en una sola computadora sigue los siguientes pasos:

1. Descarga este repositorio en tu computadora.
2. Selecciona tu IDE de confianza y abre el proyecto tu computadora nuevamente.
3. Compila el Main dos veces.
4. Ingresa la IP local o la tu propia IP dos veces.
5. Asegúrate de ingresar un puerto distinto para cliente y para servidor y en la otra ventana en el puerto cliente pon el que colocaste para servidor y viceversa. 
   Servidor 
6. Asegúrate de ingresar un puerto distinto que el anterior pero el mismo puerto de tablero para ambos jugadores.
7. Si seguiste bien los pasos, ¡ya estarás conectado contigo mismo mediante red! Ahora utiliza los siguientes comandos para disfrutar tu partida.

Ejemplo:

Ventana 1   -> Cliente 9000
            -> Servidor 9001
            
Ventana 2   -> CLiente 9001
            -> Servidor 9000


COMANDOS

/help
Escribe en el chat global la lista de comandos existentes.

/exit
Cierra ambas ventanas y termina la ejecucion de ambos programas.

/reset
Manda a llamar los los metodos habilitarbotones y reiniciarjuego de las clases tablero y juego respectivamente en ambas ventanas.
