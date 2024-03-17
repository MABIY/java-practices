package innerclasses.controller;

import java.security.cert.CertPathValidatorException;
import java.time.Duration;
import java.time.Instant;

/**
 * @author lh
 */
public abstract class Event {
    private Instant eventTime;
    protected final Duration delayTime;

    public Event(long millisecondDelay) {
        this.delayTime = Duration.ofMillis(millisecondDelay);
        start();
    }

    public void start() {
        eventTime = Instant.now().plus(delayTime);
    }

    public boolean ready() {
        return Instant.now().isAfter(eventTime);
    }

    public abstract void action();
}
