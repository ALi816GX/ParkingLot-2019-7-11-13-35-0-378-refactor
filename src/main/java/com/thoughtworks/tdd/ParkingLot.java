package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/14
 * @Time:17:36
 * @description:
 */
public class ParkingLot {

    public static int DEFAULT_CAPACITY = 10;

    private int capacity;
    private Map<Ticket,Car> map;

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
        this.map =  new HashMap<>(capacity);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket parkCar(Car car){

        Ticket ticket = null;

        if(this.map.size() < this.capacity){
            ticket = new Ticket();
            map.put(ticket,car);
        }

        return ticket;

    }

    public Car fetchCar(Ticket ticket) {

        Car car = map.get(ticket);

        map.remove(ticket);

        return car;

    }

    public boolean isCapacityFull(){
        return this.map.size() >= this.capacity;
    }

    public Map<Ticket, Car> getCarsMap() {
        return this.map;
    }


    public int getCarsAcutalCapacity(){
        return this.map.size();
    }


    public int getCapacity() {
        return capacity;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
