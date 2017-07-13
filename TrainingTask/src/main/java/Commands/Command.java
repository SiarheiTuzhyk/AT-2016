package Commands;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Should be realizable in class which implements this interface.
 *
 * @author Siarhei_Tuzhyk
 * @version 1.0
 */
public interface Command {
    void execute(FTPClient ftpClient) throws IOException;
    boolean isExecutable(String command);
}
