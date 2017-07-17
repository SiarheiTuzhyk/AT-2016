package Scenario.Parser;

import Scenario.Commands;
import Scenario.Instruction.Instruction;

/**
 * Class parse entered string to <class>Instruction<class/>
 *
 * @author Siarhei_Tuzhyk
 */
public class ParseEnteredString {

    private static final String NOT_VALID_COMMAND = "Not valid command!";
    private static final String WITHOUT_INSTRUCTIONS = "You not entered instructions for command!";
    private static final String SPACE = " ";

    /**
     * Method for getting parse instructions for further usage.
     * @param enteredStr entered string from console.
     * @return instruction.
     */
    public static Instruction getInstruction(String enteredStr) {

        String[] components = enteredStr.split(SPACE, 2);
        String command = components[0];
        try {
            if (command.equals(Commands.connect.name())) {
                String[] argument = components[1].split(SPACE, 3);
                String hostName = argument[0].substring(0, argument[0].length());
                String login = argument[1].substring(0, argument[1].length());
                String password = argument[2].substring(0, argument[2].length());
                return new Instruction(command, hostName, login, password);
            } else if (command.equals(Commands.download.name()) || command
                .equals(Commands.goInto.name())) {
                String path = components[1].substring(0, components[1].length());
                return new Instruction(command, path);
            } else if (command.equals(Commands.goToParentDir.name()) || command
                .equals(Commands.printCont.name())) {
                return new Instruction(command);
            } else {
                System.out.println(NOT_VALID_COMMAND);
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(WITHOUT_INSTRUCTIONS);
            return null;
        }
    }
}
