package raphdine.savemylifeclient.core;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raphiki
 */
@XmlRootElement
public class IdentificationDto {

    private String hostname;

    /**
     * @return the hostname
     */
    public String getHostname() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            Enumeration<URL> resources = loader.getResources("jetty-logging.properties");
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                System.err.println("" + resource);
            }

//            URL testProps = Loader.getResource("jetty-logging.properties");
//            System.err.println("Loader => " + testProps);
        } catch (IOException ex) {
            Logger.getLogger(IdentificationDto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hostname;
    }

    /**
     * @param hostname the hostname to set
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

}
