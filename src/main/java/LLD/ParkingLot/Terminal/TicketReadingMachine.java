package LLD.ParkingLot.Terminal;

import LLD.ParkingLot.ParkingSpace.ParkingSpace;
import LLD.ParkingLot.Ticket.Ticket;
import lombok.Data;

@Data
public class TicketReadingMachine {

    private static int ID = 1;
    private final int id;

    public TicketReadingMachine() {
        this.id = ID;
        ID++;
    }

    public Ticket computeTicket(Ticket ticket){
        ParkingSpace parkingSpace = ticket.getParkingSpace();
        Long cost = parkingSpace.computeCost(ticket.getStartTime());
        ticket.setCost(cost);
        ticket.setExitGateId(this.id);
        parkingSpace.freeUpParkingSpace();
        return ticket;
    }
}
