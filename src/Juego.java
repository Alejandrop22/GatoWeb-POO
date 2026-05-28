public class Juego {

    int[][] tablero = new int[3][3];
    int turno = 0;

    public int recibirCoordenadas(int x ,int y){
        turno++;
            tablero[x][y] = turno%2==0?1:-1;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }
            return revisarGanador();
    }

    public int revisarGanador(){

    for (int i = 0; i < 3; i++) {
        if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] && tablero[i][0] != 0) {
            int ganador = tablero[i][0];
            return ganador;
        }

        if (tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i] && tablero[0][i] != 0) {
            int ganador = tablero[0][i];
            return ganador;
        }
    }

    if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[0][0] != 0) {
        int ganador = tablero[0][0];
        return ganador;
    }

    if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[0][2] != 0) {
        int ganador = tablero[0][2];
        return ganador;
    }

    return 0;
}

    public void reiniciarJuego(){
        tablero = new int[3][3];
        turno = 0;
    }


}
