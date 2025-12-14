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
        String[] intAndStr = input.split(",");
        if (intAndStr.length != 2) {
            throw new IllegalArgumentException("입력은 '숫자,문자열' 형식이어야 합니다.");
        }

        return Domain.of(Integer.parseInt(intAndStr[0].trim()), intAndStr[1].trim());
    }

}
