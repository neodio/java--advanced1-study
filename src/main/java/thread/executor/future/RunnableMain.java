package thread.executor.future;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.Random;

public class RunnableMain {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task, "Thread-1");
        thread.start();
        thread.join();
        int result = task.value;
        log("result value = " + result);
    }

    static class MyRunnable implements Runnable {

        int value;

        @Override
        public void run() {
            log("Runable 시작");
            sleep(2000);
            value = new Random().nextInt(10);
            log("Runable 완료");
        }
    }
}
