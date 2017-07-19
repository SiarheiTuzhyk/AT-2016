package scenario.parser;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeClass;
import scenario.Commands;
import scenario.instruction.Instruction;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test-class for <>ParseEnteredString</>
 */
public class ParserOfEnteredStringTest {

    Instruction instruction;
    ParserOfEnteredString parserOfEnteredString;
    @BeforeClass
    public void setUo(){
        parserOfEnteredString = new ParserOfEnteredString();
    }

    @DataProvider(name = "positive getInstructions command")
    public Object[][] forPositiveGetInstructionCommandTest() {
        return new Object[][]{
            {"connect c64.rulez.org anonymous anonymous", "connect"}, {"printCont", "printCont"},
            {"download hex.jpg", "download"}, {"goToParentDir", "goToParentDir"},
            {"goInto pub", "goInto"}
        };
    }

    @DataProvider(name = "negative getInstructions command")
    public Object[][] forNegativeGetInstructionCommandTest() {
        return new Object[][]{
            {"conect c64.rulez.org  anonymous anonymous", null},
            {" printCont jhew", null}, {" ", null}, {" printCont  jhew", null},
            {"goParentDir hex", null}, {"GOINTRO", null}, {"gointro", null}, {"1", null}
        };
    }

    @DataProvider(name = "positive getInstructions instruction")
    public Object[][] forPositiveGetInstructionTest() {
        return new Object[][]{
            {"connect c64.rulez.org anonymous password", "anonymous"}, {"printCont", null},
            {"printCont pub", null}, {"download hex.jpg", "hex.jpg"},
            {"download hex.jpg sca.exe", "hex.jpg"}, {"goToParentDir", null},
            {"goToParentDir", null}, {"goToParentDir pub", null},
            {"goInto pub", "pub"}, {"goInto pub c61", "pub"}
        };
    }

    @DataProvider(name = "negative getInstructions instruction")
    public Object[][] forNegativeGetInstructionTest() {
        return new Object[][]{
            {"connect c64.rulez.org anonymous", null}, {"connect", null},
            {"connect  anonymous", null}, {"download", null}, {"goInto", null}
        };
    }

    @Test(dataProvider = "positive getInstructions command")
    public void positiveTestGetInstructionCommand(String enteredInstruction, String expectedCommand)
        throws Exception {
        instruction = parserOfEnteredString.getInstruction(enteredInstruction);
        assertEquals(instruction.getCommand(), expectedCommand);
    }

    @Test(dataProvider = "negative getInstructions command")
    public void negativeTestGetInstructionCommand(String enteredInstruction, Instruction expected)
        throws Exception {
        instruction = parserOfEnteredString.getInstruction(enteredInstruction);
        assertEquals(instruction, expected);
    }

    @Test(dataProvider = "positive getInstructions instruction")
    public void positiveTestGetInstruction(String enteredInstruction, String expectedInstruction)
        throws Exception {
        instruction = parserOfEnteredString.getInstruction(enteredInstruction);
        if (instruction.getCommand().equals(Commands.CONNECT.name().toLowerCase())) {
            assertEquals(instruction.getLogin(), expectedInstruction);
        } else if (instruction.getCommand().equals(Commands.DOWNLOAD.name().toLowerCase())
            || instruction.getCommand().equals(Commands.INTO.name().toLowerCase())) {
            assertEquals(instruction.getPath(), expectedInstruction);
        } else if (instruction.getCommand().equals(Commands.OUT.name().toLowerCase())
            || instruction.getCommand().equals(Commands.PRINT.name().toLowerCase())) {
            assertEquals(instruction.getPath(), expectedInstruction);
        }
    }

    @Test(dataProvider = "negative getInstructions instruction")
    public void negativeTestGetInstruction(String enteredInstruction, Instruction expected)
        throws Exception {
        instruction = parserOfEnteredString.getInstruction(enteredInstruction);
        assertEquals(instruction, expected);
    }
}