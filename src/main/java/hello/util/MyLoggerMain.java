package hello.util;

import static hello.util.MyLogger.log;

public class MyLoggerMain {

    public static void main(String[] args) {
        log("hello thread");
        log(123);
    }
}
