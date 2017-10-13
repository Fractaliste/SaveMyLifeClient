package raphdine.savemylifeclient.core.shutdown;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raphiki
 */
@XmlRootElement
public class ShutdownStatutDto {

    private boolean done;
    private long delay;

    void setFinished(boolean done) {
        this.done = done;
    }

    void setRemainingDelay(long delay) {
        this.delay = delay;
    }

    /**
     * @return the done
     */
    public boolean isDone() {
        return done;
    }

    /**
     * @return the delay
     */
    public long getDelay() {
        return delay;
    }

}
