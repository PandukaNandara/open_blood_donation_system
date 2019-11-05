package lk.sliit.iblood.model;

import lk.sliit.iblood.business.Modeler;
import lk.sliit.iblood.common.Gender;
import lk.sliit.iblood.common.Tools;
import lk.sliit.iblood.common.ValidationException;
import lk.sliit.iblood.common.Validator;

import java.util.Date;
import java.sql.Time;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 1:39 AM
 */
public class DonorDTO implements Modeler<DonorDTO> {

    private
    Integer donorId;

    private
    String donorIdStr;

    private
    String donorFName;

    private
    String donorLName;

    private
    String donorNIC;

    private
    Date donorDOB;

    private
    Gender donorGender;

    private
    Date registrationDate;

    private
    Time registrationTime;

    private
    String donorAddress;

    private
    String donorEmail;

    private
    String donorMobile;

    private
    Integer bloodGroupId;

    private
    Integer bloodId;

    private BloodGroupDTO bloodGroupDTO;

    public DonorDTO() {
    }

    @Override
    public String toString() {
        return "DonorDTO{" +
                "donorId=" + donorId +
                ", donorIdStr='" + donorIdStr + '\'' +
                ", donorFName='" + donorFName + '\'' +
                ", donorLName='" + donorLName + '\'' +
                ", donorNIC='" + donorNIC + '\'' +
                ", donorDOB=" + donorDOB +
                ", donorGender=" + donorGender +
                ", registrationDate=" + registrationDate +
                ", registrationTime=" + registrationTime +
                ", donorAddress='" + donorAddress + '\'' +
                ", donorEmail='" + donorEmail + '\'' +
                ", donorMobile='" + donorMobile + '\'' +
                ", bloodGroupId=" + bloodGroupId +
                ", bloodGroupDTO=" + bloodGroupDTO +
                '}';
    }

    public DonorDTO(String donorFName, String donorLName, String donorNIC, Date donorDOB, Gender donorGender,
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
        this.donorMobile = donorMobile;
        this.bloodGroupId = bloodGroupId;
    }
    public DonorDTO(String donorFName, String donorLName, String donorNIC, Date donorDOB, Gender donorGender,
                     String donorAddress, String donorEmail,
                    String donorMobile, Integer bloodGroupId) {
        this.donorFName = donorFName;
        this.donorLName = donorLName;
        this.donorNIC = donorNIC;
        this.donorDOB = donorDOB;
        this.donorGender = donorGender;
        this.donorAddress = donorAddress;
        this.donorEmail = donorEmail;
        this.donorMobile = donorMobile;
        this.bloodGroupId = bloodGroupId;
    }

    public DonorDTO(String donorIdStr, String donorFName, String donorLName, String donorNIC, Date donorDOB, Gender donorGender,
                    String donorAddress, String donorEmail,
                    String donorMobile, BloodGroupDTO bloodGroupDTO) {
        this.donorIdStr = donorIdStr;
        this.donorFName = donorFName;
        this.donorLName = donorLName;
        this.donorNIC = donorNIC;
        this.donorDOB = donorDOB;
        this.donorGender = donorGender;
        this.donorAddress = donorAddress;
        this.donorEmail = donorEmail;
        this.donorMobile = donorMobile;
        setBloodGroupDTO(bloodGroupDTO);

    }

    public DonorDTO(String donorFName, String donorLName, String donorNIC, Date donorDOB, Gender donorGender,
                    String donorAddress, String donorEmail,
                    String donorMobile, BloodGroupDTO bloodGroupDTO) {
        this.donorFName = donorFName;
        this.donorLName = donorLName;
        this.donorNIC = donorNIC;
        this.donorDOB = donorDOB;
        this.donorGender = donorGender;
        this.donorAddress = donorAddress;
        this.donorEmail = donorEmail;
        this.donorMobile = donorMobile;
        setBloodGroupDTO(bloodGroupDTO);
    }

    public DonorDTO(Integer donorId, String donorFName, String donorLName, String donorNIC, Date donorDOB,
                    Gender donorGender, Date registrationDate, Time registrationTime, String donorAddress,
                    String donorEmail, String donorMobile, Integer bloodGroupId) {
        this(donorFName, donorLName, donorNIC, donorDOB, donorGender, registrationDate, registrationTime,
                donorAddress, donorEmail, donorMobile, bloodGroupId);
        this.donorId = donorId;
    }

    public DonorDTO(Integer donorId, String donorFName, String donorLName, String donorNIC, Date donorDOB,
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

    @Override
    public String[] toStringArray() {
        return new String[]{
                donorId.toString(),
                donorFName,
                donorLName,
                donorNIC,
                donorDOB.toString(),
                donorGender.toString(),
                donorMobile,
                donorEmail,
                donorAddress,
                bloodGroupDTO.toString(),
                registrationDate.toString(),
                registrationTime.toString()
        };
    }

    public String[] toStringArrayWithAge() {
        return new String[]{
                donorId.toString(),
                donorFName,
                donorLName,
                donorDOB.toString(),
                Integer.toString(Tools.getAge(donorDOB)),
                donorGender.toString(),
                donorMobile,
                donorEmail,
                bloodGroupDTO.toString(),
                registrationDate.toString()
        };
    }

    public String[] toStringArrayWith_ID_Name_DOB_Address() {
        return new String[]{
                donorId.toString(),
                Tools.joinFNameAndLName(donorFName,donorLName),
                donorDOB.toString(),
                donorAddress
        };
    }

    public String[] toStringArrayWithIDAndFullName() {
        return new String[]{
                donorId.toString(),
                donorFName + donorLName
        };
    }
    @Override
    public DonorDTO validateAndReturn() throws Exception {
        if (Validator.isNullOrEmpty(donorFName))
            throw new ValidationException("Donor's first name is not valid.");
        else if (Validator.isNullOrEmpty(donorLName))
            throw new ValidationException("Donor's last name is not valid.");
        else if (!Validator.validateNIC(donorNIC))
            throw new ValidationException("Donor's NIC number is not valid.");
        else if (!Validator.isValidateEmail(donorEmail))
            throw new ValidationException("Donor's email is not valid.");
        else if (Objects.isNull(donorDOB))
            throw new ValidationException("Donor's date of birth is not valid.");
        else if (Objects.isNull(donorGender))
            throw new ValidationException("Donor's gender is not valid.");
        else if (!Validator.validateMobile(donorMobile))
            throw new ValidationException("Donor's mobile is not valid.");
        else if (Validator.isNullOrEmpty(donorAddress))
            throw new ValidationException("Donor's address is not valid.");
        else if (Objects.isNull(bloodGroupDTO))
            throw new ValidationException("Donor's blood group is not valid.");
        else return this;
    }

    @Override
    public DonorDTO validateWithPKeyAndReturn() throws Exception {
        if (!Validator.isInteger(donorIdStr))
            throw new ValidationException("Donor's Id is not valid.");
        else {
            donorId = Integer.valueOf(donorIdStr);
            return validateAndReturn();
        }
    }

    public BloodGroupDTO getBloodGroupDTO() {
        return bloodGroupDTO;
    }

    public void setBloodGroupDTO(BloodGroupDTO bloodGroupDTO) {
        this.bloodGroupDTO = bloodGroupDTO;
        this.bloodGroupId = bloodGroupDTO.getBloodGroupId();
    }

    public Integer getBloodId() {
        return bloodId;
    }

    public void setBloodId(Integer bloodId) {
        this.bloodId = bloodId;
    }
}
