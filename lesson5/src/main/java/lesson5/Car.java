package lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private CountDownLatch CDL_for_start;
    private CountDownLatch CDL_for_end;
    private AtomicBoolean isWin;
    private Race race;
    private int speed;
    private String name;
    private  Semaphore smp;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch CDL_for_start, CountDownLatch CDL_for_end,AtomicBoolean isWin, Semaphore smp) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.CDL_for_start=CDL_for_start;
        this.CDL_for_end=CDL_for_end;
        this.isWin=isWin;
        this.smp=smp;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            CDL_for_start.countDown();
            CDL_for_start.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            if(race.getStages().get(i).isTunnel())
            {
                try {
                    smp.acquire();
                    race.getStages().get(i).go(this);
                    smp.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else
                race.getStages().get(i).go(this);
        }
        CDL_for_end.countDown();
        if(!(isWin.get())){ //в принципе, можно было сделать не передавая атомарный булеан с помощью счетчика :)
            isWin.set(true);
            System.out.println(this.name + " WIN");
        }

    }
}