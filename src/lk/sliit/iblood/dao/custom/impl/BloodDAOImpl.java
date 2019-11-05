package lk.sliit.iblood.dao.custom.impl;

import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.dao.CrudUtil;
import lk.sliit.iblood.dao.custom.BloodDAO;
import lk.sliit.iblood.entity.Blood;
import lk.sliit.iblood.entity.BloodGroup;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:34 AM
 */
public class BloodDAOImpl implements BloodDAO {
    @Override
    public Boolean save(@Entity Blood ent) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO blood(hemoglobin, defection, don_id) VALUES (?,?,?)",
                ent.getHemoglobin(),
                ent.getDefection(),
                ent.getDonorId()) > 0;
    }

    @Override
    public Boolean update(@Entity Blood ent) throws Exception {
        return null;
    }

    @Override
    public Boolean delete(Integer e) throws Exception {
        return null;
    }

    @Override
    public Blood search(@Entity Integer id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM blood WHERE bld_id = ?", id);
        if (rst.next()) {
                    return new Blood(
                            rst.getInt(1),
                            rst.getBigDecimal(2),
                            rst.getString(3),
                            rst.getInt(4),
                            rst.getInt(5)
                    );
        }
        else return null;
    }


    @Override
    public List<Blood> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM blood");
        List<Blood> list = new ArrayList<>();
        while (rst.next()) {
            list.add(
                    new Blood(
                            rst.getInt(1),
                            rst.getBigDecimal(2),
                            rst.getString(3),
                            rst.getInt(4),
                            rst.getInt(5)
                    )
            );
        }
        return list;
    }

    @Override
    public Integer getLastIncrementedValue() throws Exception {
        ResultSet rst = CrudUtil.executeQuery(
                "SELECT `AUTO_INCREMENT`\n" +
                "FROM  INFORMATION_SCHEMA.TABLES\n" +
                "WHERE TABLE_SCHEMA = DATABASE()\n" +
                "AND   TABLE_NAME   = 'blood'");
        if (rst.next())
            return rst.getInt(1) - 1;
        else return 0;
    }
}
