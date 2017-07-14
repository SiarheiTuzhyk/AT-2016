package Commands;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class GoToParentDirectoryCommand implements Command {

    public void execute(FTPClient ftpClient) throws IOException {
        if(ftpClient.isConnected()){
            ftpClient.changeToParentDirectory();
        } else {
            System.out.println("You are not connect to server!");
        }
    }

    public boolean isExecutable(String command) {
        return command.equals("parent");
    }
}
