package lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        CountDownLatch CDL_for_start = new CountDownLatch(CARS_COUNT);
        CountDownLatch CDL_for_end = new CountDownLatch(CARS_COUNT);
        Semaphore smp = new Semaphore(CARS_COUNT/2);
        AtomicBoolean isWin = new AtomicBoolean(false);   //в принципе, можно было сделать не передавая атомарный булеан с помощью счетчика
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10),CDL_for_start,CDL_for_end,isWin, smp);
        }

        for (int i = 0; i < cars.length; i++) {
             new Thread(cars[i]).start();
        }
        CDL_for_start.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        CDL_for_end.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}


