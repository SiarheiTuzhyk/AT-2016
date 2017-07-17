package Scenario;

import Scenario.FTPCommands.FTPCommand;
import Scenario.FTPCommands.ConnectToServerFTPCommand;
import Scenario.FTPCommands.DownloadFileFTPCommand;
import Scenario.FTPCommands.GoIntoFoldersFTPCommand;
import Scenario.FTPCommands.GoToParentDirectoryFTPCommand;
import Scenario.FTPCommands.PrintDirectoryContentFTPCommand;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class CommandInitialization {

    private List<FTPCommand> listOfFTPCommands;

    public CommandInitialization() {
        listOfFTPCommands = initCommands();
    }

    private List<FTPCommand> initCommands() {
        List<FTPCommand> checks = new ArrayList<FTPCommand>();
        checks.add(new ConnectToServerFTPCommand());
        checks.add(new DownloadFileFTPCommand());
        checks.add(new GoIntoFoldersFTPCommand());
        checks.add(new GoToParentDirectoryFTPCommand());
        checks.add(new PrintDirectoryContentFTPCommand());
        return checks;
    }

    public List<FTPCommand> getInitializationCommands() {
        return listOfFTPCommands;
    }
}
