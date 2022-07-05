package LLD.SnakeAndLadder;

public class Snake extends Hurdle{

    public Snake(int id, int startRow, int startColumn, int endRow, int endColumn) {
        super(id, startRow, startColumn, endRow, endColumn);
        validatePosition();
    }


    @Override
    protected boolean validatePosition() {
       return this.startRow > this.endRow && this.startColumn > this.endColumn;
    }
}
