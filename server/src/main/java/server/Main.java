package server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    static final Logger infoLogger = LogManager.getRootLogger();

    public static void main(String[] args) {
        infoLogger.info("Server is on");
        new Listener();
    }


}
