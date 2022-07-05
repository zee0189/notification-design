package LLD.ParkingLot.ParkingSpace;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class SmallVehicle implements ParkingSpace{

    private static final int DEFAULT_PRICE = 20;
    private static final String TYPE = "SMALL_VEHICLE";

    private int id;
    private boolean isFree;

    public SmallVehicle(int id) {
        this.id = id;
        this.isFree = true;
    }

    @Override
    public String getParkingType() {
        return TYPE;
    }

    @Override
    public Long computeCost(LocalDateTime startTime) {
        LocalDateTime now = LocalDateTime.now();
        Duration between = Duration.between(now, startTime);
        return between.toHours() * DEFAULT_PRICE;
    }

    @Override
    public void freeUpParkingSpace() {
        this.setFree(true);
    }

    @Override
    public void park() {
        this.setFree(false);
    }

    @Override
    public boolean isFree(){
        return this.isFree;
    }
}
