package LLD.SnakeAndLadder;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Board {

    private Position[][] positions;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Map<Integer, Position> positionMap;


    public Board(List<Snake> snakes, List<Ladder> ladders) {
        System.out.println("Initializing board");
        this.positions = new Position[10][10];
        this.positionMap = new HashMap<>();
        this.snakes = snakes;
        this.ladders = ladders;
        initializePosition();
        initializeSnake(snakes);
        initializeLadder(ladders);
    }

    private void initializePosition(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                Position position = new Position(i, j);
                positions[i][j] = position;
                positionMap.put(position.getId(), position);
            }
        }
    }

    private void initializeSnake(List<Snake> snakes){
        snakes.forEach(snake -> {
            Position startPosition = getPosition(snake.getStartRow(), snake.getStartColumn());
            startPosition.setSnake(snake);
        });
    }

    private void initializeLadder(List<Ladder> ladders){
        ladders.forEach(ladder -> {
            Position startPosition = getPosition(ladder.getStartRow(),ladder.getStartColumn());
            startPosition.setLadder(ladder);
        });
    }

    private Position getPosition(int row, int col){
        int positionId = Position.getPositionIdByRowAndColumn(row, col);
        return positionMap.get(positionId);
    }
}
