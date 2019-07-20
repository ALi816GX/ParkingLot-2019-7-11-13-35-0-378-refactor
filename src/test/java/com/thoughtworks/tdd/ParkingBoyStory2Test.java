package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/14
 * @Time:21:24
 * @description:
 */
public class ParkingBoyStory2Test {

    @Test
    public void should_return_Error_Text_when_call_fetch_given_used_ticket_or_null() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Ticket ticket = parkingBoy.parkCar(new Car());
        parkingBoy.fetchCar(ticket);


        Car fetchCarWithUsedTicket = parkingBoy.fetchCar(ticket);
        Assertions.assertNull(fetchCarWithUsedTicket);
        Assertions.assertSame("Unrecognized parking ticket.",parkingBoy.getMessage());

    }



    @Test
    public void should_return_Error_Text_when_call_fetch_given_null_ticket() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Ticket ticket = parkingBoy.parkCar(new Car());
        parkingBoy.fetchCar(ticket);


        Car fetchCarWithNullTicket = parkingBoy.fetchCar(null);
        Assertions.assertNull(fetchCarWithNullTicket);
        Assertions.assertSame("Please provide your parking ticket.",parkingBoy.getMessage());

    }


    @Test
    public void should_return_Error_Text_when_call_park_car_where_was_enough_given_car(){

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        for(int i = 0;i < 10;i++){
            Car car = new Car();
            parkingBoy.parkCar(car);
        }

        Ticket fetchTicket2 = parkingBoy.parkCar(new Car());

        Assertions.assertNull(fetchTicket2);
        Assertions.assertSame("Not enough position.",parkingBoy.getMessage());

    }

}
