package lk.sliit.iblood.dao.custom.impl;

import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.dao.CrudUtil;
import lk.sliit.iblood.dao.custom.DoctorDAO;
import lk.sliit.iblood.entity.Doctor;

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
public class DoctorDAOImpl implements DoctorDAO {
    @Override
    public Boolean save(@Entity Doctor ent) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO doctor(doc_fname, doc_lname, doc_dob, doc_address, doc_email) VALUES (?,?,?,?,?)",
                ent.getDoctorFName(),
                ent.getDoctorLName(),
                ent.getDoctorDOB(),
                ent.getDoctorAddress(),
                ent.getDoctorEmail()) > 0;
    }

    @Override
    public Boolean update(@Entity Doctor ent) throws Exception {
        return CrudUtil.executeUpdate(
                "UPDATE doctor set doc_fname = ?, doc_lname = ?, doc_dob = ?, doc_address = ?, doc_email = ? WHERE doc_id = ?",
                ent.getDoctorFName(),
                ent.getDoctorLName(),
                ent.getDoctorDOB(),
                ent.getDoctorAddress(),
                ent.getDoctorEmail(),
                ent.getDoctorId()) > 0;
    }

    @Override
    public Boolean delete(Integer e) throws Exception {
        return CrudUtil.executeUpdate(
                "DELETE FROM doctor WHERE doc_id = ?",
                e) > 0;
    }

    @Override
    public Doctor search(@Entity Integer id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM doctor WHERE doc_id = ?", id);
        if (rst.next())
            return new Doctor(
                    rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDate(4),
                    rst.getString(5),
                    rst.getString(6)
            );
        else return null;
    }

    @Override
    public List<Doctor> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM doctor");
        List<Doctor> list = new ArrayList<>();
        while (rst.next()) list.add(
                new Doctor(
                        rst.getInt(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getDate(4),
                        rst.getString(5),
                        rst.getString(6)
                )
        );
        return list;
    }
}
