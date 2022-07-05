package LLD.ParkingLot;

import LLD.ParkingLot.ParkingSpace.*;
import LLD.ParkingLot.Terminal.Terminal;
import LLD.ParkingLot.Terminal.TicketVendingMachine;
import LLD.ParkingLot.Ticket.Ticket;
import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class ParkingLot {

    private static final int DEFAULT_NUMBER_OF_FLOORS = 4;
    private static final int DEFAULT_NUMBER_OF_TERMINALS = 3;
    private static final int LARGE_VEHICLE_SPACE = 10;
    private static final int COMPACT_VEHICLE_SPACE = 50;
    private static final int SMALL_VEHICLE_SPACE = 50;

    private List<ParkingFloor> parkingFloorList;
    private List<Terminal> terminals;

    private Map<Integer, Terminal> terminalMap = new HashMap<>();
    private Map<Integer, Ticket> ticketMap = new HashMap<>();


    public ParkingLot() {
        initializeTerminals();
        initializeParkingFloor();
    }

    private void initializeTerminals(){
        List<Terminal> terminals = new ArrayList<>();
        for (int i = 0; i < DEFAULT_NUMBER_OF_TERMINALS; i++){
            terminals.add(new Terminal());
        }
        this.terminals = terminals;
        terminalMap = terminals.stream().collect(Collectors.toMap(Terminal::getId, Function.identity()));
    }


    private void initializeParkingFloor(){
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for (int i = 0; i < DEFAULT_NUMBER_OF_FLOORS; i++){
            List<ParkingSpace> parkingSpaces = new ArrayList<>();
            for (int j = 0; j < LARGE_VEHICLE_SPACE; j++){
                parkingSpaces.add(new LargeVehicle(i * 10 + j+1));
            }
            for (int j = 0; j < COMPACT_VEHICLE_SPACE; j++){
                parkingSpaces.add(new CompactVehicle(i * 10 + j+1));
            }

            for (int j = 0; j < SMALL_VEHICLE_SPACE; j++){
                parkingSpaces.add(new SmallVehicle(i * 10 + j+1));
            }

            for (int j = 0; j < 10; j++){
                parkingSpaces.add(new VIPVehicle(i * 10 + j+1));
            }
            parkingFloors.add(new ParkingFloor(i, parkingSpaces));
        }
        this.parkingFloorList = parkingFloors;
    }

    public Ticket createTicket(String type, String vehicleNumber, int terminalId) throws Exception {
        Terminal terminal = terminalMap.get(terminalId);
        TicketVendingMachine ticketVendingMachine = terminal.getEntry().getTicketVendingMachine();
        ParkingSpace parkingSpace = getParkingSpace(type);
        parkingSpace.park();
        Ticket ticket = ticketVendingMachine.createTicket(parkingSpace, vehicleNumber);
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }

    public ParkingSpace getParkingSpace(String type) throws Exception {
        Optional<ParkingSpace> spaceOptional = parkingFloorList.stream()
                                                       .flatMap(parkingFloor -> parkingFloor.getParkingSpace().stream())
                                                       .filter(parkingSpace -> parkingSpace.getParkingType().equals(type) && parkingSpace.isFree())
                                                       .findFirst();
        if (!spaceOptional.isPresent()){
            throw new Exception("Parking full");
        }
        return spaceOptional.get();
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        System.out.println("done");
    }
}
