package LLD.SnakeAndLadder;

public class Ladder extends Hurdle {

    public Ladder(int id, int startRow, int startColumn, int endRow, int endColumn) {
        super(id, startRow, startColumn, endRow, endColumn);
        validatePosition();
    }

    @Override
    protected boolean validatePosition() {
      return this.startRow < this.endRow && this.startColumn < this.endRow;
    }
}
