import Commands.Command;
import Commands.ConnectToServerCommand;
import Commands.DownloadFile;
import Commands.GoIntoFoldersCommand;
import Commands.GoToParentDirectoryCommand;
import Commands.PrintDirectoryContent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class CommandInitialization {

    private List<Command> listOfCommands;

    public CommandInitialization() {
        listOfCommands = initCommands();
    }

    private List<Command> initCommands() {
        List<Command> checks = new ArrayList<Command>();
        checks.add(new ConnectToServerCommand());
        checks.add(new DownloadFile());
        checks.add(new GoIntoFoldersCommand());
        checks.add(new GoToParentDirectoryCommand());
        checks.add(new PrintDirectoryContent());
        return checks;
    }

    public List<Command> getInitializationCommands() {
        return listOfCommands;
    }
}
