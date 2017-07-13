import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;


/**
 * Created by Siarhei_Tuzhyk on 7/13/2017.
 */
public class Main {

    public static void main(String[] args) {

        // TODO: 7/13/2017 Maybe, FTPClient must be a singleton!
        FTPClient ftpClient = new FTPClient();
        FTPClientConfig ftpClientConfig = new FTPClientConfig();
        System.out.println(
            "Usage commands:\nConnect to FTP Server;\nDownload files;\n"
                + "Go into folders;\nGo to parent directory;\nPrint directory content;");

        Scenario scenario = new Scenario(ftpClient);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String enteredCommand = reader.readLine();
            while (!enteredCommand.isEmpty()){
                scenario.resultOfCommandImplementation(enteredCommand);
                enteredCommand = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
