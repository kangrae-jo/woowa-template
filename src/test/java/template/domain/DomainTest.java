package template.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class DomainTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,kng", "2 , kng", "10,hello", "  3  , name  "})
    void Domain은_숫자_콤마_문자열_형식이면_생성에_성공한다(String input) {
        Domain domain = Domain.from(input);

        assertThat(domain).isNotNull();
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {
            "",             // 빈 문자열
            "   ",          // 공백만
            "1",            // 콤마 없음
            "1,",           // 뒷부분 비어 있음
            "1, ",          // 뒷부분 공백
            ",kng",         // 앞부분 비어 있음
            "1,,kng",       // 콤마 두 개
            "abc,kng",      // 숫자 자리에 문자가 옴
            "1,kng,extra"   // 토큰 3개
    })
    void Domain은_형식이_아니면_예외를_던진다(String input) {
        assertThatThrownBy(() -> Domain.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
