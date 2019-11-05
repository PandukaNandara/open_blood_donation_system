package lk.sliit.iblood.common;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-11-01
 * Time: 2:33 PM
 */
class ToolsTest {

    @Test
    void removeRowsFromJTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addRow(new Object[5]);
        model.addRow(new Object[5]);
        model.addRow(new Object[5]);
        model.addRow(new Object[5]);
        model.addRow(new Object[5]);
        Tools.removeRowsFromJTable(model);
        int expectedRowCount = 0;
        int actualRowCount = model.getRowCount();
        assertEquals(expectedRowCount, actualRowCount, "Expected row count is invalid");
    }

    @Test
    void clearTextOfJTextField() {
        JTextField[] textFields = {
                new JTextField("Hello"),
                new JTextField("Hello"),
                new JTextField("Hello")
        };
        Tools.clearTextOfJTextField(textFields);
        assertAll(
                () -> assertEquals(textFields[0].getText(), ""),
                () -> assertEquals(textFields[1].getText(), ""),
                () -> assertEquals(textFields[2].getText(), "")
        );
    }
}