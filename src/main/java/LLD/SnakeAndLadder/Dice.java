package LLD.SnakeAndLadder;

import lombok.Data;

import java.util.Random;

@Data
public class Dice {

    private int dice;
    private static final Random random = new Random();

    public static int rollDice(){
        return random.nextInt(6) + 1;
    }
}
