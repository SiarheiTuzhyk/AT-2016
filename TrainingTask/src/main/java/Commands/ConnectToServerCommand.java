package Commands;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class ConnectToServerCommand implements Command {

    public void execute(FTPClient ftpClient) throws IOException {
        /*
        int reply;
        ftpClient.connect("ftp.mccme.ru/");
        reply = ftpClient.getReplyCode();
        */
        ftpClient.connect("c64.rulez.org");
        ftpClient.enterRemotePassiveMode();
        ftpClient.login("anonymous", "anonymous");
        if (ftpClient.isConnected()) {
            System.out.println("Connected;");
        } else {
            System.out.println("You are not connect to ftp-server.");
        }
    }

    public boolean isExecutable(String command) {
        return command.equals("connect");
    }
}
