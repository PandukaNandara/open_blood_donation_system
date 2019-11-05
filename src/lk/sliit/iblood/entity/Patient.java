package lk.sliit.iblood.entity;

import lk.sliit.iblood.common.Attribute;
import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.common.Gender;

import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 2:02 AM
 */
@Entity
public class Patient {
    @Attribute
    private Integer patientId;
    @Attribute
    private String patientName;
    @Attribute
    private Date patientDOB;
    @Attribute
    private Gender patientGender;
    @Attribute
    private Integer bloodGroupId;
    @Attribute
    private Integer bloodId;
    @Attribute
    private Date requestDate;

    public Patient() {
    }

    public Patient(String patientName, Date patientDOB, Gender patientGender,
                   Integer bloodGroupId, Integer bloodId, Date requestDate) {
        this.patientName = patientName;
        this.patientDOB = patientDOB;
        this.patientGender = patientGender;
        this.bloodGroupId = bloodGroupId;
        this.bloodId = bloodId;

        this.requestDate = requestDate;
    }


    public Patient(Integer patientId, String patientName, Date patientDOB, Gender patientGender,
                   Integer bloodGroupId, Integer bloodId, Date requestDate) {
        this(patientName, patientDOB, patientGender,
                bloodGroupId, bloodId, requestDate);
        this.patientId = patientId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(Date patientDOB) {
        this.patientDOB = patientDOB;
    }

    public Gender getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(Gender patientGender) {
        this.patientGender = patientGender;
    }

    public Integer getBloodGroupId() {
        return bloodGroupId;
    }

    public void setBloodGroupId(Integer bloodGroupId) {
        this.bloodGroupId = bloodGroupId;
    }

    public Integer getBloodId() {
        return bloodId;
    }

    public void setBloodId(Integer bloodId) {
        this.bloodId = bloodId;
    }
}
