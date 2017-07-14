package Commands;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class PrintDirectoryContent implements Command {

    public void execute(FTPClient ftpClient) throws IOException {
        if (ftpClient.isConnected()) {
            FTPFile[] files = ftpClient.listFiles("");
            for (FTPFile file : files) {
                System.out.println(file.getName());
            }
            System.out.println("Result: Success!");
        } else {
            System.out.println("You are not connect to ftp-server.");
            System.out.println("Result: Fail!");
        }
    }

    public boolean isExecutable(String command) {
        return command.equals("printCont");
    }
}
