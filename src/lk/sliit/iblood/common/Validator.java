package lk.sliit.iblood.common;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 10:22 PM
 */
public class Validator {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isNullOrEmpty(String str) {
        return Objects.isNull(str) || (str.length() == 0);
    }

    public static boolean isValidateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean isInteger(String text) {
        try {
            return !text.equals("") && (text.matches("[0-9]*"));
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDouble(String text) {
        try {
            return !text.equals("") && (text.matches("[0-9]{1,13}(\\.[0-9]*)?"));
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidHemoglobin(String text) {
        if (!Validator.isNullOrEmpty(text)) {
            return Validator.isDouble(text);
        } else return true;
    }

    public static boolean validateNIC(String nic){
        return nic.matches("[0-9]{9}[VX]");
    }

    public static boolean validateMobile(String mobile) {
        return mobile.matches("[0][0-9]{9}");
    }
}
