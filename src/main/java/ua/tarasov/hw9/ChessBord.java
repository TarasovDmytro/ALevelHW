package ua.tarasov.hw9;

class ChessBord {
    static String[][] chessBord() {
        String[][] chessBord = new String[8][8];
        String str = null;
        for (int i = 0; i < chessBord.length; i++) {
            for (int j = 0; j < chessBord[i].length; j++) {
                if (i == 0) str = "a";
                if (i == 1) str = "b";
                if (i == 2) str = "c";
                if (i == 3) str = "d";
                if (i == 4) str = "e";
                if (i == 5) str = "f";
                if (i == 6) str = "g";
                if (i == 7) str = "h";
                chessBord[i][j] = (str + (j + 1));
            }
        }
        return chessBord;
    }
}
