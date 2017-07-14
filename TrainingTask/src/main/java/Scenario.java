import Commands.Command;
import Instruction.Instruction;
import java.io.IOException;
import java.util.List;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class Scenario {

    private List<Command> commandsBuild;
    private FTPClient ftpClient;

    public Scenario(FTPClient ftpClient) {
        commandsBuild = new CommandInitialization().getInitializationCommands();
        this.ftpClient = ftpClient;
    }

    public void resultOfCommandImplementation(Instruction enteredInstruction) throws IOException {
        try {
            if (enteredInstruction != null) {
                for (Command command : commandsBuild) {
                    if (command.isExecutable(enteredInstruction)) {
                        command.execute(ftpClient, enteredInstruction);
                    }
                }
            }
        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }
}
