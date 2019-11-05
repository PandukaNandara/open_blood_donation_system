package lk.sliit.iblood.model;

import lk.sliit.iblood.business.Modeler;
import lk.sliit.iblood.common.Gender;

import java.util.Date;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 2:02 AM
 */
public class PatientDTO implements Modeler<PatientDTO> {

    private Integer patientId;

    private String patientName;


    private Date patientDOB;

    private Gender patientGender;

    private Integer bloodGroupId;

    private Integer bloodId;

    private Date requestDate;

    private BloodGroupDTO bloodGroupDTO;

    private BloodDTO bloodDTO;

    private DonorDTO donorDTO;

    public PatientDTO() {
    }

    public PatientDTO(String patientName, Date patientDOB, Gender patientGender,
                      Integer bloodGroupId, Integer bloodId, Date requestDate) {
        this.patientName = patientName;
        this.patientDOB = patientDOB;
        this.patientGender = patientGender;
        this.bloodGroupId = bloodGroupId;

        this.bloodId = bloodId;
        this.requestDate = requestDate;
    }

    public PatientDTO(Integer patientId, String patientName, Date patientDOB,
                      Gender patientGender, Integer bloodGroupId, Integer bloodId, Date requestDate) {
        this(patientName, patientDOB, patientGender, bloodGroupId, bloodId ,requestDate);
        this.patientId = patientId;
    }

    public PatientDTO(String patientName, Date patientDOB,
                      Gender patientGender, BloodGroupDTO bloodGroupDTO, BloodDTO bloodDTO) {
        this.patientName = patientName;
        this.patientDOB = patientDOB;
        this.patientGender = patientGender;
        setBloodGroupDTO(bloodGroupDTO);
        setBloodDTO(bloodDTO);
    }

    public PatientDTO(String patientName, Date patientDOB,
                      Gender patientGender, BloodGroupDTO bloodGroupDTO, BloodDTO bloodDTO,
                      Date requestDate) {
        this.patientName = patientName;
        this.patientDOB = patientDOB;
        this.patientGender = patientGender;
        setBloodGroupDTO(bloodGroupDTO);
        setBloodDTO(bloodDTO);
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

    @Override
    public String[] toStringArray() {
        return new String[]{
                patientId.toString(),
                patientName,
                patientDOB.toString(),
                patientGender.toString(),
                bloodGroupDTO.toString(),
                bloodId.toString()
        };
    }

    @Override
    public PatientDTO validateAndReturn() throws Exception {
        return this;
    }

    @Override
    public PatientDTO validateWithPKeyAndReturn() throws Exception {
        return null;
    }

    public BloodGroupDTO getBloodGroupDTO() {
        return bloodGroupDTO;
    }

    public void setBloodGroupDTO(BloodGroupDTO bloodGroupDTO) {
        this.bloodGroupDTO = bloodGroupDTO;
    }

    public Integer getBloodId() {
        return bloodId;
    }

    public void setBloodId(Integer bloodId) {
        this.bloodId = bloodId;
    }

    public BloodDTO getBloodDTO() {
        return bloodDTO;
    }

    public void setBloodDTO(BloodDTO bloodDTO) {
        this.bloodDTO = bloodDTO;
    }

    public DonorDTO getDonorDTO() {
        return donorDTO;
    }

    public void setDonorDTO(DonorDTO donorDTO) {
        this.donorDTO = donorDTO;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String[] toStringArray_ID_Name_DOB_Gender_BloodGroup_Donation_Id() {
        return new String[]{
                patientId.toString(),
                patientName,
                patientDOB.toString(),
                patientGender.toString(),
                bloodGroupDTO.toString(),
                bloodId.toString()
        };
    }
}
