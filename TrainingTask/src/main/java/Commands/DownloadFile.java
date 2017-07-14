package Commands;

import Instruction.Instruction;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class DownloadFile implements Command {


    public void execute(FTPClient ftpClient, Instruction instruction) throws IOException {
        if (ftpClient.isConnected()) {
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            String workingDirectory = ftpClient.printWorkingDirectory();
            String remoteFile = instruction.getPath();

            FTPFile[] filesPerPath = ftpClient.listFiles(workingDirectory);
            for (FTPFile ftpFile : filesPerPath) {
                if (ftpFile.getName().equals(instruction.getPath()) && ftpFile.isDirectory()) {
                    ftpClient.changeWorkingDirectory(workingDirectory.concat("/" + remoteFile));
                    System.out
                        .println("Change work directory to: " + ftpClient.printWorkingDirectory());
                } else if (ftpFile.getName().equals(instruction.getPath()) && ftpFile
                    .isFile()) {
                    boolean dirDownload = new File(".//Download").mkdir();
                    File downloadFile = new File(".//Download/".concat(remoteFile));

                    OutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream(downloadFile));
                    boolean success = ftpClient
                        .retrieveFile(workingDirectory.concat("/" + remoteFile), outputStream);
                    outputStream.close();
                    if (success) {
                        System.out.println("Result: File  has been downloaded successfully.");
                    } else {
                        System.out.println("Failed to download!");
                    }
                }
            }
        } else {
            System.out.println("You are not connect to ftp-server.");
            System.out.println("Result: Fail!");
        }

    }

    public boolean isExecutable(Instruction instruction) {
        return instruction.getCommand().equals("download");
    }
}
