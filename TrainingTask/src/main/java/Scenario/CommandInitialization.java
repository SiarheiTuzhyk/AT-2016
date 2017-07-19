package scenario;

import scenario.ftpCommands.FTPCommand;
import scenario.ftpCommands.ConnectToServerFTPCommand;
import scenario.ftpCommands.DownloadFileFTPCommand;
import scenario.ftpCommands.GoIntoFoldersFTPCommand;
import scenario.ftpCommands.GoToParentDirectoryFTPCommand;
import scenario.ftpCommands.PrintDirectoryContentFTPCommand;
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
     *
     * @return list of commands implementation
     */
    private List<FTPCommand> initCommands() {
        List<FTPCommand> ftpCommands = new ArrayList<FTPCommand>();
        ftpCommands.add(new ConnectToServerFTPCommand());
        ftpCommands.add(new DownloadFileFTPCommand());
        ftpCommands.add(new GoIntoFoldersFTPCommand());
        ftpCommands.add(new GoToParentDirectoryFTPCommand());
        ftpCommands.add(new PrintDirectoryContentFTPCommand());
        return ftpCommands;
    }

    public List<FTPCommand> getListOfFTPCommands() {
        return listOfFTPCommands;
    }
}
