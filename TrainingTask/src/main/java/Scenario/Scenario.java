package Scenario;

import Scenario.FTPCommands.FTPCommand;
import Scenario.Instruction.Instruction;
import java.io.IOException;
import java.util.List;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class Scenario {

    private List<FTPCommand> commandsBuild;
    private FTPClient ftpClient;

    public Scenario(FTPClient ftpClient) {
        commandsBuild = new CommandInitialization().getInitializationCommands();
        this.ftpClient = ftpClient;
    }

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
            throw new IOException(ex);
        }
    }
}
