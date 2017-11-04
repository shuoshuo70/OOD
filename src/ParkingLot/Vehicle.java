package ParkingLot;

import java.util.List;

/**
 * 车基类：车的大小，id，停车位
 * Created by shuoshu on 2017/11/4.
 */
public class Vehicle {
    int size;
    List<Spot> spots;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }
}
