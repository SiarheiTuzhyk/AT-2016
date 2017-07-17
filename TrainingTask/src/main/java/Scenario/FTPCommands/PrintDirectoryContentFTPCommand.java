package Scenario.FTPCommands;

import Scenario.Commands;
import Scenario.Instruction.Instruction;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 * Class of <>printCont</> command execution.
 *
 * @author Siarhei_Tuzhyk
 */
public class PrintDirectoryContentFTPCommand implements FTPCommand {

    /**
     * Method for command execution.
     *
     * @param ftpClient object of FTP Client
     * @param instruction parsed instruction for execute
     * @throws IOException if exceptions whit <>FTPClient</>
     */
    public void execute(FTPClient ftpClient, Instruction instruction) throws IOException {
        if (ftpClient.isConnected()) {
            FTPFile[] files = ftpClient.listFiles();
            for (FTPFile file : files) {
                System.out.println(file.getName());
            }
            System.out.println(SUCCESS_RESULT);
        } else {
            System.out.println(FAIL_CONNECT + "\n" + FAIL_RESULT);
        }
    }

    /**
     * Check entered command with the proposed.
     *
     * @param instruction parsed instruction
     * @return <>true</> if entered command equals with proposed. <>false</> otherwise.
     */
    public boolean isExecutable(Instruction instruction) {
        return instruction.getCommand().equals(Commands.printCont.name());
    }
}
