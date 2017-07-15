import Scenario.Parser.ParseEnteredString;
import Scenario.Scenario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;


/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class Main {

    private static final String USAGE = "USAGE:"
        + "\nConnect to FTP Server - connect <hostname> <login> <password>"
        + "\nDownload file - download <fileName>"
        + "\nGo into folder - goInto <path>"
        + "\nGo to parent directory - goToParentDir"
        + "\nPrint directory content - printCont"
        + "\nEmpty string - end of program!";


    public static void main(String[] args) {
        System.out.println(USAGE);

        // TODO: 7/13/2017 Maybe, FTPClient must be a singleton!
        FTPClient ftpClient = new FTPClient();
        FTPClientConfig config = new FTPClientConfig(FTPClientConfig.SYST_L8);
        ftpClient.configure(config);

        String enteredString;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Scenario scenario = new Scenario(ftpClient);
            while (!(enteredString = reader.readLine()).isEmpty()) {
                scenario.resultOfCommandImplementation(
                    ParseEnteredString.getInstruction(enteredString));
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
