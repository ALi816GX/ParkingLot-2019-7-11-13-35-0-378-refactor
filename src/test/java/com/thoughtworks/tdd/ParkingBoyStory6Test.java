package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/15
 * @Time:01:39
 * @description:
 */
public class ParkingBoyStory6Test {


    @Test
    public void should_parkingboy_specified_to_park_when_manager_call_park_given_car () {

        ServiceManager manager = new ServiceManager();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot());

        manager.addManagementList(smartParkingBoy);
        manager.addManagementList(superSmartParkingBoy);

        manager.specify(superSmartParkingBoy);

        manager.parkCar(new Car());

        Assertions.assertEquals(manager.getSpecifiedBoy().getList().get(0).getCarsAcutalCapacity(), 1);


    }

    @Test
    public void should_parking_to_the_second_parking_lot_when_manager_call_parkByself_given_the_first_is_full () {
        ServiceManager manager = new ServiceManager();


        manager.addPakinglot(new ParkingLot());
        manager.addPakinglot(new ParkingLot());

        for (int i = 0; i < 12; i++) {
            manager.parkByself(new Car());
        }

        int actual = manager.getProxyBoy().getList().get(1).getCarsAcutalCapacity();

        Assertions.assertEquals(actual, 2);
    }



    @Test
    public void shoule_return_null_and_print_not_enough_position_when_manager_call_park_given_10_cars_already_in_parkinglot () {

        ServiceManager manager = new ServiceManager();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot());

        manager.addManagementList(parkingBoy);
        manager.addManagementList(smartParkingBoy);
        manager.addManagementList(superSmartParkingBoy);

        manager.specify(parkingBoy);

        for (int i = 0; i < 10; i++) {
            manager.parkCar(new Car());
        }

        Ticket ticket = manager.parkCar(new Car());
        Assertions.assertNull(ticket);
        Assertions.assertEquals("Not enough position.",manager.getSpecifiedBoy().getMessage());

    }


}
