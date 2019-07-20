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

    private List<ParkingLot> list = new ArrayList<>();
    private String message = "";


    public ParkingBoy(ParkingLot parkingLot) {

        list.add(parkingLot);

    }

    public Ticket parkCar(Car car){

        ParkingLot choose = list.get(0);
        boolean isAllFull = true;
        for(ParkingLot parkingLot:list){
            if(!parkingLot.isCapacityFull()){
                isAllFull = false;
                choose = parkingLot;
                break;
            }
        }

        if(isAllFull){
            message = "Not enough position.";
        }

        return choose.parkCar(car);

    }

    public Car fetchCar(Ticket ticket) {

        Car car = null;

        for(ParkingLot parkingLot:list){
            Car temp  = parkingLot.fetchCar(ticket);
            if(temp != null){
                car = temp;
                break;
            }

        }

        if(ticket == null){
            this.message = "Please provide your parking ticket.";
        }
        else if( car == null ){
            this.message = "Unrecognized parking ticket.";
        }

        return car;

    }

    public void addPakinglot(ParkingLot parkingLot){
        list.add(parkingLot);
    }

    public String getMessage() {

        String message = this.message;
        this.message = "";
        return message;

    }

    public List<ParkingLot> getList() {
        return list;
    }

    public void setList(List<ParkingLot> list) {
        this.list = list;
    }
}
