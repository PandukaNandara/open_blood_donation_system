package lk.sliit.iblood.entity;

import lk.sliit.iblood.common.Attribute;
import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.common.Gender;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 1:39 AM
 */
@Entity
public class Donor {
    @Attribute
    private Integer donorId;
    @Attribute
    private String donorFName;
    @Attribute
    private String donorLName;
    @Attribute
    private String donorNIC;
    @Attribute
    private Date donorDOB;
    @Attribute
    private Gender donorGender;
    @Attribute
    private Date registrationDate;
    @Attribute
    private Time registrationTime;
    @Attribute
    private String donorAddress;
    @Attribute
    private String donorEmail;

    @Attribute
    private String donorMobile;

    @Attribute
    private Integer bloodGroupId;

    private Integer bloodId;

    public Donor() {
    }

    public Donor(String donorFName, String donorLName, String donorNIC, Date donorDOB, Gender donorGender,
                 Date registrationDate, Time registrationTime, String donorAddress, String donorEmail,
                 String donorMobile, Integer bloodGroupId) {
        this.donorFName = donorFName;
        this.donorLName = donorLName;
        this.donorNIC = donorNIC;
        this.donorDOB = donorDOB;
        this.donorGender = donorGender;
        this.registrationDate = registrationDate;
        this.registrationTime = registrationTime;
        this.donorAddress = donorAddress;
        this.donorEmail = donorEmail;
        this.bloodGroupId = bloodGroupId;
        this.donorMobile = donorMobile;
    }

    public Donor(Integer donorId, String donorFName, String donorLName, String donorNIC, Date donorDOB,
                 Gender donorGender, Date registrationDate, Time registrationTime, String donorAddress,
                 String donorEmail, String donorMobile, Integer bloodGroupId) {
        this(donorFName, donorLName, donorNIC, donorDOB, donorGender, registrationDate, registrationTime,
                donorAddress, donorEmail, donorMobile, bloodGroupId);
        this.donorId = donorId;
    }


    public Donor(Integer donorId, String donorFName, String donorLName, String donorNIC, Date donorDOB,
                 Gender donorGender, String donorAddress,
                 String donorEmail, String donorMobile, Integer bloodGroupId) {
        this(donorFName, donorLName, donorNIC, donorDOB, donorGender, null, null,
                donorAddress, donorEmail, donorMobile, bloodGroupId);
        this.donorId = donorId;
    }

    public Integer getDonorId() {
        return donorId;
    }

    public void setDonorId(Integer donorId) {
        this.donorId = donorId;
    }

    public String getDonorFName() {
        return donorFName;
    }

    public void setDonorFName(String donorFName) {
        this.donorFName = donorFName;
    }

    public String getDonorLName() {
        return donorLName;
    }

    public void setDonorLName(String donorLName) {
        this.donorLName = donorLName;
    }

    public String getDonorNIC() {
        return donorNIC;
    }

    public void setDonorNIC(String donorNIC) {
        this.donorNIC = donorNIC;
    }

    public Date getDonorDOB() {
        return donorDOB;
    }

    public void setDonorDOB(Date donorDOB) {
        this.donorDOB = donorDOB;
    }

    public Gender getDonorGender() {
        return donorGender;
    }

    public void setDonorGender(Gender donorGender) {
        this.donorGender = donorGender;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Time getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Time registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getDonorAddress() {
        return donorAddress;
    }

    public void setDonorAddress(String donorAddress) {
        this.donorAddress = donorAddress;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    public Integer getBloodGroupId() {
        return bloodGroupId;
    }

    public void setBloodGroupId(Integer bloodGroupId) {
        this.bloodGroupId = bloodGroupId;
    }

    public String getDonorMobile() {
        return donorMobile;
    }

    public void setDonorMobile(String donorMobile) {
        this.donorMobile = donorMobile;
    }

    public Integer getBloodId() {
        return bloodId;
    }

    public void setBloodId(Integer bloodId) {
        this.bloodId = bloodId;
    }
}
