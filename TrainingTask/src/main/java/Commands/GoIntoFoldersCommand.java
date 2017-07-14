package Commands;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class GoIntoFoldersCommand implements Command {

    String command;

    public void execute(FTPClient ftpClient) throws IOException {
        if(ftpClient.isConnected()){
            String workdir = ftpClient.printWorkingDirectory();
            ftpClient.changeWorkingDirectory(workdir+"/"+command.split(" ")[1]);
        } else {
            System.out.println("You are not connect to server!");
        }
    }

    public boolean isExecutable(String command) {
        this.command = command;
        return command.split(" ")[0].equals("goto");
    }
}
