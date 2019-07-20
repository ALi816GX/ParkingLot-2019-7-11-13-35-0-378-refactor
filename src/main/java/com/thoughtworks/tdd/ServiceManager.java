package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/15
 * @Time:01:43
 * @description:
 */
public class ServiceManager {

    private List<ParkingBoy> parkingBoyList;
    private ParkingBoy specifiedBoy;
    private ParkingBoy proxyBoy = new ParkingBoy(new ParkingLot());

    public ServiceManager() {
        parkingBoyList = new ArrayList<>();
    }

    public void addManagementList (ParkingBoy boy) {
        parkingBoyList.add(boy);
    }


    public void specify(ParkingBoy parkingBoy) {
        specifiedBoy = parkingBoy;
    }

    public Ticket parkCar(Car car) {
        return specifiedBoy.parkCar(car);
    }

    public Ticket parkByself (Car car) {
        return  proxyBoy.parkCar(car);
    }

    public ParkingBoy getSpecifiedBoy() {
        return specifiedBoy;
    }

    public ParkingBoy getProxyBoy() {
        return proxyBoy;
    }

    public void addPakinglot(ParkingLot parkingLot){
        proxyBoy.addPakinglot(parkingLot);
    }
}
