package raphdine.savemylifeclient.core.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raphiki
 */
public class SmlConfiguration {

    private static final String FILE = "/sml.properties";
    private static final SmlConfiguration INSTANCE = new SmlConfiguration();

    private Properties properties;

    public SmlConfiguration() {
        InputStream in = null;
        try {
            properties = new Properties();
            in = this.getClass().getResourceAsStream(FILE);
            properties.load(in);
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(SmlConfiguration.class.getName()).log(Level.SEVERE, "Loading du fichier de configuration failed", ex);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(SmlConfiguration.class.getName()).log(Level.SEVERE, "IS.close failed", ex);
            }
        }
    }

    private String getProperty(String p) {
        return properties.getProperty(p);
    }

    private static SmlConfiguration getInstance() {
        return INSTANCE;
    }

    public static String getDeviceName() {
        return getInstance().getProperty("device.name");
    }

}
