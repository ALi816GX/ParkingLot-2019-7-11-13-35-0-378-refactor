package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/15
 * @Time:01:02
 * @description:
 */
public class ParkingBoyStory5Test {


    @Test
    public void should_park_into_the_more_available_position_rate_parkingLot_when_call_park_car_by_super_smart_boy_given_car(){

        //given
        ParkingLot parkingLot = new ParkingLot();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot);

        for(int i = 0;i < 3;i++){
            Car car = new Car();
            superSmartParkingBoy.parkCar(car);
        }

        superSmartParkingBoy.addPakinglot(new ParkingLot(10));

        Ticket fetchTicket = superSmartParkingBoy.parkCar(new Car());

        Assertions.assertSame(1,superSmartParkingBoy.getParkingLotIndexByTicket(fetchTicket));

    }

}
