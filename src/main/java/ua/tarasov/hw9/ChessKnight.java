package ua.tarasov.hw9;

class ChessKnight {

    boolean checkTurn(int startIndexI, int startIndexJ, int finishIndexI, int finishIndexJ) {
        return (Math.abs(finishIndexI - startIndexI) + Math.abs(finishIndexJ - startIndexJ)) == 3;
    }
}
