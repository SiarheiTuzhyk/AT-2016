package Scenario.FTPCommands;

import Scenario.Commands;
import Scenario.Instruction.Instruction;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class GoToParentDirectoryFTPCommand implements FTPCommand {

    public void execute(FTPClient ftpClient, Instruction instruction) throws IOException {
        if (ftpClient.isConnected()) {
            ftpClient.changeToParentDirectory();
            System.out.println(SUCCESS_RESULT);
        } else {
            System.out.println(FAIL_CONNECT+"\n"+FAIL_RESULT);
        }
    }

    public boolean isExecutable(Instruction instruction) {
        return instruction.getCommand().equals(Commands.goToParentDir.name());
    }
}
