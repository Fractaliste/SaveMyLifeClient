/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raphdine.savemylifeclient.core.shutdown;

/**
 *
 * @author Raphiki
 */
public class CmdResultDto {

    private int exitValue;
    private String stdOut;
    private String stdErr;

    void setExitValue(int exitValue) {
        this.exitValue = exitValue;
    }

    void setStdOut(String stdOut) {
        this.stdOut = stdOut;
    }

    void setStdErr(String stdErr) {
        this.stdErr = stdErr;
    }

}
