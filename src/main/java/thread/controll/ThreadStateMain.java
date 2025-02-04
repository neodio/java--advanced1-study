package thread.controll;

import util.MyLogger;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        MyLogger.log("myThread.state1 = " + thread.getState());
        MyLogger.log("myThread.start()");
        thread.start();
        Thread.sleep(1000);
        MyLogger.log("myThread.state3 = " + thread.getState()); // TIMED_WAITING
        Thread.sleep(4000);
        MyLogger.log("myThread.state5 = " + thread.getState()); // TERMINATED
        MyLogger.log("end");
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                MyLogger.log("start");
                MyLogger.log("myThread.state2 = " + Thread.currentThread().getState()); // RUNNABLE

                MyLogger.log("sleep() start");
                Thread.sleep(3000);
                MyLogger.log("sleep() end");

                MyLogger.log("myThread.state4 = " + Thread.currentThread().getState()); // RUNNABLE
                MyLogger.log("end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
