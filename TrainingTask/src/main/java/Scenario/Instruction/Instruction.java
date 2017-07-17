package Scenario.Instruction;

import Scenario.Commands;

/**
 * Class of instruction.
 *
 * @au
 */
public class Instruction {

    private String command;
    private String hostName;
    private String login;
    private String password;
    private String path;

    /**
     * Constructor of command <>connect</>
     */
    public Instruction(String command, String hostName, String login, String password) {
        this.command = command;
        this.hostName = hostName;
        this.login = login;
        this.password = password;
    }

    /**
     * Constructor of command <>goToParentDir</> and <>printCont</>
     */
    public Instruction(String command) {
        this.command = command;
    }

    /**
     * Constructor of command <>goInto</> and <>download</>
     */
    public Instruction(String command, String path) {
        this.command = command;
        this.path = path;
    }

    /**
     * Getter of commands.
     * @return name of command
     */
    public String getCommand() {
        return command;
    }

    /**
     * Getter for <>connect</> command.
     * @return host name server.
     * If command not equals as <>connect</>, will return null.
     */
    public String getHostName() {
        return command.equals(Commands.connect.name()) ? hostName : null;
    }

    /**
     * Getter for <>connect</> command.
     * @return login of host name server.
     * If command not equals as <>connect</>, will return null.
     */
    public String getLogin() {
        return command.equals(Commands.connect.name()) ? login : null;
    }

    /**
     * Getter for <>connect</> command.
     * @return password of host name server.
     * If command not equals as <>connect</>, will return null.
     */
    public String getPassword() {
        return command.equals(Commands.connect.name()) ? password : null;
    }

    /**
     * Getter for <>goInto</> and <>download</> command.
     * @return path for file or directory.
     * If command not equals as <>goInto</> or <>download</>, will return null.
     */
    public String getPath() {
        return command.equals(Commands.download.name()) || command.equals(Commands.goInto.name())
            ? path : null;
    }
}
