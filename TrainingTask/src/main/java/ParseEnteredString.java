import Instruction.Instruction;

/**
 * Created by Siarhei_Tuzhyk on 7/14/2017.
 */
public class ParseEnteredString {

    private String command;

    public Instruction getInstruction(String enteredStr) {
        String[] components = enteredStr.split(" ", 2);
        this.command = components[0];
        if (command.equals("connect")) {
            String[] argument = components[1].split(" ", 3);
            String hostName = argument[0].substring(0, argument[0].length());
            String login = argument[1].substring(0, argument[1].length());
            String password = argument[2].substring(0, argument[2].length());
            return new Instruction(command, hostName, login, password);
        } else if (command.equals("download") || command.equals("goInto")) {
            String path = components[1].substring(0, components[1].length());
            return new Instruction(command, path);
        } else if (command.equals("goToParentDir") || command.equals("printCont")) {
            return new Instruction(command);
        } else {
            System.out.println("Not valid command!");
            return null;
        }
    }
}
