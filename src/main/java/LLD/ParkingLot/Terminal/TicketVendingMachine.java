package LLD.ParkingLot.Terminal;

import LLD.ParkingLot.ParkingSpace.ParkingSpace;
import LLD.ParkingLot.Ticket.Ticket;
import lombok.Data;

@Data
public class TicketVendingMachine {

    private static int ID = 1;
    private final int id;

    public TicketVendingMachine() {
        this.id = ID;
        ID++;
    }

    public Ticket createTicket(ParkingSpace parkingSpace, String vehicleNumber){
        return new Ticket(parkingSpace,vehicleNumber, this.getId());
    }

}
