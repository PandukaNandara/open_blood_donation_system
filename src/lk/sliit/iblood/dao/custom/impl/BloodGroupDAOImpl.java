package lk.sliit.iblood.dao.custom.impl;

import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.dao.CrudUtil;
import lk.sliit.iblood.dao.custom.BloodGroupDAO;
import lk.sliit.iblood.entity.BloodGroup;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 2:42 AM
 */
public class BloodGroupDAOImpl implements BloodGroupDAO {

    @Override
    public Boolean save(BloodGroup ent) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO blood_group(bld_grp_name) VALUES(?)",
                ent.getBloodGroupName()
        ) > 0;
    }

    @Override
    public Boolean update(BloodGroup i) throws Exception {
        return CrudUtil.executeUpdate("UPDATE blood_group set bld_grp_name = ? WHERE bld_grp_id = ?",
                i.getBloodGroupName(),
                i.getBloodGroupId()
        ) > 0;
    }

    @Override
    public Boolean delete(Integer e) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM blood_group WHERE bld_grp_id = ?",
                e
        ) > 0;
    }

    @Override
    public BloodGroup search(@Entity Integer id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM blood_group WHERE bld_grp_id = ?", id);
        if (rst.next()) {
            return
                    new BloodGroup(
                            rst.getInt(1),
                            rst.getString(2)
                    );
        }
        return null;
    }

    @Override
    public List<BloodGroup> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM blood_group");
        List<BloodGroup> list = new ArrayList<>();
        while (rst.next()) {
            list.add(
                    new BloodGroup(
                            rst.getInt(1),
                            rst.getString(2)
                    )
            );
        }
        return list;
    }
}
