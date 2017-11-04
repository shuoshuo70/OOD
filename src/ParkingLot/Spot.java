package ParkingLot;

/**
 * 停车位：id，是否占用
 * Created by shuoshu on 2017/11/4.
 */
public class Spot {
    int id;
    boolean available;

    Spot (int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return true;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
