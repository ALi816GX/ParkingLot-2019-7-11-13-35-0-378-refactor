package com.thoughtworks.tdd;


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

        int index = 0;
        int max_available_position_rate = 0;
        int i = 0;
        for (ParkingLot parkingLot:getParkingLots()) {

            double available_position_rate = parkingLot.getCapacity() - parkingLot.getCarsMap().size() * 1.00 / parkingLot.getCapacity();

            if(available_position_rate >= max_available_position_rate){
                max_available_position_rate = parkingLot.getCarsMap().size();
                index = i;
            }
            i++;
        }


        return getParkingLots().get(index).parkCar(car);
    }



    public int getParkingLotIndexByTicket(Ticket ticket) {

        int index = -1;
        for (int i = 0;i < getParkingLots().size();i++) {
            if(getParkingLots().get(i).getCarsMap().containsKey(ticket)){
                index = i;
                break;
            }
        }
        return index;

    }
}
