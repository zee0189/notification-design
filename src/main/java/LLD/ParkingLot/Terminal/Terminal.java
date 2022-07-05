package LLD.ParkingLot.Terminal;

import lombok.Data;

@Data
public class Terminal {

    private static int ID = 1;
    private int id;
    private Entry entry;
    private Exit exit;

    public Terminal() {
        this.id = ID;
        this.entry = new Entry();
        this.exit = new Exit();
        ID++;
    }
}
