package lk.sliit.iblood.model;

import lk.sliit.iblood.business.Modeler;
import lk.sliit.iblood.common.Tools;
import lk.sliit.iblood.common.ValidationException;
import lk.sliit.iblood.common.Validator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 2:29 AM
 */
public class BloodDTO implements Modeler<BloodDTO> {

    private Integer bloodId;
    private BigDecimal hemoglobin;
    private String hemoglobinStr;
    private String defection;
    private ArrayList<DoctorContributionDTO> doctorList;
    private ArrayList<NurseContributionDTO> nurseList;
    private Integer donorId;
    private Integer patientId;
    private PatientDTO patientDTO;
    private DonorDTO donorDTO;
    public BloodDTO() {
    }
    public BloodDTO(String hemoglobinStr, String defection, DonorDTO donorDTO,
                    ArrayList<DoctorContributionDTO> doctorList, ArrayList<NurseContributionDTO> nurseList) {
        this.hemoglobinStr = hemoglobinStr;
        this.defection = defection;
        this.doctorList = doctorList;
        this.nurseList = nurseList;
        setDonorDTO(donorDTO);
    }
    public BloodDTO(BigDecimal hemoglobin, String defection, Integer donorId, Integer patientId) {
        this.hemoglobin = hemoglobin;
        this.defection = defection;
        this.donorId = donorId;
        this.patientId = patientId;
    }
    public BloodDTO(Integer bloodId, BigDecimal hemoglobin, String defection, Integer donorId, Integer patientId) {
        this(hemoglobin, defection, donorId, patientId);
        this.bloodId = bloodId;
    }

    public ArrayList<DoctorContributionDTO> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(ArrayList<DoctorContributionDTO> doctorList) {
        this.doctorList = doctorList;
    }

    public ArrayList<NurseContributionDTO> getNurseList() {
        return nurseList;
    }

    public void setNurseList(ArrayList<NurseContributionDTO> nurseList) {
        this.nurseList = nurseList;
    }

    public Integer getBloodId() {
        return bloodId;
    }

    public void setBloodId(Integer bloodId) {
        this.bloodId = bloodId;
    }

    public BigDecimal getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(BigDecimal hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public String getDefection() {
        return defection;
    }

    public void setDefection(String defection) {
        this.defection = defection;
    }

    public Integer getDonorId() {
        return donorId;
    }

    public void setDonorId(Integer donorId) {
        this.donorId = donorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    @Override
    public String[] toStringArray() {
        return new String[]{};
    }

    public String[] toStringArrayWithDonorAndPatient() {
        return new String[]{
                donorId.toString(),
                hemoglobin.toString(),
                defection,
                donorDTO.getDonorId().toString(),
                Tools.joinFNameAndLName(donorDTO.getDonorFName(), donorDTO.getDonorLName()),
                patientDTO.getPatientId().toString(),
                patientDTO.getPatientName()

        };
    }


    @Override
    public BloodDTO validateAndReturn() throws Exception {
        if(!Validator.isValidHemoglobin(hemoglobinStr))
            throw new ValidationException("Hemoglobin is not valid.");
        else if (Objects.isNull(donorDTO))
            throw new ValidationException("The donor is not specified.");
        else if (doctorList.size() == 0)
            throw new ValidationException("Please specify some doctors.");
        else if (nurseList.size() == 0)
            throw new ValidationException("Please specify some nurses.");
        else {
            if(!Validator.isNullOrEmpty(hemoglobinStr))
                hemoglobin = new BigDecimal(Double.parseDouble(hemoglobinStr));
            donorId = donorDTO.getDonorId();
            return this;
        }
    }

    @Override
    public BloodDTO validateWithPKeyAndReturn() throws Exception {
        return null;
    }


    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    public DonorDTO getDonorDTO() {
        return donorDTO;
    }

    public void setDonorDTO(DonorDTO donorDTO) {
        this.donorDTO = donorDTO;
    }
}
