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
        + "\nGo to parent directory - goToParentDir;"
        + "\nPrint directory content - printCont;";

    //
    // connect <hostname> <login> <password>
    // goInto <path>
    // goToParentDir
    // download <fileName>
    // printCont
    //
    public static void main(String[] args) {
        System.out.println(USAGE);
        // TODO: 7/13/2017 Maybe, FTPClient must be a singleton!
        FTPClientConfig config = new FTPClientConfig(FTPClientConfig.SYST_L8);
        FTPClient ftpClient = new FTPClient();
        ftpClient.configure(config);
        try {
            Scenario scenario = new Scenario(ftpClient);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ParseEnteredString parseEnteredString = new ParseEnteredString();
            System.out.print("\nType your command: ");
            String enteredString = reader.readLine();
            while (!enteredString.isEmpty()) {
                scenario.resultOfCommandImplementation(
                    parseEnteredString.getInstruction(enteredString));
                System.out.print("\nType your command: ");
                enteredString = reader.readLine();
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
