package raphdine.savemylifeclient.api;

import javax.ws.rs.*;
import raphdine.savemylifeclient.core.shutdown.ShutdownStatutDto;

/**
 *
 * @author Raphiki
 */
//@Path("sml")
public interface ISaveMyLife {

    @Path("test/{test}")
    @GET
    public String test(@PathParam("test") String qui);

    @POST
    @Path("shutdown/{nbHeure}/{nbMinute}")
    public void scheduleShutdown(@PathParam("nbHeure") Integer nbHeure, @PathParam("nbMinute") Integer nbMinute);

    @GET
    @Path("shutdown/statut")
    @Produces("application/json")
    public ShutdownStatutDto getShutdownStatut();
}
