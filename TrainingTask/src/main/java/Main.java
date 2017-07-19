import scenario.Scenario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import scenario.parser.ParserOfEnteredString;

/**
 * Main class of program.
 *
 * @author Siarhei_Tuzhyk
 */
public class Main {

    private static final String USAGE = "USAGE:"
        + "\nConnect to FTP Server - connect <hostname> <login> <password>"
        + "\nDownload file - download <fileName>"
        + "\nGo into folder - into <path>"
        + "\nGo to parent directory - out"
        + "\nPrint directory content - print"
        + "\nEmpty string - end of program!";

    /**
     * Entrance to solution. Create objects of classes for further usage and use object of
     * <>BufferedReader</> class to get instructions from console.
     *
     * @param args arguments from command line.
     */
    public static void main(String[] args) {
        System.out.println(USAGE);

        CustomFTPClient customFtpClient = new CustomFTPClient();
        customFtpClient.createFTPClient();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Scenario scenario = new Scenario(customFtpClient.getFtpClient());
            String enteredString;
            ParserOfEnteredString parserOfEnteredString = new ParserOfEnteredString();
            while (!(enteredString = reader.readLine()).isEmpty()) {
                scenario.commandImplementation(parserOfEnteredString.getInstruction(enteredString));
            }
        } catch (IOException e) {
            System.out.println("Can't read the command: " + e.getMessage());
        } finally {
            customFtpClient.disconnectCustomFTPClient();
        }
    }
}
