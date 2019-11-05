package lk.sliit.iblood.business.custom.impl;

import lk.sliit.iblood.business.BOFactory;
import lk.sliit.iblood.business.BOType;
import lk.sliit.iblood.business.SuperBO;
import lk.sliit.iblood.business.custom.BloodGroupBO;
import lk.sliit.iblood.business.custom.DonorBO;
import lk.sliit.iblood.business.custom.PatientBO;
import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.common.Tools;
import lk.sliit.iblood.dao.DAOFactory;
import lk.sliit.iblood.dao.DAOType;
import lk.sliit.iblood.dao.custom.BloodGroupDAO;
import lk.sliit.iblood.dao.custom.PatientDAO;
import lk.sliit.iblood.entity.BloodGroup;
import lk.sliit.iblood.entity.Patient;
import lk.sliit.iblood.model.BloodGroupDTO;
import lk.sliit.iblood.model.DonorDTO;
import lk.sliit.iblood.model.PatientDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class PatientBOImpl implements PatientBO {
    private PatientDAO patientDAO = DAOFactory.getInstance().getDAO(DAOType.PATIENT);
    private DonorBO donorBO = BOFactory.getInstance().getBO(BOType.DONOR);
    private BloodGroupDAO bloodGroupDAO = DAOFactory.getInstance().getDAO(DAOType.BLOOD_GROUP);
    private BloodGroupBO bloodGroupBO = BOFactory.getInstance().getBO(BOType.BLOOD_GROUP);

    @Override
    public boolean savePatient(PatientDTO patient) throws Exception {
        return SuperBO.doMiddleOFCommit(
                () -> patientDAO.save(modelToEntity(patient))
        );
    }


    @Override
    public boolean updatePatient(PatientDTO patient) throws Exception {
        return SuperBO.doMiddleOFCommit(
                () -> patientDAO.update(modelToEntity(patient))
        );
    }

    @Override
    public boolean deletePatient(Integer id) throws Exception {
        return patientDAO.delete(id);
    }

    @Override
    public List<PatientDTO> getAllPatients() throws Exception {

        List<PatientDTO> patientDTOS = new ArrayList<>();
        for (Patient patient : patientDAO.getAll()) {
            BloodGroupDTO bloodGroupDTO = bloodGroupBO.searchBloodGroup(patient.getBloodGroupId());
            PatientDTO patientDTO = PatientBOImpl.this.entityToModel(patient);
            patientDTO.setBloodGroupDTO(bloodGroupDTO);
            patientDTOS.add(patientDTO);

        }
        return patientDTOS;
    }

    @Override
    public PatientDTO searchPatient(Integer id) throws Exception {
        return entityToModel(patientDAO.search(id));
    }

    @Override
    public PatientDTO searchPatient(String id) throws Exception {
        PatientDTO patientDTO = searchPatient(Integer.valueOf(id));
        if(Objects.isNull(patientDTO))
            throw new NoSuchElementException();
        return patientDTO;
    }

    @Override
    public PatientDTO searchPatientWithDonor(String id) throws Exception {
        Integer idInt = Integer.valueOf(id);
        PatientDTO patientDTO = searchPatient(idInt);
        if(!Objects.isNull(patientDTO)) {
            DonorDTO donorDTO = donorBO.getDonorOfThisPatient(idInt);
            patientDTO.setDonorDTO(donorDTO);
            return patientDTO;
        }else return null;
    }

    @Override
    public PatientDTO entityToModel(@Entity Patient patient) {
        return new PatientDTO(
                patient.getPatientId(),
                patient.getPatientName(),
                patient.getPatientDOB(),
                patient.getPatientGender(),
                patient.getBloodGroupId(),
                patient.getBloodId(),
                patient.getRequestDate()
        );
    }

    @Override
    public Patient modelToEntity(PatientDTO dto) {
        Patient patient = new Patient(
                dto.getPatientId(),
                dto.getPatientName(),
                Tools.sqlDateToUtilDate(dto.getPatientDOB()),
                dto.getPatientGender(),
                dto.getBloodGroupDTO().getBloodGroupId(),
                dto.getBloodId(),
                Tools.sqlDateToUtilDate(dto.getRequestDate())
        );

        patient.setBloodId(dto.getBloodDTO().getBloodId());
        return patient;
    }
}
