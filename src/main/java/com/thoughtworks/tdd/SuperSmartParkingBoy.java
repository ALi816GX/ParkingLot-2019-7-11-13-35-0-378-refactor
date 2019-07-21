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
        double maxEmptyPositionRate = 0;
        List<ParkingLot> parkingLots = getParkingLots();

        for (ParkingLot item:parkingLots) {
            if(getAvailablePositionRate(item) >= maxEmptyPositionRate){
                maxEmptyPositionRate = getAvailablePositionRate(item);
                index = parkingLots.indexOf(item);
            }
        }

        return parkingLots.get(index);

    }


    private double getAvailablePositionRate(ParkingLot parkingLot){

        double EmptyNumInParkinglot = (parkingLot.getCapacity() - parkingLot.getCarsAcutalCapacity()) * 1.00;

        return EmptyNumInParkinglot / parkingLot.getCapacity();

    }


}
