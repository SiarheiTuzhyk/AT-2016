package Commands;

import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class DownloadFile implements Command {

    public void execute(FTPClient ftpClient) {

    }

    public boolean isExecutable(String command) {
        return command.equals("download");
    }
}
