package LLD.ParkingLot;

import LLD.ParkingLot.ParkingSpace.ParkingSpace;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Data
public class ParkingFloor {
    private int level;
    private List<ParkingSpace> parkingSpace;
    private Map<String, List<ParkingSpace>> parkingSpaceMap;

    public ParkingFloor(int level, List<ParkingSpace> parkingSpace) {
        this.level = level;
        this.parkingSpace = parkingSpace;
        initializeParkingSpaceMap();
    }

    private void initializeParkingSpaceMap(){
         this.parkingSpaceMap = parkingSpace.stream().collect(Collectors.groupingBy(ParkingSpace::getParkingType, Collectors.toList()));
    }

}
