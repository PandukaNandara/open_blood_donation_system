package lk.sliit.iblood.dao.custom.impl;

import lk.sliit.iblood.common.Gender;
import lk.sliit.iblood.dao.CrudUtil;
import lk.sliit.iblood.dao.custom.QueryDAO;
import lk.sliit.iblood.entity.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-11-02
 * Time: 5:28 PM
 */
public class QueryDAOImpl implements QueryDAO {
    @Override
    public Donor getDonorOfThisPatient(Integer idInt) throws Exception {
        ResultSet rst = CrudUtil.executeQuery(
                "SELECT d.*\n" +
                        "FROM blood b,\n" +
                        "     donor d,\n" +
                        "     patient p\n" +
                        "WHERE (d.don_id = b.don_id AND\n" +
                        "       (b.bld_id = p.bld_id))\n" +
                        "  AND p.pat_id = ?");
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
    public List<Donor> getDonorsWhoHaveThisBloodGroupDoNotHavePatient(Integer bloodGroupId) throws Exception {
        List<Donor> donors = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery(
                "SELECT d.*, b.bld_id\n" +
                        "FROM blood b,\n" +
                        "     donor d\n" +
                        "WHERE b.don_id = d.don_id AND (b.bld_id NOT IN (SELECT DISTINCT p.bld_id from patient p)) AND\n" +
                        "        d.bld_grp_id = ?", bloodGroupId);
        while (rst.next()) {
            Donor donor = new Donor(
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
            donor.setBloodId(rst.getInt(13));
            donors.add(donor);
        }

        return donors;
    }

    @Override
    public List<CustomEntity> getAllBloodDonationWithDonorsAndPatients() throws Exception {
        List<CustomEntity> customEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery(
                "SELECT b.*, p.pat_id, p.pat_name, d.don_fname, d.don_lname\n" +
                        "FROM blood b,\n" +
                        "     donor d,\n" +
                        "     patient p\n" +
                        "WHERE (d.don_id = b.don_id AND\n" +
                        "       p.bld_id = b.bld_id)");
        while (rst.next()) {
            CustomEntity custom = new CustomEntity();
            custom.setBlood(
                    new Blood(
                            rst.getInt(1),
                            rst.getBigDecimal(2),
                            rst.getString(3),
                            rst.getInt(4),
                            rst.getInt(5))
            );

            Patient patient = new Patient();
            patient.setPatientId(rst.getInt(5));
            patient.setPatientName(rst.getString(6));
            Donor donor = new Donor();
            donor.setDonorId(rst.getInt(4));
            donor.setDonorFName(rst.getString(7));
            donor.setDonorLName(rst.getString(8));

            custom.setDonor(donor);
            custom.setPatient(patient);
            customEntities.add(custom);
        }
        return customEntities;
    }

    @Override
    public List<CustomEntity> getDoctorsContributionWithName(String donationId) throws Exception {
        List<CustomEntity> customEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery(
                "SELECT dC.*, doc_fname, doc_lname\n" +
                        "FROM doctor_contribution dc,\n" +
                        "     doctor d\n" +
                        "WHERE d.doc_id = dc.doc_id\n" +
                        "AND bld_id = ?;", donationId);
        while (rst.next()) {
            CustomEntity customEnt = new CustomEntity();
            customEnt.setDoctorContribution(
                    new DoctorContribution(rst.getInt(1),
                            rst.getInt(2),
                            rst.getInt(3))
            );
            customEnt.setDoctorFName(rst.getString(4));
            customEnt.setDoctorLName(rst.getString(5));
            customEntities.add(customEnt);
        }
        return customEntities;
    }

    @Override
    public List<CustomEntity> getNursesContributionWithName(String donationId) throws Exception {
        List<CustomEntity> customEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery(
                "SELECT nc.*, nur_fname, nur_lname\n" +
                        "FROM nurse_contribution nc,\n" +
                        "     nurse n\n" +
                        "WHERE n.nur_id = nc.nur_id\n" +
                        "AND bld_id = ?;", donationId);
        while (rst.next()) {
            CustomEntity customEnt = new CustomEntity();
            customEnt.setNurseContribution(
                    new NurseContribution(rst.getInt(1),
                            rst.getInt(2),
                            rst.getInt(3))
            );
            customEnt.setNurseFName(rst.getString(4));
            customEnt.setNurseLName(rst.getString(5));
            customEntities.add(customEnt);
        }
        return customEntities;
    }
//    @Override
//    public CustomEntity getAllBloodReportWithPatient() throws Exception {
//        ArrayList<CustomEntity> allStudent = new ArrayList<>();
//        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM ");
//        while (rst.next()) {
//            System.out.println(rst.getInt("SID") + "  " +
//                    rst.getString("sName"));
//            allStudent.add(new CustomEntity(new Student(
//                            rst.getInt("SID"),
//                            rst.getString("sName")
//                    )
//                    )
//            );
//        }
//        return allStudent;
//    }
}
