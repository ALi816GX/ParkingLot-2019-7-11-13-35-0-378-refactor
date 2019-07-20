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

        int index = 0;
        for (int i = 0; i < getList().size(); i++) {
            if (getList().get(i).getCarsAcutalCapacity() < getList().get(index).getCarsAcutalCapacity()) {
                index = i;
            }
        }

        return getList().get(index).parkCar(car);
    }

}
