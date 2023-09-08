package de.tum.in.ase.eist;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        detectDeadlock(new SwimmingPool());
    }

    public static void detectDeadlock(SwimmingPool swimmingPool) {
        for(int i=0;i<1000;i++){
            if(i%2==0){
                swimmingPool.handleEntryRequestDeadlockFree(new Swimmer(),SwimmingPoolActionOrder.CHANGING_ROOM_BEFORE_LOCKER);
            }else {
                swimmingPool.handleEntryRequestDeadlockFree(new Swimmer(),SwimmingPoolActionOrder.LOCKER_BEFORE_CHANGING_ROOM);
            }
        }
    }
}
