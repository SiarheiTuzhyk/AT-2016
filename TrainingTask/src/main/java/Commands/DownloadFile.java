package Commands;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class DownloadFile implements Command {

    String[] command;

    public void execute(FTPClient ftpClient) throws IOException {
        if (ftpClient.isConnected()) {
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            String workingDirectory = ftpClient.printWorkingDirectory();
            String remoteFile = "/".concat(command[command.length-1]);
            File downloadFile = new File(".//".concat(remoteFile));
            OutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream(downloadFile));
            boolean success = ftpClient.retrieveFile(workingDirectory.concat(remoteFile), outputStream);
            outputStream.close();
            if (success) {
                System.out.println("Result: File  has been downloaded successfully.");
            } else {
                System.out.println("Failed to download!");
            }
        } else {
            System.out.println("You are not connect to ftp-server.");
            System.out.println("Result: Fail!");
        }

    }

    public boolean isExecutable(String command) {
        this.command = command.split(" ");
        return this.command[0].equals("download");
    }
}
