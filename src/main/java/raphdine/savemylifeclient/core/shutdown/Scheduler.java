package raphdine.savemylifeclient.core.shutdown;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raphiki
 */
public class Scheduler {

    private static final Scheduler INSTANCE = new Scheduler();
    private ScheduledFuture<?> future;

    public static Scheduler getInstance() {
        return INSTANCE;
    }

    public void schedule(Runnable callable, Integer nbHeure, Integer nbMinute) {
        Long delay = getMinutes(nbHeure, nbMinute);
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        future = executor.schedule(callable, delay, TimeUnit.MINUTES);
    }

    public ShutdownStatutDto getStatut() {
        if (future == null) {
            return null;
        }

        ShutdownStatutDto statut = new ShutdownStatutDto();
        statut.setFinished(future.isDone());
        statut.setRemainingDelay(future.getDelay(TimeUnit.MINUTES));
        return statut;
    }

    private Long getMinutes(Integer nbHeure, Integer nbMinute) {
        Logger.getLogger("er").log(Level.SEVERE, nbHeure + " / " + nbMinute);
        return Long.valueOf(nbHeure * 60 + nbMinute);
    }
}
