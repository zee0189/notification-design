package LLD.ParkingLot.ParkingSpace;

import java.time.LocalDateTime;

public interface ParkingSpace {

     String getParkingType();

     Long computeCost(LocalDateTime startTime);

     void freeUpParkingSpace();

     void park();

     boolean isFree();

}
