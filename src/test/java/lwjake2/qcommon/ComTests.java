package lwjake2.qcommon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComTests {

    @Test
    void sprintfReturnsInputFormatForNullOrEmptyVargs() {
        String expected_fmt = "format";
        assertEquals(expected_fmt, Com.sprintf(expected_fmt, (Object) null));
        assertEquals(expected_fmt, Com.sprintf(expected_fmt));
    }

    @ParameterizedTest
    @CsvSource({
        "str1, '',   ''",
        "str1, str2, ''",
        "str1, str2, str3"
    })
    void sprintfFormatsString(String str1, String str2, String str3) {
        String expected = "Message: " + str1 + " " + str2 + " " + str3;
        assertEquals(expected, Com.sprintf("Message: %s %s %s", str1, str2, str3));
    }
}