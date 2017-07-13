package Commands;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class PrintDirectoryContent implements Command {

    public void execute(FTPClient ftpClient) throws IOException {
        if(ftpClient.isConnected()){
            FTPFile[] directoryContent = ftpClient.listFiles();
            for (FTPFile ftpFile : directoryContent) {
                System.out.println(ftpFile.getName()+ftpFile.getType());
            }
        }
    }

    public boolean isExecutable(String command) {
        return command.equals("print directory content");
    }
}
