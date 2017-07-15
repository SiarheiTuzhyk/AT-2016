package Scenario.FTPCommands;

import Scenario.Commands;
import Scenario.Instruction.Instruction;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class PrintDirectoryContentFTPCommand implements FTPCommand {

    public void execute(FTPClient ftpClient, Instruction instruction) throws IOException {
        if (ftpClient.isConnected()) {
            FTPFile[] files = ftpClient.listFiles();
            for (FTPFile file : files) {
                System.out.println(file.getName());
            }
            System.out.println(SUCCESS_RESULT);
        } else {
            System.out.println(FAIL_CONNECT+"\n"+FAIL_RESULT);
        }
    }

    public boolean isExecutable(Instruction instruction) {
        return instruction.getCommand().equals(Commands.printCont.name());
    }
}
