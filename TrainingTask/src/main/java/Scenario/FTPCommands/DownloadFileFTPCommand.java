package Scenario.FTPCommands;

import Scenario.Commands;
import Scenario.Instruction.Instruction;
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
public class DownloadFileFTPCommand implements FTPCommand {

    private static final String SUCCESS_DOWNLOAD = "File  has been downloaded successfully.";
    private static final String FAILED_DOWNLOAD = "Failed to download!";


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
                    new File(".//download").mkdir();
                    File downloadFile = new File(".//download/".concat(remoteFile));

                    OutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream(downloadFile));
                    boolean success = ftpClient
                        .retrieveFile(workingDirectory.concat(SEPARATOR + remoteFile), outputStream);
                    outputStream.close();
                    if (success) {
                        System.out.println(SUCCESS_DOWNLOAD);
                    } else {
                        System.out.println(FAILED_DOWNLOAD);
                    }
                }
            }
        } else {
            System.out.println(FAIL_CONNECT+"\n"+FAIL_RESULT);
        }

    }

    public boolean isExecutable(Instruction instruction) {
        return instruction.getCommand().equals(Commands.download.name());
    }
}
