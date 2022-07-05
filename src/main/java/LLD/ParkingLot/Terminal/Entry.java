package LLD.ParkingLot.Terminal;

import lombok.Data;

@Data
public class Entry {

    private static int ID = 1;
    private int id;
    private TicketVendingMachine ticketVendingMachine;

    public Entry() {
        this.id = ID;
        this.ticketVendingMachine = new TicketVendingMachine();
        ID++;
    }

}
