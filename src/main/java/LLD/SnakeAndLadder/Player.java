package LLD.SnakeAndLadder;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {

    private int id;
    private String name;
    private Position currentPosition;
}
