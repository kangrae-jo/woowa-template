package template.domain;

public class Domain {

    private final int integer;
    private final String string;

    private Domain(int integer, String string) {
        this.integer = integer;
        this.string = string;
    }

    public static Domain of(int integer, String string) {
        return new Domain(integer, string);
    }

    public static Domain from(String input) {
        String[] intAndStr = splitAndValidate(input);
        String numberPart = intAndStr[0].trim();
        String textPart = intAndStr[1].trim();

        try {
            int integer = Integer.parseInt(numberPart);
            return Domain.of(integer, textPart);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("첫 번째 값은 숫자여야 합니다.");
        }
    }

    public int getInteger() {
        return integer;
    }

    public String getString() {
        return string;
    }

    private static String[] splitAndValidate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력이 비어 있습니다.");
        }

        String[] parts = input.split(",");
        if (parts.length != 2 || parts[0].isBlank() || parts[1].isBlank()) {
            throw new IllegalArgumentException("입력은 '숫자,문자열' 형식이어야 합니다.");
        }

        return parts;
    }

}
