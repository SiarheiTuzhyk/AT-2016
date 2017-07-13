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
        }
    }

    public boolean isExecutable(String command) {
        return false;
    }
}
