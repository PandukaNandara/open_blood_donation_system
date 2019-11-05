package lk.sliit.iblood.dao.custom.impl;

import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.common.Gender;
import lk.sliit.iblood.dao.CrudUtil;
import lk.sliit.iblood.dao.custom.DonorDAO;
import lk.sliit.iblood.entity.Donor;
import lk.sliit.iblood.model.DonorDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:30 AM
 */
public class DonorDAOImpl implements DonorDAO {
    @Override
    public Boolean save(@Entity Donor ent) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO donor(" +
                        "don_fname," +
                        " don_lname," +
                        " don_nic," +
                        " don_dob," +
                        " don_gender," +
                        " registration_date," +
                        " registration_time," +
                        " don_address," +
                        " don_mobile," +
                        " don_email," +
                        " bld_grp_id) values(?,?,?,?,?,?,?,?,?,?,?)",
                ent.getDonorFName(),
                ent.getDonorLName(),
                ent.getDonorNIC(),
                ent.getDonorDOB(),
                ent.getDonorGender().getType(),
                ent.getRegistrationDate(),
                ent.getRegistrationTime(),
                ent.getDonorAddress(),
                ent.getDonorMobile(),
                ent.getDonorEmail(),
                ent.getBloodGroupId()) > 0;
    }

    @Override
    public Boolean update(@Entity Donor ent) throws Exception {
        return CrudUtil.executeUpdate(
                "UPDATE donor SET" +
                        " don_fname = ?," +
                        " don_lname = ?," +
                        " don_nic = ?," +
                        " don_dob = ?," +
                        " don_gender = ?," +
                        " don_address = ?," +
                        " don_email = ?," +
                        " bld_grp_id = ?" +
                        " WHERE don_id = ?",
                ent.getDonorFName(),
                ent.getDonorLName(),
                ent.getDonorNIC(),
                ent.getDonorDOB(),
                ent.getDonorGender().getType(),
                ent.getDonorAddress(),
                ent.getDonorEmail(),
                ent.getBloodGroupId(),
                ent.getDonorId()) > 0;
    }

    @Override
    public Boolean delete(Integer e) throws Exception {
        return CrudUtil.executeUpdate(
                "DELETE FROM donor WHERE don_id = ?",
                e) > 0;
    }

    @Override
    public Donor search(@Entity Integer id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM donor WHERE don_id = ?", id);
        if (rst.next())
            return new Donor(
                    rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDate(5),
                    Gender.valueOf(rst.getBoolean(6)),
                    rst.getDate(7),
                    rst.getTime(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getInt(12)
            );
        else return null;
    }

    @Override
    public List<Donor> getAll() throws Exception {
        List<Donor> donors = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM donor");
        while (rst.next())
            donors.add(new Donor(
                            rst.getInt(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getDate(5),
                            Gender.valueOf(rst.getBoolean(6)),
                            rst.getDate(7),
                            rst.getTime(8),
                            rst.getString(9),
                            rst.getString(10),
                            rst.getString(11),
                            rst.getInt(12)
                    )
            );
        return donors;
    }



    @Override
    public Donor getDonorForThisBloodDonation(Integer value) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT d.* FROM donor d, blood b WHERE d.don_id = b.don_id AND bld_id = ?", value);
        if (rst.next())
            return new Donor(
                    rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDate(5),
                    Gender.valueOf(rst.getBoolean(6)),
                    rst.getDate(7),
                    rst.getTime(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getInt(12)
            );
        else return null;
    }
}
