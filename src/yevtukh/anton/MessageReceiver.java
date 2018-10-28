package yevtukh.anton;

public class MessageReceiver {

    public static final String PRODUCT_CODE_REGEXP = "[A-Z]{2}[0-9]{2}";
    public static final String INSTRUCTION_TYPE_REGEXP = "[ABCD]";
    public static final String INSTRUCTION_MESSAGE_PREFIX = "InstructionMessage";

    public void receive(String message) {
        validateInputString(message);
    }

    private void validateInputString(String message) {
        checkEmptyMessage(message);
        String[] parts = message.split(" ");
        validateCountOfParts(parts);
        validateInstructionMessagePrefix(parts[0]);
        validateInstructionType(parts[1]);
        validateProductCode(parts[2]);
        if (Integer.valueOf(parts[3]) <= 0)
            throwException();
    } 

    private void validateProductCode(String productCode) {
        if (!productCode.matches(PRODUCT_CODE_REGEXP))
            throwException();
    }

    private void validateInstructionType(String instructionType) {
        if (!instructionType.matches(INSTRUCTION_TYPE_REGEXP))
            throwException();
    }

    private void validateInstructionMessagePrefix(String prefix) {
        if (!prefix.equals(INSTRUCTION_MESSAGE_PREFIX))
            throwException();
    }

    private void validateCountOfParts(String[] parts) {
        if (parts.length != 6)
            throwException();
    }

    private void checkEmptyMessage(String message) {
        if (message == null || message.isEmpty())
            throwException();
    }

    private void throwException() {
        throw new IllegalArgumentException();
    }

}
