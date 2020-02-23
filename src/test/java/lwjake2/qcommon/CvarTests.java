package lwjake2.qcommon;

import lwjake2.game.cvar_t;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lwjake2.Defines.CVAR_SERVERINFO;
import static lwjake2.Defines.CVAR_USERINFO;
import static lwjake2.Globals.cvar_vars;
import static org.junit.jupiter.api.Assertions.*;

class CvarTests {

    @BeforeEach
    void ClearCvarVars() {
        cvar_vars = null;
    }

    @ParameterizedTest
    @ValueSource(strings = { "var\\", "\\var", "var\"", "\"var", "var;", ";var" })
    void GetReturnsNullWhenINFOVarNameContainsInvalidCharacters(String var_name) {
        assertNull(Cvar.Get(var_name, "value", CVAR_USERINFO));
        assertNull(Cvar.Get(var_name, "value", CVAR_SERVERINFO));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = { "value\\", "\\value", "value\"", "\"value", "value;", ";value" })
    void GetReturnsNullWhenINFOVarValueContainsInvalidCharactersOrNull(String var_value) {
        assertNull(Cvar.Get("var", var_value, CVAR_USERINFO));
        assertNull(Cvar.Get("var", var_value, CVAR_SERVERINFO));
    }

    @Test
    void GetCreatesNewVarIfNoVarWithSameNameExistedBefore() {
        int expected_flags = 8;
        cvar_t actual_var = Cvar.Get("var", "value", expected_flags);

        assertNotNull(actual_var);
        assertEquals(cvar_vars, actual_var);
        assertEquals("var", actual_var.name);
        assertEquals("value", actual_var.string);
        assertTrue(actual_var.modified);
        assertNull(actual_var.next);
        assertEquals(expected_flags, actual_var.flags);
    }

    @ParameterizedTest
    @ValueSource(strings = { "1", "1.5" })
    void GetParsesVarValueToFloatWhenCreatesNewVar(String var_value) {
        cvar_t actual_var = Cvar.Get("var", var_value, 8);
        assertEquals(Float.parseFloat(var_value), actual_var.value);
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = { "not_number" })
    void GetSetsVarValueTo0WhenCreatesNewVar(String var_value) {
        cvar_t actual_var = Cvar.Get("var", var_value, 8);
        assertEquals(0.0f, actual_var.value);
    }
}