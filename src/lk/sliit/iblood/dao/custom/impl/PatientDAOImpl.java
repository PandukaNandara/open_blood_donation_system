package lk.sliit.iblood.dao.custom.impl;

import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.common.Gender;
import lk.sliit.iblood.dao.CrudUtil;
import lk.sliit.iblood.dao.custom.PatientDAO;
import lk.sliit.iblood.entity.Patient;

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
public class PatientDAOImpl implements PatientDAO {
    @Override
    public Boolean save(@Entity Patient ent) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO patient(pat_name,\n" +
                        "                    pat_dob,\n" +
                        "                    pat_gender,\n" +
                        "                    bld_grp_id,\n" +
                        "                    bld_id,\n" +
                        "                    requestDate)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?)",
                ent.getPatientName(),
                ent.getPatientDOB(),
                ent.getPatientGender().getType(),
                ent.getBloodGroupId(),
                ent.getBloodId(),
                ent.getRequestDate()) > 0;
    }

    @Override
    public Boolean update(@Entity Patient ent) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public Boolean delete(Integer e) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public Patient search(@Entity Integer id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * from patient where pat_id =?", id);
        List<Patient> list = new ArrayList<>();
        if(rst.next()) {
            return
                    new Patient(
                            rst.getInt(1),
                            rst.getString(2),
                            rst.getDate(3),
                            Gender.valueOf(rst.getInt(4)),
                            rst.getInt(5),
                            rst.getInt(6),
                            rst.getDate(7)
                    );

        }
        return null;
    }

    @Override
    public List<Patient> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * from patient");
        List<Patient> list = new ArrayList<>();
        while (rst.next()) {
            list.add(
                    new Patient(
                            rst.getInt(1),
                            rst.getString(2),
                            rst.getDate(3),
                            Gender.valueOf(rst.getInt(4)),
                            rst.getInt(5),
                            rst.getInt(6),
                            rst.getDate(7)
                    )
            );
        }
        return list;
    }
}
