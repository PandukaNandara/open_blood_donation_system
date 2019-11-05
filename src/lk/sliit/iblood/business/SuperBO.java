package lk.sliit.iblood.business;

import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.db.DBConnection;

import java.sql.Connection;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 12:37 PM
 */
public interface SuperBO<EN, DT> {
    DT entityToModel(@Entity EN ent);
    EN modelToEntity(DT dto);

    static boolean doMiddleOFCommit(BoolFunction fun) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        conn.setAutoCommit(false);
        boolean result = false;
        try {
            return (result = fun.run());
        } finally {
            if(result)
                conn.commit();
            else
                conn.rollback();
            conn.setAutoCommit(true);
        }
    }
}
