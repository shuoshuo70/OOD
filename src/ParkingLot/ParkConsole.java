package ParkingLot;

/**
 * Created by shuoshu on 2017/11/4.
 */
public class ParkConsole {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        Level level1 = new Level(3, 1);
        Level level2 = new Level(1, 2);

        Car car1 = new Car();
        Bus bus1 = new Bus();
        Car car2 = new Car();
        Car car3 = new Car();

        System.out.println(level1.parkVehicle(car1));
        System.out.println(level1.parkVehicle(car2));
        System.out.println(level1.parkVehicle(bus1));
        System.out.println(level1.parkVehicle(car3));
        System.out.println(level1.freeSpot(car2));
        System.out.println(level1.parkVehicle(bus1));
//        System.out.println(level1.parkVehicle(car1));
    }
}
