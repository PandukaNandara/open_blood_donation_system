package lk.sliit.iblood.dao.custom.impl;

import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.dao.CrudUtil;
import lk.sliit.iblood.dao.custom.NurseDAO;
import lk.sliit.iblood.entity.Nurse;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:25 AM
 */
public class NurseDAOImpl implements NurseDAO {
    @Override
    public Boolean save(@Entity Nurse ent) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO nurse(nur_fname, nur_lname, service, nur_dob, nur_address) VALUES (?,?,?,?,?)",
                ent.getNurseFName(),
                ent.getNurseLName(),
                ent.getService(),
                ent.getNurseDOB(),
                ent.getNurseAddress()
                ) > 0;
    }

    @Override
    public Boolean update(@Entity Nurse ent) throws Exception {
        return CrudUtil.executeUpdate(
                "UPDATE nurse SET nur_fname = ?, nur_lname = ?, service = ?, nur_dob = ?, nur_address = ? WHERE nur_id = ?",
                ent.getNurseFName(),
                ent.getNurseLName(),
                ent.getService(),
                ent.getNurseDOB(),
                ent.getNurseAddress(),
                ent.getNurseId()) > 0;
    }

    @Override
    public Boolean delete(Integer e) throws Exception {
        return CrudUtil.executeUpdate(
                "DELETE FROM nurse WHERE nur_id = ?",
                e) > 0;
    }

    @Override
    public Nurse search(@Entity Integer id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM nurse WHERE nur_id = ?", id);
        if (rst.next())
            return new Nurse(
                    rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDate(5),
                    rst.getString(6)
            );
        else return null;
    }

    @Override
    public List<Nurse> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM nurse");
        List<Nurse> list = new ArrayList<>();
        while (rst.next()) {
            list.add(
                    new Nurse(
                            rst.getInt(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getDate(5),
                            rst.getString(6)
                    )
            );
        }
        return list;
    }
}
