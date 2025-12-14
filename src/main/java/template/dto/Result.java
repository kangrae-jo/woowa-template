package template.dto;

import template.domain.Domain;

public record Result(int integer, String string) {

    public static Result from(Domain domain) {
        return new Result(
                domain.getInteger(),
                domain.getString()
        );
    }

}
