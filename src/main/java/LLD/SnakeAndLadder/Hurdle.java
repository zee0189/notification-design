package LLD.SnakeAndLadder;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Hurdle {

    protected int id;
    protected int startRow;
    protected int startColumn;
    protected int endRow;
    protected int endColumn;

    public void shiftPlayerPosition(Board board, Player player){
        int positionIdByRowAndColumn = Position.getPositionIdByRowAndColumn(this.getEndRow(), this.getEndColumn());
        Position endPosition = board.getPositionMap().get(positionIdByRowAndColumn);
        player.setCurrentPosition(endPosition);
    }

    protected abstract boolean validatePosition();
}
