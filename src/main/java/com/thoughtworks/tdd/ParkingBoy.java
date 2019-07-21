package com.thoughtworks.tdd;


import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/14
 * @Time:17:36
 * @description:
 */
public class ParkingBoy {

    private List<ParkingLot> parkingLots = new ArrayList<>();
    private String message;

    public static final String NOT_ENOUGH_POSITION_MESSAGE = "Not enough position.";
    public static final String PROVIDE_PARKING_TICKET_MESSAGE = "Please provide your parking ticket.";
    public static final String UNRECOGNIZED_TICKET_MESSAGE = "Unrecognized parking ticket.";
    public static final String CLEAN_MESSAGE = "";


    public ParkingBoy(ParkingLot parkingLot) {

        parkingLots.add(parkingLot);

    }

    public Ticket parkCar(Car car){

        ParkingLot chosedPakinglot = chosedParkinglot();

        if(isPakinglotsFull()){
            message = NOT_ENOUGH_POSITION_MESSAGE;
        }

        return chosedPakinglot.parkCar(car);

    }

    public Car fetchCar(Ticket ticket) {

        Car car = chosedFetchCar(ticket);

        if(ticket == null){
            this.message = PROVIDE_PARKING_TICKET_MESSAGE;
        }
        else if( car == null ){
            this.message = UNRECOGNIZED_TICKET_MESSAGE;
        }

        return car;

    }

    public void addPakinglot(ParkingLot parkingLot){
        this.parkingLots.add(parkingLot);
    }

    public String getMessage() {

        String message = this.message;

        this.message = CLEAN_MESSAGE;

        return message;

    }

    public List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }


    private boolean isPakinglotsFull(){

        boolean isAllFull = true;

        for(ParkingLot parkingLot:this.parkingLots){
            if(!parkingLot.isCapacityFull()){
                isAllFull = false;
                break;
            }
        }

        return isAllFull;
    }


    private ParkingLot chosedParkinglot(){

        ParkingLot chosedPakinglot = parkingLots.get(0);

        for(ParkingLot parkingLot:this.parkingLots){
            if(!parkingLot.isCapacityFull()){
                chosedPakinglot = parkingLot;
                break;
            }
        }

        return chosedPakinglot;
    }

    private Car chosedFetchCar(Ticket ticket){

        Car car = null;

        for(ParkingLot parkingLot:this.parkingLots){
            Car temp  = parkingLot.fetchCar(ticket);
            if(temp != null){
                car = temp;
                break;
            }
        }
        return car;
    }

}
