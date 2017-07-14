package Commands;

import Instruction.Instruction;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class ConnectToServerCommand implements Command {

    public void execute(FTPClient ftpClient, Instruction instruction) throws IOException {

        ftpClient.connect(instruction.getHostName());
        ftpClient.enterRemotePassiveMode();
        ftpClient.login(instruction.getLogin(), instruction.getPassword());
        if (ftpClient.isConnected()) {
            System.out.println("Connected;");
            System.out.println("Result: Success!");
        } else {
            System.out.println("You are not connect to ftp-server.");
            System.out.println("Result: Fail!");
        }
    }

    public boolean isExecutable(Instruction instruction) {
        return instruction.getCommand().equals("connect");
    }
}
