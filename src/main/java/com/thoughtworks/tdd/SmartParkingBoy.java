package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/15
 * @Time:00:06
 * @description:
 */
public class SmartParkingBoy extends ParkingBoy{


    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }


    @Override
    public Ticket parkCar(Car car) {

        ParkingLot chosedParkinglot = getMoreEmptyParkinglot();

        return chosedParkinglot.parkCar(car);

    }



    private ParkingLot getMoreEmptyParkinglot(){
        int index = 0;

        for (int i = 0; i < getParkingLots().size(); i++) {

            if (getAcutalCapacityByParkinglotsIndex(i) < getAcutalCapacityByParkinglotsIndex(index)) {
                index = i;
            }

        }

        ParkingLot chosedParkinglot = getParkingLotByIndex(index);

        return chosedParkinglot;

    }



    private int getAcutalCapacityByParkinglotsIndex(int index){
        return getParkingLots().get(index).getCarsAcutalCapacity();
    }

    private ParkingLot getParkingLotByIndex(int index){
        return getParkingLots().get(index);
    }

}
