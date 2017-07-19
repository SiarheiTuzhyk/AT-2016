package scenario.ftpCommands;

import scenario.instruction.Instruction;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Interface should be realizable in class which implements this interface.
 *
 * @author Siarhei_Tuzhyk
 */
public interface FTPCommand {

    static final String FAIL_CONNECT = "You are not connect to ftp-server.";
    static final String FAIL_RESULT = "Result: Fail!";
    static final String SUCCESS_RESULT = "Result: Success!";
    static final String SEPARATOR = "/";

    /**
     * Method for command execution.
     *
     * @param ftpClient object of FTP Client
     * @param instruction parsed instruction for execute
     * @throws IOException if exceptions whit <>FTPClient</>
     */
    void execute(FTPClient ftpClient, Instruction instruction) throws IOException;

    /**
     * Check entered command with the proposed.
     *
     * @param instruction parsed instruction
     * @return <>true</> if entered command equals with proposed. <>false</> otherwise.
     */
    boolean isExecutable(Instruction instruction);
}
