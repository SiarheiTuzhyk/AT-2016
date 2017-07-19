import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;

/**
 * Class, which create and disconnect FTPClient from server.
 * @author Siarhei_Tuzhyk
 */
public class CustomFTPClient {

    private static final String NOT_DISCONNECT = "Client didn't disconnect with server!";
    private FTPClient ftpClient;

    public CustomFTPClient() {
        ftpClient = new FTPClient();
    }

    public FTPClient createFTPClient() {
        FTPClientConfig config = new FTPClientConfig(FTPClientConfig.SYST_L8);
        ftpClient.configure(config);
        return ftpClient;
    }

    public void disconnectCustomFTPClient() {
        try {
            disconnectFTPClient();
        } catch (IOException ex) {
            System.out.println(NOT_DISCONNECT + ex.getMessage());
        }
    }

    private void disconnectFTPClient() throws IOException {
        if (ftpClient.isConnected()) {
            ftpClient.logout();
            ftpClient.disconnect();
        }
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }
}
