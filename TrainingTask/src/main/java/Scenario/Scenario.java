package Scenario;

import Scenario.FTPCommands.FTPCommand;
import Scenario.Instruction.Instruction;
import java.io.IOException;
import java.util.List;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Class, where command is execute.
 *
 * @author Siarhei_Tuzhyk
 */
public class Scenario {

    private List<FTPCommand> commandsBuild;
    private FTPClient ftpClient;


    /**
     * Constructor of class. Initialize list of commands for further usage.
     * @param ftpClient object of FTP client.
     */
    public Scenario(FTPClient ftpClient) {
        commandsBuild = new CommandInitialization().getListOfFTPCommands();
        this.ftpClient = ftpClient;
    }

    /**
     * Method, where check command for execution.
     * @param enteredInstruction entered instruction from console.
     * @throws IOException if we have exceptions with <class>FTPClient<class/>
     */
    public void resultOfCommandImplementation(Instruction enteredInstruction) throws IOException {
        try {
            if (enteredInstruction != null) {
                for (FTPCommand FTPCommand : commandsBuild) {
                    if (FTPCommand.isExecutable(enteredInstruction)) {
                        FTPCommand.execute(ftpClient, enteredInstruction);
                    }
                }
            }
        } catch (IOException ex) {
            throw new IOException(ex.getMessage());
        }
    }
}
