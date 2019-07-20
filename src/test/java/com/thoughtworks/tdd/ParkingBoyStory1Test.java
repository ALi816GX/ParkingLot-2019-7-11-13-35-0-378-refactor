package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/14
 * @Time:17:43
 * @description:
 */
public class ParkingBoyStory1Test {


    @Test
    public void should_return_car_when_call_fetch_given_ticket_from_park() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        Ticket ticket = parkingBoy.parkCar(car);

        Car fetchedCar = parkingBoy.fetchCar(ticket);

        Assertions.assertSame(fetchedCar, car);
    }



    @Test
    public void should_return_right_car_when_call_fetch_given_multiply_tickets_from_park() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();

        Ticket ticket1 = parkingBoy.parkCar(car1);
        Ticket ticket2 = parkingBoy.parkCar(car2);


        Car fetchedCar1 = parkingBoy.fetchCar(ticket1);
        Car fetchedCar2 = parkingBoy.fetchCar(ticket2);

        Assertions.assertSame(fetchedCar1, car1);
        Assertions.assertSame(fetchedCar2, car2);

    }

    @Test
    public void should_return_null_when_call_fetch_given_wrong_ticket () {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        Ticket ticket = parkingBoy.parkCar(car);

        Car fetchCar = parkingBoy.fetchCar(new Ticket());

        Assertions.assertNull(fetchCar);

    }

    @Test
    public void should_return_null_when_call_fetch_given_no_ticket () {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        Ticket ticket = parkingBoy.parkCar(car);

        Car actual = parkingBoy.fetchCar(null);

        Assertions.assertNull(actual);

    }

    @Test
    public void should_return_null_when_call_park_while_parkingLot_is_full_given_car() {


        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);


        Ticket ticketTemp = null;

        //when
        for(int i = 0;i < 10;i++){
            Car car = new Car();
            ticketTemp = parkingBoy.parkCar(car);
        }

        Ticket ticket_11 = parkingBoy.parkCar(new Car());

        parkingBoy.fetchCar(ticketTemp);
        Ticket ticket_12 = parkingBoy.parkCar(new Car());



        //Then
        Assertions.assertSame(ticket_11 == null,true);
        Assertions.assertSame(ticket_12 != null,true);

    }



}
