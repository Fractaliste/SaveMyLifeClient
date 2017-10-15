package raphdine.savemylifeclient.core;

import javax.ws.rs.Path;
import raphdine.savemylifeclient.api.ISaveMyLife;
import static raphdine.savemylifeclient.core.configuration.SmlConfiguration.getDeviceName;
import raphdine.savemylifeclient.core.shutdown.Scheduler;
import raphdine.savemylifeclient.core.shutdown.ShutdownStatutDto;
import raphdine.savemylifeclient.core.shutdown.ShutdownThread;

/**
 *
 * @author Raphiki
 */
@Path("sml")
public class SaveMyLifeService implements ISaveMyLife {

    @Override
    public String test(String test) {
        return "Hello world !";
    }

    @Override
    public void scheduleShutdown(Integer nbHeure, Integer nbMinute) {

        Runnable callable = ShutdownThread.getInstance();

        Scheduler.getInstance().schedule(callable, nbHeure, nbMinute);
    }

    @Override
    public ShutdownStatutDto getShutdownStatut() {
        return Scheduler.getInstance().getStatut();
    }

    @Override
    public IdentificationDto getIdentification() {
        IdentificationDto i = new IdentificationDto();
        i.setHostname(getDeviceName());
        return i;
    }
}
