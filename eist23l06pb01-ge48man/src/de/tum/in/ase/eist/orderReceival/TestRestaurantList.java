package de.tum.in.ase.eist.orderReceival;

public class TestRestaurantList {
    // TODO 1.1 Run the main method, a error should occur
    public static void main(String[] args) {
        // TODO 1.4 Run the main method again, you should receive the following output
        /*
        Output should be: Duration: XXms
        */


        SynchronizedRestaurantList<String> list = new SynchronizedRestaurantList<>();

        try {
            for (int i = 0; i < 5000; i++) {
                list.add(i, "" + i);
            }

            // The 5 RestaurantOrderReceival Threads test the behaviour of
            // the OrderSystem by reading the value saved in [1-5]000 for 10000 times
            Thread[] restaurantWorkThreads = new Thread[5];
            for (int i = 0; i < restaurantWorkThreads.length; i++) {
                final int icopy = i * 1000;
                restaurantWorkThreads[i] = new Thread(() -> {
                    for (int j = 0; j < 10000; j++)
                        try {
                            list.get(icopy);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                });
            }

            // The testCustomer adds 10000 orders to see how the system responds
            // and also cancels them
            Thread testCustomer = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    try {
                        list.add(4, "4");
                        list.remove(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // We will measure the time, the system needs to process everything
            long startTime = System.currentTimeMillis();
            for (Thread workThread : restaurantWorkThreads) workThread.start();
            testCustomer.start();
            for (Thread restaurantWorkThread : restaurantWorkThreads) restaurantWorkThread.join();
            testCustomer.join();
            long duration = System.currentTimeMillis() - startTime;
            System.out.println("Duration: " + (duration) + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
