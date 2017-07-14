import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;


/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class Main {

    private static final String USAGE = "Usage commands:"
        + "\nConnect to FTP Server - connect;"
        + "\nDownload file - download;"
        + "\nGo into folders - goInto;"
        + "\nGo to parent directory - parentDir;"
        + "\nPrint directory content - printCont;";

    public static void main(String[] args) {
        System.out.println(USAGE);
        // TODO: 7/13/2017 Maybe, FTPClient must be a singleton!
        FTPClientConfig config = new FTPClientConfig(FTPClientConfig.SYST_L8);
        FTPClient ftpClient = new FTPClient();
        ftpClient.configure(config);
        try {
            Scenario scenario = new Scenario(ftpClient);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\nType your command: ");
            String enteredCommand = reader.readLine();
            while (!enteredCommand.isEmpty()) {
                scenario.resultOfCommandImplementation(enteredCommand);
                System.out.print("\nType your command: ");
                enteredCommand = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
