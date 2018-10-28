package yevtukh.anton;

import org.junit.Test;

public class MessageReceiverTest {

    private MessageReceiver messageReceiver = new MessageReceiver();

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionOnEmptyInputString() {
        String message = "";
        messageReceiver.receive(message);
    }

    @Test
    public void shouldReceiveValidMessage() {
        String message = "InstructionMessage A MZ89 5678 50 2015-03-05T10:04:56.012Z";
        messageReceiver.receive(message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInputStringDoesNotContainsSixParts() {
        String message = "Instruction Message W MZ89 5678 50 2015-03-05T10:04:56.012Z";
        messageReceiver.receive(message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInputStringDoesNotStartsWithInstructionMessage() {
        String message = "A A MZ89 5678 50 2015-03-05T10:04:56.012Z";
        messageReceiver.receive(message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInputStringDoesNotContainValidInstructionType() {
        String message = "InstructionMessage PP MZ89 5678 50 2015-03-05T10:04:56.012Z";
        messageReceiver.receive(message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInputStringDoesNotContainValidProductCode() {
        String message = "InstructionMessage A M89 5678 50 2015-03-05T10:04:56.012Z";
        messageReceiver.receive(message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInputStringDoesNotContainValidQuantity() {
        String message = "InstructionMessage A MZ89 A 50 2015-03-05T10:04:56.012Z";
        messageReceiver.receive(message);
    }
}
