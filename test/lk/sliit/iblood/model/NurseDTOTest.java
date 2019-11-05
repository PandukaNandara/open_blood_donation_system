package lk.sliit.iblood.model;

import lk.sliit.iblood.common.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-11-01
 * Time: 3:23 PM
 */
class NurseDTOTest {

    @Test
    void validateAndReturn() {
        NurseDTO nurseDTO = new NurseDTO();
        nurseDTO.setService("Cutting");
        boolean nullOrEmpty = !Validator.isNullOrEmpty(nurseDTO.getService());
        assertEquals(Boolean.FALSE, nullOrEmpty);
    }
}