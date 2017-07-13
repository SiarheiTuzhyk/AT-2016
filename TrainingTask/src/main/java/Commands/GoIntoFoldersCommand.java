package Commands;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class GoIntoFoldersCommand implements Command {

    public void execute(FTPClient ftpClient) throws IOException {
        ftpClient.connect("ftp://c64.rulez.org/pub/c64/");
    }

    public boolean isExecutable(String command) {
        return false;
    }
}
