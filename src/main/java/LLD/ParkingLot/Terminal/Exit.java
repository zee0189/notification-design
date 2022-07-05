package LLD.ParkingLot.Terminal;

import lombok.Data;

@Data
public class Exit {

    private static int ID = 1;
    private int id;
    private TicketReadingMachine ticketReadingMachine;

    public Exit() {
        this.id = ID;
        this.ticketReadingMachine = new TicketReadingMachine();
        ID++;
    }


}
