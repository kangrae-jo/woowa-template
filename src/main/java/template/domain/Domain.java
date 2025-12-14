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

}
