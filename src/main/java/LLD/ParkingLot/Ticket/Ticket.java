package LLD.ParkingLot.Ticket;

import LLD.ParkingLot.ParkingSpace.ParkingSpace;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Ticket {

    private static int ID = 1;
    private int id;
    private int entryGateId;
    private int exitGateId;
    private ParkingSpace parkingSpace;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String vehicleNumber;
    private Long cost = 0L;

    public Ticket(ParkingSpace parkingSpace, String vehicleNumber, int entryGateId) {
        this.id = ID;
        this.parkingSpace = parkingSpace;
        this.entryGateId = entryGateId;
        this.startTime = LocalDateTime.now();
        this.vehicleNumber = vehicleNumber;
        ID++;
    }
}
