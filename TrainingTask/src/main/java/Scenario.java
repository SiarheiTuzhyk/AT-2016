import Commands.Command;
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

    public void resultOfCommandImplementation(String enteredCommand) throws IOException {
        try {
            int countImplCommand = 0;
            for (Command command : commandsBuild) {
                if (command.isExecutable(enteredCommand)) {
                    command.execute(ftpClient);
                    countImplCommand++;
                }
            }
            if (countImplCommand == 0) {
                System.out.println("Not valid command!");
            }
        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }
}
