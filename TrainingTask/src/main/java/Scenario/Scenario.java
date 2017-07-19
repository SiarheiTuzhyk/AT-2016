package scenario;

import scenario.ftpCommands.FTPCommand;
import scenario.instruction.Instruction;
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
     *
     * @param ftpClient object of FTP client.
     */
    public Scenario(FTPClient ftpClient) {
        commandsBuild = new CommandInitialization().getListOfFTPCommands();
        this.ftpClient = ftpClient;
    }

    /**
     * Method, where check command for execution and implements him.
     *
     * @param enteredInstruction entered instruction from console.
     * @throws IOException if we have exceptions with <class>FTPClient<class/>
     */
    public void commandImplementation(Instruction enteredInstruction) throws IOException {
        for (FTPCommand FTPCommand : commandsBuild) {
            if (FTPCommand.isExecutable(enteredInstruction)) {
                FTPCommand.execute(ftpClient, enteredInstruction);
            }
        }
    }
}
