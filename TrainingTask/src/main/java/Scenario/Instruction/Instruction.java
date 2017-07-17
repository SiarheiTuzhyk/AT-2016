package Scenario.Instruction;

import Scenario.Commands;

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
        return command.equals(Commands.connect.name()) ? hostName : null;
    }

    public String getLogin() {
        return command.equals(Commands.connect.name()) ? login : null;
    }

    public String getPassword() {
        return command.equals(Commands.connect.name()) ? password : null;
    }

    public String getPath() {
        return command.equals(Commands.download.name()) || command.equals(Commands.goInto.name())
            ? hostName : null;
    }
}
