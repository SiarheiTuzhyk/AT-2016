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
 * Class for initialization commands implementation as list.
 *
 * @author Siarhei_Tuzhyk
 */
public class CommandInitialization {

    private List<FTPCommand> listOfFTPCommands;

    /**
     * Constructor of class.
     */
    public CommandInitialization() {
        listOfFTPCommands = initCommands();
    }

    /**
     * Method for initialization commands implementation as list.
     * @return list of commands implementation
     */
    private List<FTPCommand> initCommands() {
        List<FTPCommand> checks = new ArrayList<FTPCommand>();
        checks.add(new ConnectToServerFTPCommand());
        checks.add(new DownloadFileFTPCommand());
        checks.add(new GoIntoFoldersFTPCommand());
        checks.add(new GoToParentDirectoryFTPCommand());
        checks.add(new PrintDirectoryContentFTPCommand());
        return checks;
    }

    public List<FTPCommand> getListOfFTPCommands() {
        return listOfFTPCommands;
    }
}
