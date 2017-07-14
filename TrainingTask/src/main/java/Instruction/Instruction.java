package Instruction;

/**
 * Created by Siarhei_Tuzhyk on 7/14/2017.
 */
public class Instruction {

    private String command;
    private String hostName;
    private String login;
    private String password;
    private String path;

    public Instruction(String command, String hostName, String login, String password) {
        this.command = command;
        this.hostName = hostName;
        this.login = login;
        this.password = password;
    }

    public Instruction(String command) {
        this.command = command;
    }

    public Instruction(String command, String path) {
        this.command = command;
        this.path = path;
    }

    public String getCommand() {
        return command;
    }

    public String getHostName() {
        if (command.equals("connect")) {
            return hostName;
        } else {
            return null;
        }
    }

    public String getLogin() {
        if (command.equals("connect")) {
            return login;
        } else {
            return null;
        }
    }

    public String getPassword() {
        if (command.equals("connect")) {
            return password;
        } else {
            return null;
        }
    }

    public String getPath() {
        if (command.equals("download") || command.equals("goInto")) {
            return path;
        } else {
            return null;
        }
    }
}
