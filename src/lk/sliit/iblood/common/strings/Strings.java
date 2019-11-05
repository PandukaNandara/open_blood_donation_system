package lk.sliit.iblood.common.strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:34 PM
 */
public enum Strings {

    MESSAGE_SUCCESSFULLY_ADDED_VALUE,
    MESSAGE_SUCCESSFULLY_DELETED_VALUE,
    MESSAGE_PROBLEM_OCCURRED_BY_EXCEPTION_WHEN_ADDING_VALUES,
    MESSAGE_PROBLEM_OCCURRED_BY_EXCEPTION_WHEN_UPDATING_VALUES,
    MESSAGE_PROBLEM_NO_SUCH_ELEMENT_WITH_ID,
    MESSAGE_ERROR_OCCURRED_BY_EXCEPTION_WHEN_FETCHING_VALUES,
    ASK_SHOULD_VALUES_BE_ADDED,
    ASK_SHOULD_VALUES_BE_UPDATED,
    ASK_SHOULD_VALUES_BE_DELETED,
    ASK_WHEN_QUIT_FROM_CONTENT,
    OPTION_PANE_TITLE,
    MESSAGE_PROBLEM_PLEASE_FILL_ID, MESSAGE_PROBLEM_CANNOT_FIND_RECORD, MESSAGE_ERROR_ID_IS_INVALID;

    private static Map<Strings, String> strMap = new HashMap<>(Strings.values().length);

    public static void loadStrings() throws IOException {
        File file = new File("resources/strings.properties");
        FileReader fileReader = new FileReader(file);

        Properties properties = new Properties();
        properties.load(fileReader);

        for (Strings key : Strings.values()) {
            strMap.put(key, properties.getProperty(key.toString()));
        }
    }

    public static String getString(Strings str) {
        return strMap.get(str);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
