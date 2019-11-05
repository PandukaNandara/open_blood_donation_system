package lk.sliit.iblood.common;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:08 PM
 */
public class Tools {
    public static java.sql.Date sqlDateToUtilDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static void clearTextOfJTextField(JTextComponent... textFields) {
        for (JTextComponent textField : textFields) {
            textField.setText(null);
        }
    }

    public static void removeRowsFromJTable(DefaultTableModel model) {
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    public static Integer getAge(Date dob) {
        return LocalDate.now().getYear() - dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
    }


    public static String joinFNameAndLName(String donorFName, String donorLName) {
        return donorFName + " " + donorLName;
    }

    public static void openMailApp(String email, String subject, String body) {
        Desktop desktop = Desktop.getDesktop();
        String url;
        URI mailTo;
        try {
            url = "mailTo:" + email + "?";
            String uri = url + URLEncoder.encode(
                    "subject=" + subject + "&body=" + body,
                    "UTF-8"
            );
            mailTo = new URI(uri);
            desktop.mail(mailTo);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}

