package com.thoughtworks.tdd;


import java.util.List;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/15
 * @Time:01:01
 * @description:
 */
public class SuperSmartParkingBoy extends SmartParkingBoy{



    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }


    @Override
    public Ticket parkCar(Car car){


        ParkingLot parkingLot = getMaxEmptyRateParkinglot();

        return parkingLot.parkCar(car);

    }


    public int getParkingLotIndexByTicket(Ticket ticket) {

        int indexResult = -1;

        List<ParkingLot> parkingLots = getParkingLots();

        for (ParkingLot parkingLot:parkingLots){
            if(parkingLot.getCarsMap().containsKey(ticket)){
                indexResult = parkingLots.indexOf(parkingLot);
                break;
            }
        }

        return indexResult;

    }


    public ParkingLot getMaxEmptyRateParkinglot(){

        int index = 0;
        int maxEmptyPositionRate = 0;
        List<ParkingLot> parkingLots = getParkingLots();

        for (ParkingLot item:parkingLots) {
            if(getAvailablePositionRate(item) >= maxEmptyPositionRate){
                maxEmptyPositionRate = item.getCarsMap().size();
                index = parkingLots.indexOf(item);
            }
        }

        return parkingLots.get(index);

    }


    private double getAvailablePositionRate(ParkingLot parkingLot){

        return parkingLot.getCapacity() - parkingLot.getCarsMap().size() * 1.00 / parkingLot.getCapacity();

    }
}
