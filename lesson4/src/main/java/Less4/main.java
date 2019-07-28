package Less4;

public class main {

    static Object lock = new Object();
    static volatile char LastSym = 'C';

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0;i<5;i++){
                    synchronized (lock){
                        try {
                            while (LastSym!='C')
                                lock.wait();
                            LastSym='A';
                            System.out.println("A");
                            lock.notifyAll();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0;i<5;i++)
                    synchronized (lock){
                        try {
                            while (LastSym!='A')
                                lock.wait();
                            LastSym='B';
                            System.out.println("B");
                            lock.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        });
        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0;i<5;i++)
                    synchronized (lock){
                        try {
                            while (LastSym!='B')
                                lock.wait();
                            LastSym='C';
                            System.out.println("C");
                            lock.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}

