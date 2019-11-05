package lk.sliit.iblood.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-11-02
 * Time: 12:03 PM
 */
class ValidatorTest {

    @Test
    void validateNIC() {
        boolean actual = Validator.validateNIC("982113503V");
        assertTrue(actual);
    }

    @Test
    void validateMobile() {
        boolean actual = Validator.validateNIC("0765665475");
        assertTrue(actual);
    }

    @Test
    void isDouble() {
        boolean actual1 = Validator.isDouble("12.23");
        boolean actual2 = Validator.isDouble("");
        boolean actual3 = Validator.isDouble("567");
        boolean actual4 = Validator.isDouble("0.12");
        boolean actual5 = Validator.isDouble("34");

        boolean actual6 = Validator.isDouble("as");
        boolean actual7 = Validator.isDouble("as12");
        boolean actual8 = Validator.isDouble("as12");
        boolean actual9 = Validator.isDouble("12");
        boolean actual10 = Validator.isDouble("2a21");

        assertAll(
                () -> assertTrue(actual1),
                () -> assertTrue(actual2),
                () -> assertTrue(actual3),
                () -> assertTrue(actual4),
                () -> assertTrue(actual5),

                () -> assertFalse(actual6),
                () -> assertFalse(actual7),
                () -> assertFalse(actual8),
                () -> assertFalse(actual9),
                () -> assertFalse(actual10)
        );
    }
}