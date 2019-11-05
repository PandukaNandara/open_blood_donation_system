package lk.sliit.iblood.common;

import lk.sliit.iblood.common.strings.Strings;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:22 PM
 */
public class OptionPane {

    public static final int YES = 0;
    public static final int NO = 0;
    public static final int CANCEL = 0;
    public static final int CLOSE = -1;

    private static final Icon INFORMATION_ICON = UIManager.getIcon("OptionPane.informationIcon");
    private static final Icon ERROR_ICON = UIManager.getIcon("OptionPane.errorIcon");
    private static final Icon WARNING_ICON = UIManager.getIcon("OptionPane.warningIcon");
    private static final Icon QUESTION_ICON = UIManager.getIcon("OptionPane.questionIcon");
    private static Component parent;

    private OptionPane() {
    }

    public static void init(Component parent) {
        if (!Objects.isNull(OptionPane.parent))
            throw new RuntimeException("Parent component has already been initialized.");
        else
            OptionPane.parent = parent;
    }

    public static void showDoneMessage(Strings msg) {
        if (Objects.isNull(parent))
            throw new NullPointerException("Parent component is not initialized yet.");
        else
            JOptionPane.showMessageDialog(parent,
                    Strings.getString(msg),
                    Strings.getString(Strings.OPTION_PANE_TITLE),
                    JOptionPane.PLAIN_MESSAGE, INFORMATION_ICON);
    }


    public static void showNotDone(String msg) {
        if (Objects.isNull(parent))
            throw new NullPointerException("Parent component is not initialized yet.");
        else
            JOptionPane.showMessageDialog(parent, msg, Strings.getString(Strings.OPTION_PANE_TITLE),
                    JOptionPane.WARNING_MESSAGE, WARNING_ICON);
    }

    public static void showNotDone(Strings msg) {
        showNotDone(Strings.getString(msg));
    }

    public static void showError(Strings msg) {
        if (Objects.isNull(parent))
            throw new NullPointerException("Parent component is not initialized yet.");
        else
            JOptionPane.showMessageDialog(
                    parent, Strings.getString(msg),
                    Strings.getString(Strings.OPTION_PANE_TITLE),
                    JOptionPane.ERROR_MESSAGE, ERROR_ICON);
    }

    public static Integer confirmAsInfo(Strings msg) {
        if (Objects.isNull(parent))
            throw new NullPointerException("Parent component is not initialized yet.");
        else
            return JOptionPane.showConfirmDialog(
                    parent,
                    Strings.getString(msg),
                    Strings.getString(Strings.OPTION_PANE_TITLE),
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, QUESTION_ICON);
    }

    public static Integer confirmAsWarning(Strings msg) {
        if (Objects.isNull(parent))
            throw new NullPointerException("Parent component is not initialized yet.");
        else
            return JOptionPane.showConfirmDialog(
                    parent,
                    Strings.getString(msg),
                    Strings.getString(Strings.OPTION_PANE_TITLE),
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE, WARNING_ICON);
    }
}
