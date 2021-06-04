package ua.tarasov.hw9;

class ConverterChessCoordinatesToIndexes {
    private int indexI;
    private int indexJ;

    ConverterChessCoordinatesToIndexes(String location) {
        getIndexes(location);
    }

    void getIndexes(String location) {
        setIndexI(-1);
        setIndexJ(-1);
        for (int i = 0; i < ChessBord.chessBord().length; i++) {
            for (int j = 0; j < ChessBord.chessBord().length; j++) {
                if (location.equals(ChessBord.chessBord()[i][j])) {
                    setIndexI(i);
                    setIndexJ(j);
                    break;
                }
            }
        }
    }

    public void setIndexI(int indexI) {
        this.indexI = indexI;
    }

    public void setIndexJ(int indexJ) {
        this.indexJ = indexJ;
    }

    public int getIndexI() {
        return indexI;
    }

    public int getIndexJ() {
        return indexJ;
    }
}