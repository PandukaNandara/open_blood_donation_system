package lk.sliit.iblood.model;

import lk.sliit.iblood.business.Modeler;
import lk.sliit.iblood.common.ValidationException;
import lk.sliit.iblood.common.Validator;

import java.util.Date;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 2:20 AM
 */
public class DoctorDTO implements Modeler<DoctorDTO> {

    private
    Integer doctorId;

    private
    String doctorIdStr;

    private
    String doctorFName;

    private
    String doctorLName;

    private
    Date doctorDOB;

    private
    String doctorAddress;

    private
    String doctorEmail;

    public DoctorDTO() {
    }

    public DoctorDTO(Integer doctorId, String doctorFName, String doctorLName) {
        this.doctorId = doctorId;
        this.doctorFName = doctorFName;
        this.doctorLName = doctorLName;
    }

    public DoctorDTO(String doctorFName, String doctorLName, Date doctorDOB, String doctorAddress, String doctorEmail) {
        this.doctorFName = doctorFName;
        this.doctorLName = doctorLName;
        this.doctorDOB = doctorDOB;
        this.doctorAddress = doctorAddress;
        this.doctorEmail = doctorEmail;
    }

    public DoctorDTO(Integer doctorId, String doctorFName, String doctorLName, Date doctorDOB, String doctorAddress, String doctorEmail) {
        this(doctorFName, doctorLName, doctorDOB, doctorAddress, doctorEmail);
        this.doctorId = doctorId;

    }

    public DoctorDTO(String doctorIdStr, String doctorFName, String doctorLName, Date doctorDOB, String doctorAddress, String doctorEmail) {
        this(doctorFName, doctorLName, doctorDOB, doctorAddress, doctorEmail);
        this.doctorIdStr = doctorIdStr;
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

    @Override
    public String[] toStringArray() {
        return new String[]{
                doctorId.toString(),
                doctorFName,
                doctorLName,
                doctorDOB.toString(),
                doctorAddress,
                doctorEmail
        };
    }

    @Override
    public DoctorDTO validateAndReturn() throws Exception {
        if (Validator.isNullOrEmpty(doctorFName))
            throw new ValidationException("Doctor's first name is not valid.");
        else if (Validator.isNullOrEmpty(doctorLName))
            throw new ValidationException("Doctor's last name is not valid.");
        else if (Objects.isNull(doctorDOB))
            throw new ValidationException("Doctor's date of birth is not valid.");
        else if (Validator.isNullOrEmpty(doctorAddress))
            throw new ValidationException("Doctor's address is not valid.");
        else if (!Validator.isValidateEmail(doctorEmail))
            throw new ValidationException("Doctor's email is not valid.");
        else return this;
    }

    @Override
    public DoctorDTO validateWithPKeyAndReturn() throws Exception {
        if (!Validator.isInteger(doctorIdStr))
            throw new ValidationException("Doctor's ID is not valid.");
        else
            doctorId = Integer.valueOf(doctorIdStr);
        return validateAndReturn();
    }


    public String getDoctorIdStr() {
        return doctorIdStr;
    }

    public void setDoctorIdStr(String doctorIdStr) {
        this.doctorIdStr = doctorIdStr;
    }
}
