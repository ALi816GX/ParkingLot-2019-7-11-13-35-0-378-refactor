package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/14
 * @Time:23:32
 * @description:
 */
public class ParkingBoyStory3Test {


    @Test
    public void should_park_into_the_next_parkingLot_when_call_park_car_where_was_enough_given_car(){

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        for(int i = 0;i < 10;i++){
            Car car = new Car();
            parkingBoy.parkCar(car);
        }

        Ticket fetchTicket = parkingBoy.parkCar(new Car());

        Assertions.assertNull(fetchTicket);

        parkingBoy.addPakinglot(new ParkingLot());

        Ticket fetchTicket2 = parkingBoy.parkCar(new Car());

        Assertions.assertNotNull(fetchTicket2);

    }

}
