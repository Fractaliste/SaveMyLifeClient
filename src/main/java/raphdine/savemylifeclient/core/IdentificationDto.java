package raphdine.savemylifeclient.core;

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
        return hostname;
    }

    /**
     * @param hostname the hostname to set
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

}
