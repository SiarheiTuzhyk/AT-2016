package Commands;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class GoIntoFoldersCommand implements Command {

    String[] command;

    public void execute(FTPClient ftpClient) throws IOException {
        if (ftpClient.isConnected()) {
            String workingDirectory = ftpClient.printWorkingDirectory().concat("/");
            ftpClient
                .changeWorkingDirectory(workingDirectory.concat(command[command.length - 1]));
            System.out.println("Result: Success!");
        } else {
            System.out.println("You are not connect to ftp-server.");
            System.out.println("Result: Fail!");
        }
    }

    public boolean isExecutable(String command) {
        this.command = command.split(" ");
        return this.command[0].equals("goto");
    }
}
