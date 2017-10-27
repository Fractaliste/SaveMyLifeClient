/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raphdine.savemylifeclient.core.shutdown;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import raphdine.savemylifeclient.core.SaveMyLifeService;

public class ShutdownThread implements Runnable {

    private static final ShutdownThread INSTANCE = new ShutdownThread();

    private CmdResultDto result;

    public static ShutdownThread getInstance() {
        return INSTANCE;
    }

    @Override
    public void run() {
        try {

            result = new CmdResultDto();

            String command = "shutdown /s";
            Process cmdProc = Runtime.getRuntime().exec(command);

            String stdOut = IOUtils.toString(cmdProc.getInputStream(), "UTF-8");
            result.setStdOut(stdOut);

            String stdErr = IOUtils.toString(cmdProc.getErrorStream(), "UTF-8");
            result.setStdErr(stdErr);

            result.setExitValue(cmdProc.exitValue());
        } catch (IOException ex) {
            Logger.getLogger(SaveMyLifeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CmdResultDto getStatut() {
        return result;
    }

}
