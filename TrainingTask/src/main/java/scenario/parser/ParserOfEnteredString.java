package scenario.parser;

import static scenario.Commands.CONNECT;

import customExceptions.NotValidCommandException;
import scenario.Commands;
import scenario.instruction.Instruction;

/**
 * Class parse entered string to
 *
 * @author Siarhei_Tuzhyk
 */
public class ParserOfEnteredString {

    private static final String NOT_VALID_COMMAND = "Not valid command!";
    private static final String WITHOUT_INSTRUCTIONS = "You not entered instructions for command!";
    private static final String SPACE = " ";

    /**
     * Method for getting parse instructions for further usage.
     *
     * @param enteredString entered string from console.
     * @return instruction.
     */
    public Instruction getInstruction(String enteredString) throws NotValidCommandException {

        String[] components = enteredString.split(SPACE, 2);
        String command = components[0];
        try {
            Instruction instruction;
            if (command.equals(CONNECT.name().toLowerCase())) {
                instruction = getInstructionByThreeParam(command, components[1]);
            } else if (command.equals(Commands.DOWNLOAD.name().toLowerCase())
                || command.equals(Commands.INTO.name().toLowerCase())) {
                instruction = getInstructionByOneParam(command, components[1]);
            } else if (command.equals(Commands.OUT.name().toLowerCase())
                || command.equals(Commands.PRINT.name().toLowerCase())) {
                instruction = getInstructionWithoutParam(command);
            } else {
                throw new NotValidCommandException(NOT_VALID_COMMAND);
            }
            return instruction;
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new NotValidCommandException(WITHOUT_INSTRUCTIONS);
        }
    }

    private Instruction getInstructionByThreeParam(String command, String components) {
        String[] argument = components.split(SPACE, 3);
        String hostName = argument[0].substring(0, argument[0].length());
        String login = argument[1].substring(0, argument[1].length());
        String password = argument[2].split(SPACE)[0];
        return new Instruction(command, hostName, login, password);
    }

    private Instruction getInstructionByOneParam(String command, String components) {
        String path = components.split(SPACE)[0];
        return new Instruction(command, path);
    }

    private Instruction getInstructionWithoutParam(String command) {
        return new Instruction(command);
    }
}
