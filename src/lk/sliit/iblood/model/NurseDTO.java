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
 * Time: 2:15 AM
 */
public class NurseDTO implements Modeler<NurseDTO> {

    private Integer nurseId;
    private String nurseIdStr;
    private String nurseFName;
    private String nurseLName;
    private String service;
    private Date nurseDOB;
    private String nurseAddress;

    public NurseDTO() {
    }

    public NurseDTO(String nurseFName, String nurseLName, String service, Date nurseDOB, String nurseAddress) {
        this.nurseFName = nurseFName;
        this.nurseLName = nurseLName;
        this.service = service;
        this.nurseDOB = nurseDOB;
        this.nurseAddress = nurseAddress;
    }

    public NurseDTO(String nurseIdStr, String nurseFName, String nurseLName, String service, Date nurseDOB, String nurseAddress) {
        this(nurseFName, nurseLName, service, nurseDOB, nurseAddress);
        this.nurseIdStr = nurseIdStr;
    }


    public NurseDTO(Integer nurseId, String nurseFName, String nurseLName, String service, Date nurseDOB, String nurseAddress) {
        this(nurseFName, nurseLName, service, nurseDOB, nurseAddress);
        this.nurseId = nurseId;
    }

    public NurseDTO(Integer nurseId, String nurseFName, String nurseLName) {
        setNurseId(nurseId);
        setNurseFName(nurseFName);
        setNurseLName(nurseLName);
    }

    @Override
    public String toString() {
        return "NurseDTO{" +
                "nurseId=" + nurseId +
                ", nurseIdStr='" + nurseIdStr + '\'' +
                ", nurseFName='" + nurseFName + '\'' +
                ", nurseLName='" + nurseLName + '\'' +
                ", service='" + service + '\'' +
                ", nurseDOB=" + nurseDOB +
                ", nurseAddress='" + nurseAddress + '\'' +
                '}';
    }

    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
    }

    public String getNurseFName() {
        return nurseFName;
    }

    public void setNurseFName(String nurseFName) {
        this.nurseFName = nurseFName;
    }

    public String getNurseLName() {
        return nurseLName;
    }

    public void setNurseLName(String nurseLName) {
        this.nurseLName = nurseLName;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Date getNurseDOB() {
        return nurseDOB;
    }

    public void setNurseDOB(Date nurseDOB) {
        this.nurseDOB = nurseDOB;
    }

    public String getNurseAddress() {
        return nurseAddress;
    }

    public void setNurseAddress(String nurseAddress) {
        this.nurseAddress = nurseAddress;
    }

    @Override
    public String[] toStringArray() {
        return new String[]{
                nurseId.toString(),
                nurseFName,
                nurseLName,
                nurseDOB.toString(),
                nurseAddress,
                service
        };
    }

    @Override
    public NurseDTO validateAndReturn() throws Exception {
        if (Validator.isNullOrEmpty(nurseFName))
            throw new ValidationException("Nurse's first name is not valid.");
        else if (Validator.isNullOrEmpty(nurseLName))
            throw new ValidationException("Nurse's last name is not valid.");
        else if (Validator.isNullOrEmpty(service))
            throw new ValidationException("Nurse's service should be specified.");
        else if (Objects.isNull(nurseDOB))
            throw new ValidationException("Nurse's date of birth is not valid.");
        else if (Validator.isNullOrEmpty(nurseAddress))
            throw new ValidationException("Nurse's address is not valid.");
        else return this;
    }

    @Override
    public NurseDTO validateWithPKeyAndReturn() throws Exception {
        if (!Validator.isInteger(nurseIdStr))
            throw new ValidationException("Nurse's ID is not valid.");
        else
            nurseId = Integer.valueOf(nurseIdStr);
        return validateAndReturn();
    }
}
