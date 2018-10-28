package yevtukh.anton;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstructionMessageTest {

    @Test
    public void shouldSetInstructionTypeFor() {
        InstructionMessage instructionMessage = new InstructionMessage();
        instructionMessage.setInstructionType("A");
        assertEquals("A", instructionMessage.getInstructionType("A"));
    }
}
