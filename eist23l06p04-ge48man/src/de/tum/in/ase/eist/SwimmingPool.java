package de.tum.in.ase.eist;

import java.util.concurrent.locks.ReentrantLock;

public class SwimmingPool {
    private final ChangingRoom changingRoom;
    private final Locker locker;
    private int totalVisitors;
    private final ReentrantLock totalVisitorsLock;
    public final SwimmingPoolActionOrder swimmingPoolActionOrder;

    public SwimmingPool() {
        this.changingRoom = new ChangingRoom();
        this.locker = new Locker();
        this.totalVisitors = 0;
        this.totalVisitorsLock = new ReentrantLock();
        this.swimmingPoolActionOrder=SwimmingPoolActionOrder.CHANGING_ROOM_BEFORE_LOCKER;
    }

    public void handleEntryRequest(Swimmer swimmer, SwimmingPoolActionOrder order) {
        switch (order) {
            case CHANGING_ROOM_BEFORE_LOCKER -> {
                changingRoom.acquireKey(swimmer);
                locker.storeClothes(swimmer);

                System.out.printf("Swimmer %d has gone swimming.\n", swimmer.getId());

                locker.retrieveClothes();
                changingRoom.releaseKey();
            }
            case LOCKER_BEFORE_CHANGING_ROOM -> {
                locker.storeClothes(swimmer);
                changingRoom.acquireKey(swimmer);

                System.out.printf("Swimmer %d has gone swimming.\n", swimmer.getId());

                changingRoom.releaseKey();
                locker.retrieveClothes();
            }
        }
        totalVisitorsLock.lock();
        totalVisitors++;
        totalVisitorsLock.unlock();
    }

    public void handleEntryRequestDeadlockFree(Swimmer swimmer, SwimmingPoolActionOrder order) {
        if (order == swimmingPoolActionOrder) {
            locker.storeClothes(swimmer);
            changingRoom.acquireKey(swimmer);

            System.out.printf("Swimmer %d has gone swimming.\n", swimmer.getId());

            changingRoom.releaseKey();
            locker.retrieveClothes();
            totalVisitorsLock.lock();
            totalVisitors++;
            totalVisitorsLock.unlock();
        } else {
            System.out.printf("Swimmer %d must change room befor locker.\n", swimmer.getId());
        }
    }

    public int getTotalVisitors() {
        return this.totalVisitors;
    }
}
