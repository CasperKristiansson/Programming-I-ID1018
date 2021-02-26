public class Chessboard {
    class Field {
        private char row;
        private byte column;
        private Chesspiece piece = null;
        private boolean marked = false;
        /*
            Skappar de olika parametrarna för schack brädan
        */
        private Field(char row, byte column) {
            this.row = row;
            this.column = column;
        }
        /*
            Sätter det nya värdet på pjäsen som ska placeras
        */
        private void put(Chesspiece piece) {
            this.piece = piece;
        }
        /*
            Genom att ta bort pjäsen så sätts dens värde till null
        */
        private Chesspiece take() {
            this.piece = null;
            return this.piece;
        }
        /*
            För att skilja på vilka områden som används så blir dem som är
            makrade true
        */
        private void mark() {
            this.marked = true;
        }
        /*
            För att skilja på vilka områden som används så blir dem som inte är
            markerade false
        */
        private void unmark() {
            this.marked = false;
        }
        /*
            Genom att kolla vad för värde marked har kan man sätta ut xx eller --
            För att kunna se om punkten ska användas senare
        */
        public String toString() {
            String s = (marked) ? "xx" : "--";
            return (piece == null) ? s : piece.toString();
        }
    }

    public static final int NUMBER_OF_ROWS = 8;
    public static final int NUMBER_OF_COLUMNS = 8;
    public static final int FIRST_ROW = 'a';
    public static final int FIRST_COLUMN = 1;
    private Field[][] fields;

    public Chessboard() {
        fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        char row;
        byte column;

        for (int r = 0; r < NUMBER_OF_ROWS; r++) {
            row = (char)(FIRST_ROW + r);
            column = FIRST_COLUMN;

            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
                fields[r][c] = new Field(row, column);
                column++;
            }
        }
    }
    /*
        toString som hjälper att printa ut hela planen genom att första printa ut
        Siffrorna för projektet. Sedan så har man byggt två loopar för att varje rad ska
        Gå igenom fields[r][c] för att se om det är ett värde som ska markeras med xx eller --
    */
    public String toString() {
        System.out.println("  1  2  3  4  5  6  7  8");
        
        for (int r = 0; r < 8; r++) {
            System.out.print(Character.toChars(FIRST_ROW + r));
            System.out.print(" ");

            for (int c = 0; c < 8; c++) {
                System.out.print((fields[r][c]));
                System.out.print(" ");
            }
            System.out.println("");
        }
        return "";
    }
    /*
        Denna funktion kollar om platsen är valid (alltså inom schack brädan)
    */
    public boolean isValidField(char row, byte column) {
        return row >= 'a' && row <= 'h' && column >= 1 && column <= 8;
    }

    public abstract class Chesspiece {
        private char color;
        // w - white, b - black
        private char name;
        // K - King, Q - Queen, R - Rook, B - Bishop, N - Knight
        // P - Pawn
        protected char row = 0;
        protected byte column = -1;
        //Används för att skappa ny pjäser samnt identifiera vad för pjäs det är
        protected Chesspiece(char color, char name) {
            this.color = color;
            this.name = name;
        }

        public String toString() {
            return "" + color + name;
        }

        public void moveTo(char row, byte column) throws NotValidFieldException {
            if (!Chessboard.this.isValidField(row, column))
                throw new NotValidFieldException("bad field: " + row + column);
                
            this.row = row;
            this.column = column;
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;
            Chessboard.this.fields[r][c].put(this);
        }

        public class NotValidFieldException extends Exception {
            private static final long serialVersionUID = 8170893034671998517L;
            NotValidFieldException(String error) {
                System.out.println(error);
            }
        }
        /*
            Använder sig av kallsen take() för att få bort en pjäs i en viss plats
        */
        public void moveOut() {
            Chessboard.this.fields[row - FIRST_ROW][column - FIRST_COLUMN].take();
            Chessboard.this.fields[row - FIRST_ROW][column - FIRST_COLUMN].take();
        }
        /*
           Subklasser som inmplementeras i metoderna längre ner för de olika pjäserna
        */
        public abstract void markReachableFields();
        public abstract void unmarkReachableFields();
    }
    /*
       Genom att Pawns bara "i de flesta" situationer kan bara röra sig en ruta framåt så räker
       det med att vi skriver column + 1 för att markera de olika positioner som är möjliga för
       den att flytta på sig. Sedan skappas två olika funktioner, en för att markera samt en
       funktion för att ta bort markeringarna. Pawn i detta fall blir enklast genom att den bara
       även kan röra sig i en ritkning
    */
    public class Pawn extends Chesspiece {
        public Pawn(char color , char name) {
            super(color, name);
        }

        public void markReachableFields() {
            byte newColumn = (byte)(column + 1);
            if (Chessboard.this.isValidField(row, newColumn)) {
                Chessboard.this.fields[row - FIRST_ROW][newColumn - FIRST_COLUMN].mark();
            }
        }

        public void unmarkReachableFields () {
            byte newColumn = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, newColumn)) {
                Chessboard.this.fields[row - FIRST_ROW][newColumn - FIRST_COLUMN].unmark();
            }
        }
    }
    /*
       För en rock så ska alla håll vartikalt och horzontellt markeras med pjäsen
       Detta kan man lösa igenom att bara plussa på i och öka i detta fall både ändra värdet
       med hjälp av i
    */
    public class Rook extends Chesspiece {

        public Rook(char color , char name) {
            super(color, name);
        }

        public void markReachableFields() {
            byte col = (byte) (this.column);
            char row = (char) (this.row);
            if (Chessboard.this.isValidField(row, col)) {
                for (int i = 0; i < 8; i++) {
                    int r = row - FIRST_ROW;
                    Chessboard.this.fields[r][i].mark();
                    int c = col - FIRST_COLUMN;
                    Chessboard.this.fields[i][c].mark();
                }
            }
        }

        public void unmarkReachableFields () {
            byte col = (byte) (this.column);
            char row = (char) (this.row);
            if (Chessboard.this.isValidField(row, col)) {
                for (int i = 0; i < 8; i++) {
                    int r = row - FIRST_ROW;
                    Chessboard.this.fields[r][i].unmark();
                    int c = col - FIRST_COLUMN;
                    Chessboard.this.fields[i][c].unmark();
                }
            }
        }
    }
    /*
       Knight blir lite svårare då den inte direkt har raka linjer. Detta kunde man lösa genom
       att bygga upp en index som innehåller de olika postionerna som den ska kunna. Den kollar om
       dessa punkter finns på planen och sedan markerar de
    */
    public class Knight extends Chesspiece {
        public Knight(char color , char name) {
            super(color, name);
        }
        int[][] check = {{ 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }};

        public void markReachableFields() {
            for (int i = 0; i < check.length; i++) {
                if (Chessboard.this.isValidField((char) (this.row + check[i][0]), (byte) (this.column + check[i][1]))) {
                    byte col = (byte) (this.column + check[i][1]);
                    char row = (char) (this.row + check[i][0]);
                    Chessboard.this.fields[row - FIRST_ROW][col - FIRST_COLUMN].mark();
                }
            }
        }
        
        public void unmarkReachableFields () {
            for (int i = 0; i < check.length; i++) {
                if (Chessboard.this.isValidField((char) (this.row + check[i][0]), (byte) (this.column + check[i][1]))) {
                    byte col = (byte) (this.column + check[i][1]);
                    char row = (char) (this.row + check[i][0]);
                    Chessboard.this.fields[row - FIRST_ROW][col - FIRST_COLUMN].unmark();
                }
            }
        }
    }
    /*
      Genom att en bishop kan röra sig via hörnen så finns det fyra olika möjligheter (i, i)(i, -i)
       (-i, i)(-i, -i). Genom att göra en loop som kommer vara max distansen runt om den så kommer den 
       forstsätta runt till den har markerat alla.
    */
    public class Bishop extends Chesspiece {
        public Bishop(char color , char name) {
            super(color, name);
        }

        public void markReachableFields() {
            byte col;
            char row;
            for (int i = 1; i < 8; i++) {
                col = (byte) (this.column + i);
                row = (char) (this.row + i);
                if (Chessboard.this.isValidField(row, col))
                    Chessboard.this.fields[row - FIRST_ROW][col - FIRST_COLUMN].mark();
                
                col = (byte) (this.column - i);
                row = (char) (this.row - i);
                if (Chessboard.this.isValidField(row, col))
                    Chessboard.this.fields[row - FIRST_ROW][col - FIRST_COLUMN].mark();
                
                col = (byte) (this.column + i);
                row = (char) (this.row - i);
                if (Chessboard.this.isValidField(row, col))
                    Chessboard.this.fields[row - FIRST_ROW][col - FIRST_COLUMN].mark();
                
                col = (byte) (this.column - i);
                row = (char) (this.row + i);
                if (Chessboard.this.isValidField(row, col))
                    Chessboard.this.fields[row - FIRST_ROW][col - FIRST_COLUMN].mark();
            }
        }

        public void unmarkReachableFields() {
            byte col;
            char row;
            for (int i = 1; i < 8; i++) {
                col = (byte) (this.column + i);
                row = (char) (this.row + i);
                if (Chessboard.this.isValidField(row, col))
                    Chessboard.this.fields[row - FIRST_ROW][col - FIRST_COLUMN].unmark();
                
                col = (byte) (this.column - i);
                row = (char) (this.row - i);
                if (Chessboard.this.isValidField(row, col))
                    Chessboard.this.fields[row - FIRST_ROW][col - FIRST_COLUMN].unmark();
                
                col = (byte) (this.column + i);
                row = (char) (this.row - i);
                if (Chessboard.this.isValidField(row, col))
                    Chessboard.this.fields[row - FIRST_ROW][col - FIRST_COLUMN].unmark();
                
                col = (byte) (this.column - i);
                row = (char) (this.row + i);
                if (Chessboard.this.isValidField(row, col))
                    Chessboard.this.fields[row - FIRST_ROW][col - FIRST_COLUMN].unmark();
            }
        }
    }
    /*
       Genom att kombinera funktionerna från både Bishop och Rook kan man bygga upp dam. I detta
       fall när man börjar kombinera olika satser så istället för att repetera koden för att unmarka
       rutorna så unmarkas alla rutor på hela chessboardet
    */
    public class Queen extends Chesspiece {
        public Queen(char color , char name) {
            super(color, name);
        }

        public void markReachableFields() {
            byte col = (byte) (this.column);
            char row = (char) (this.row);
            if (Chessboard.this.isValidField(row, col)) {
                for (int i = 0; i < 8; i++) {
                    int r = row - FIRST_ROW;
                    Chessboard.this.fields[r][i].mark();
                    int c = col - FIRST_COLUMN;
                    Chessboard.this.fields[i][c].mark();
                }
            }
            byte col2;
            char row2;
            
            for (int i = 1; i < 8; i++) {
                col2 = (byte) (this.column + i);
                row2 = (char) (this.row + i);
                if (Chessboard.this.isValidField(row2, col2))
                    Chessboard.this.fields[row2 - FIRST_ROW][col2 - FIRST_COLUMN].mark();
                
                col2 = (byte) (this.column - i);
                row2 = (char) (this.row - i);
                if (Chessboard.this.isValidField(row2, col2))
                    Chessboard.this.fields[row2 - FIRST_ROW][col2 - FIRST_COLUMN].mark();
                
                col2 = (byte) (this.column + i);
                row2 = (char) (this.row - i);
                if (Chessboard.this.isValidField(row2, col2))
                    Chessboard.this.fields[row2 - FIRST_ROW][col2 - FIRST_COLUMN].mark();
                
                col2 = (byte) (this.column - i);
                row2 = (char) (this.row + i);
                if (Chessboard.this.isValidField(row2, col2))
                    Chessboard.this.fields[row2 - FIRST_ROW][col2 - FIRST_COLUMN].mark();
            }
        }

        public void unmarkReachableFields() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Chessboard.this.fields[i][j].unmark();
                }
            }
        }
    }
    /*
       Genom att kombinera pawn åt alla håll samt använda en del av Bishop så kan vi
       enkelt bygga upp King
    */
    public class King extends Chesspiece {
        public King(char color , char name) {
            super(color, name);
        }


        public void markReachableFields() {
            int[] check = {1, -1,};
            for (int i = 0; i < 2; i++) {
                byte newColumn = (byte)(column + check[i]);
                if (Chessboard.this.isValidField(row, newColumn)) {
                    Chessboard.this.fields[row - FIRST_ROW][newColumn - FIRST_COLUMN].mark();
                }
                char newRow = (char)(row + check[i]);
                if (Chessboard.this.isValidField(newRow, column)) {
                    Chessboard.this.fields[newRow - FIRST_ROW][column - FIRST_COLUMN].mark();
                }
            }

            byte col;
            char row;

            col = (byte) (this.column + 1);
            row = (char) (this.row + 1);
            if (Chessboard.this.isValidField(row, column))
                Chessboard.this.fields[row - FIRST_ROW][col - FIRST_COLUMN].mark();
            
            col = (byte) (this.column - 1);
            row = (char) (this.row - 1);
            if (Chessboard.this.isValidField(row, col))
                Chessboard.this.fields[row - FIRST_ROW][col - FIRST_COLUMN].mark();
            
            col = (byte) (this.column + 1);
            row = (char) (this.row - 1);
            if (Chessboard.this.isValidField(row, col))
                Chessboard.this.fields[row - FIRST_ROW][col - FIRST_COLUMN].mark();
            
            col = (byte) (this.column - 1);
            row = (char) (this.row + 1);
            if (Chessboard.this.isValidField(row, col))
                Chessboard.this.fields[row - FIRST_ROW][col - FIRST_COLUMN].mark();   
        }

        public void unmarkReachableFields() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Chessboard.this.fields[i][j].unmark();
                }
            }
        }
    }
}