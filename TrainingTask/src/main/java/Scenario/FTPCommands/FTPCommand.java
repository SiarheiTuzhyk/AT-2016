package Scenario.FTPCommands;

import Scenario.Instruction.Instruction;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Should be realizable in class which implements this interface.
 *
 * @author Siarhei_Tuzhyk
 * @version 1.0
 */
public interface FTPCommand {

    static final String FAIL_CONNECT = "You are not connect to ftp-server.";
    static final String FAIL_RESULT = "Result: Fail!";
    static final String SUCCESS_RESULT = "Result: Success!";
    static final String SEPARATOR = "/";

    void execute(FTPClient ftpClient, Instruction instruction) throws IOException;

    boolean isExecutable(Instruction command);
}
