package lwjake2.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LibTests {

    @ParameterizedTest
    @ValueSource(strings = { "1", "999", "1.5", "1.515" })
    void atofParsesFloat(String in) {
        assertEquals(Float.parseFloat(in), Lib.atof(in));
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = { "not_number", ";", "\\" })
    void atofReturns0ForNotNumberInput(String in) {
        assertEquals(0.0f, Lib.atof(in));
    }

    @Test
    void atofOnlyRecognizesDot() {
        assertEquals(0.0f, Lib.atof("1,5"));
    }

    @Test
    void atofThrowsNPEForNullInput() {
        assertThrows(NullPointerException.class, () -> Lib.atof(null));
    }
}