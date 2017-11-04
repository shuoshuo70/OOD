package ParkingLot;

import java.util.ArrayList;
import java.util.List;

/**
 * 停车场的一层
 * 属性： 在哪一层，有剩下多少空位，各位置的状态
 * Created by shuoshu on 2017/11/4.
 */
public class Level {
    int availableSize, floor;
    List<Spot> spots;

    Level (int availableSize, int floor) {
        this.availableSize = availableSize;
        this.floor = floor;
        spots = new ArrayList<>();

        for (int i = 0; i < availableSize; i++) {
            spots.add(new Spot(i));
        }
    }

    /**
     * 找停车位，遍历车位，找到连续空位大小与车相同的位置，
     * 并把相应的位置占用，返回位置的起点
     * @param vehicle
     * @return
     */
    public int findAvailablePark(Vehicle vehicle) {
        int size = vehicle.getSize();
        if (size > availableSize) {
            return -1;
        }

        int cnt = 0, i = 0;
        for (; i < spots.size(); i++) {
            if (spots.get(i).isAvailable()) {
                cnt++;
                if (cnt == size) {
                    break;
                }
            } else {
                cnt = 0;
            }
        }

        availableSize -= size;
        return i;
    }

    /**
     * 停车：找停车位，车标记自己的停车位
     * @param vehicle
     * @return
     */
    public boolean parkVehicle(Vehicle vehicle) {
        int spotId = findAvailablePark(vehicle);
        if (spotId < 0 || spotId == spots.size()) {
            return false;
        }

        List<Spot> usedSpots = new ArrayList<>();
        for (int i = spotId - vehicle.getSize() + 1; i <= spotId; i++) {
            spots.get(i).setAvailable(false);
            usedSpots.add(spots.get(i));
        }
        vehicle.setSpots(usedSpots);

        return true;
    }


    /**
     * 取车，车记录了自己的停车位，把停车位释放
     * @param vehicle
     */
    public boolean freeSpot(Vehicle vehicle) {
        List<Spot> usedSpots = vehicle.getSpots();
        if (usedSpots == null || usedSpots.size() == 0) {
            return false;
        }

        for (Spot spot : usedSpots) {
            spot.setAvailable(true);
        }

        vehicle.setSpots(null);
        availableSize += vehicle.getSize();

        return true;
    }
}
