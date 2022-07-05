package LLD.SnakeAndLadder;

import lombok.Data;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


@Data
public class SnakeAndLadder {

    private Board board;
    private List<Player> playerList;
    private Dice dice;
    private Player winner = null;

    public SnakeAndLadder(){
        initializeBoard();
        initializePlayer(this.board);
        this.dice = new Dice();
    }

    private void initializeBoard(){
        Snake snake1 = new Snake(1, 5,5, 3, 3);
        Snake snake2 = new Snake(2, 9, 7, 0,0);
        Ladder ladder1 = new Ladder(1, 3,3,5, 5);
        Ladder ladder2 = new Ladder(2, 2,2,9,8);
        List<Snake> snakes = Arrays.asList(snake1, snake2);
        List<Ladder> ladders = Arrays.asList(ladder1, ladder2);
        this.board = new Board(snakes, ladders);
    }

    private void initializePlayer(Board board){
        Position startPosition = board.getPositionMap().get(1);
        Player player1 = new Player(1, "Zeeshan", startPosition);
        Player player2 = new Player(1, "Zee", startPosition);
        this.playerList = Arrays.asList(player1, player2);
    }

    public void startGame() throws InterruptedException {
        System.out.println("----------------Starting the game-----------------------");
        Queue<Player> queue = new LinkedList<>(playerList);
        while (!queue.isEmpty() && this.winner == null){
            Player currentPlayer = queue.remove();
            int numberOfSteps = Dice.rollDice();
            Position currentPlayerPosition = currentPlayer.getCurrentPosition();
            String positionMessage = String.format("Player : %s at position with : %d rolled a dice", currentPlayer.getName().toUpperCase(), currentPlayerPosition.getId());
            System.out.println(positionMessage);
            int positionId = currentPlayerPosition.getId();
            if(positionId + numberOfSteps <= 100){
                Position nextPosition = board.getPositionMap().get(positionId + numberOfSteps);
                String nextPositionMessage = String.format("Player : %s next position is going to be : %d", currentPlayer.getName().toUpperCase(), positionId + numberOfSteps);
                System.out.println(nextPositionMessage);
                if (nextPosition.getColumn() == 9 && nextPosition.getRow() == 9){
                    this.winner = currentPlayer;
                    System.out.println("Player : "+ currentPlayer.getName()+" has won the game.");
                    break;
                }
                Snake snake = nextPosition.getSnake();
                Ladder ladder = nextPosition.getLadder();
                if (snake != null){
                    String snakePositionMassage = String.format("Player : %s has found a snake at position : %d", currentPlayer.getName().toUpperCase(), positionId + numberOfSteps);
                    System.out.println(snakePositionMassage);
                    snake.shiftPlayerPosition(board, currentPlayer);
                }else if(ladder != null){
                    String ladderPositionMassage = String.format("Player : %s has found a ladder at position : %d", currentPlayer.getName().toUpperCase(), positionId + numberOfSteps);
                    System.out.println(ladderPositionMassage);
                    ladder.shiftPlayerPosition(board,currentPlayer);
                }else {
                    currentPlayer.setCurrentPosition(nextPosition);
                    String updatedPositionMessage = String.format("Player : %s updated position : %d", currentPlayer.getName().toUpperCase(), currentPlayer.getCurrentPosition().getId());
                    System.out.println(updatedPositionMessage);
                }
            }else {
                String vainAttemptMessage = String.format("Player : %s at position with : %d got position : %d beyond the board", currentPlayer.getName().toUpperCase(), currentPlayerPosition.getId(), positionId + numberOfSteps);
                System.out.println(vainAttemptMessage);
            }
            queue.add(currentPlayer);
            Thread.sleep(500);
            System.out.println("\n\n\n");
        }
        System.out.println("----------------Game ended-----------------------");
    }

    public static void main(String[] args) throws InterruptedException {
        SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
        snakeAndLadder.startGame();
    }
}
