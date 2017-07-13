import Commands.Command;
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
    }

    public void resultOfCommandImplementation(String enteredCommand){
        for (Command command : commandsBuild) {
            if(command.isExecutable(enteredCommand)){
                command.execute(ftpClient);
            }
        }
    }
}
