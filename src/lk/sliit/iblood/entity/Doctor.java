package lk.sliit.iblood.entity;

import lk.sliit.iblood.common.Attribute;
import lk.sliit.iblood.common.Entity;

import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 2:20 AM
 */
@Entity
public class Doctor {
    @Attribute
    private
    Integer doctorId;
    @Attribute
    private
    String doctorFName;
    @Attribute
    private
    String doctorLName;
    @Attribute
    private
    Date doctorDOB;
    @Attribute
    private
    String doctorAddress;
    @Attribute
    private
    String doctorEmail;

    public Doctor() {
    }

    public Doctor(String doctorFName, String doctorLName, Date doctorDOB, String doctorAddress, String doctorEmail) {
        this.doctorFName = doctorFName;
        this.doctorLName = doctorLName;
        this.doctorDOB = doctorDOB;
        this.doctorAddress = doctorAddress;
        this.doctorEmail = doctorEmail;
    }

    public Doctor(Integer doctorId, String doctorFName, String doctorLName, Date doctorDOB, String doctorAddress, String doctorEmail) {
        this(doctorFName, doctorLName, doctorDOB, doctorAddress, doctorEmail);
        this.doctorId = doctorId;

    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorFName() {
        return doctorFName;
    }

    public void setDoctorFName(String doctorFName) {
        this.doctorFName = doctorFName;
    }

    public String getDoctorLName() {
        return doctorLName;
    }

    public void setDoctorLName(String doctorLName) {
        this.doctorLName = doctorLName;
    }

    public Date getDoctorDOB() {
        return doctorDOB;
    }

    public void setDoctorDOB(Date doctorDOB) {
        this.doctorDOB = doctorDOB;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }
}
