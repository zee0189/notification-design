package LLD.SnakeAndLadder;

import lombok.Data;

@Data
public class Position {

    private static int ID = 1;

    private int id;
    private int row;
    private int column;
    private Snake snake;
    private Ladder ladder;

    public Position(int row, int column) {
        this.id = ID;
        this.row = row;
        this.column = column;
        ID++;
    }

    public static int getPositionIdByRowAndColumn(int row, int column){
        return row * 10 + column + 1;
    }
}
