package lk.sliit.iblood.view_controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-11-02
 * Time: 1:11 AM
 */
public interface SuperController {
    default void callLogger(Throwable t){
        Logger.getLogger(SuperController.class.getName()).log(Level.SEVERE, null, t);
    }
}
