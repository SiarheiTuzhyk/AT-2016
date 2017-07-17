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
 * Class of <>download</> command execution.
 *
 * @author Siarhei_Tuzhyk
 */
public class DownloadFileFTPCommand implements FTPCommand {

    private static final String SUCCESS_DOWNLOAD = "File  has been downloaded successfully.";
    private static final String FAILED_DOWNLOAD = "Failed to download!";
    private static final String CHANGE_WORKING_DIRECTORY = "Change working directory to: ";
    private static final String NO_SUCH_FILE = "No such file in directory!";

    /**
     * Method for command execution.
     *
     * @param ftpClient object of FTP Client
     * @param instruction parsed instruction for execute
     * @throws IOException if exceptions whit <>FTPClient</>
     */
    public void execute(FTPClient ftpClient, Instruction instruction) throws IOException {
        if (ftpClient.isConnected()) {
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            String workingDirectory = ftpClient.printWorkingDirectory();
            String remoteFile = instruction.getPath();

            FTPFile[] filesPerPath = ftpClient.listFiles(workingDirectory);
            for (FTPFile ftpFile : filesPerPath) {
                if (ftpFile.getName().equals(instruction.getPath()) && ftpFile.isDirectory()) {
                    ftpClient
                        .changeWorkingDirectory(workingDirectory.concat(SEPARATOR + remoteFile));
                    System.out
                        .println(CHANGE_WORKING_DIRECTORY + ftpClient.printWorkingDirectory());
                } else if (ftpFile.getName().equals(instruction.getPath()) && ftpFile.isFile()) {
                    if (isSaveFile(ftpClient, remoteFile, workingDirectory)) {
                        System.out.println(SUCCESS_DOWNLOAD);
                    } else {
                        System.out.println(FAILED_DOWNLOAD);
                    }
                }
            }
        } else {
            System.out.println(FAIL_CONNECT + "\n" + FAIL_RESULT);
        }

    }

    /**
     * Check entered command with the proposed.
     *
     * @param instruction parsed instruction
     * @return <>true</> if entered command equals with proposed. <>false</> otherwise.
     */
    public boolean isExecutable(Instruction instruction) {
        return instruction.getCommand().equals(Commands.download.name());
    }

    /**
     *
     * @param ftpClient
     * @param remoteFile
     * @param workingDirectory
     * @return
     * @throws IOException
     */
    private boolean isSaveFile(FTPClient ftpClient, String remoteFile, String workingDirectory)
        throws IOException {
        new File(".//download").mkdir();
        File downloadFile = new File(".//download/".concat(remoteFile));
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(downloadFile));
        boolean success = ftpClient
            .retrieveFile(workingDirectory.concat(SEPARATOR + remoteFile), outputStream);
        outputStream.close();
        return success;
    }
}
