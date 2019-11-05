package lk.sliit.iblood.common;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-11-03
 * Time: 2:02 PM
 */
public class OpenMailAppTest {
    @Test
    void openMailApp(String email, String subject, String body) {
        Desktop desktop = Desktop.getDesktop();
        String url;
        URI mailTo;
        try {
            url = "mailTo:test@gmail.com?";
            String uri = url + URLEncoder.encode("subject=" + "TEST SUBJECT"
                    + "&body=" + "TEST BODY", "UTF-8");
            mailTo = new URI(uri);
            desktop.mail(mailTo);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
