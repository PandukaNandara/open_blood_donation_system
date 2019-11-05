package lk.sliit.iblood.business.custom.impl;

import lk.sliit.iblood.business.BOFactory;
import lk.sliit.iblood.business.BOType;
import lk.sliit.iblood.business.SuperBO;
import lk.sliit.iblood.business.custom.*;
import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.dao.DAOFactory;
import lk.sliit.iblood.dao.DAOType;
import lk.sliit.iblood.dao.custom.BloodDAO;
import lk.sliit.iblood.dao.custom.DoctorContributionDAO;
import lk.sliit.iblood.dao.custom.NurseContributionDAO;
import lk.sliit.iblood.dao.custom.QueryDAO;
import lk.sliit.iblood.entity.Blood;
import lk.sliit.iblood.entity.CustomEntity;
import lk.sliit.iblood.entity.DoctorContribution;
import lk.sliit.iblood.entity.NurseContribution;
import lk.sliit.iblood.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:24 AM
 */
public class BloodBOImpl implements BloodBO {

    QueryDAO queryDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOM);

    BloodDAO bloodDAO = DAOFactory.getInstance().getDAO(DAOType.BLOOD);


    PatientBO patientBO = BOFactory.getInstance().getBO(BOType.PATIENT);
    DonorBO donorBO = BOFactory.getInstance().getBO(BOType.DONOR);


    DoctorContributionDAO doctorContributionDAO = DAOFactory.getInstance().getDAO(DAOType.DOCTOR_CONTRIBUTION);
    NurseContributionDAO nurseContributionDAO = DAOFactory.getInstance().getDAO(DAOType.NURSE_CONTRIBUTION);

    DoctorContributionBO doctorContributionBO = BOFactory.getInstance().getBO(BOType.DOCTOR_CONTRIBUTION);
    NurseContributionBO nurseContributionBO = BOFactory.getInstance().getBO(BOType.NURSE_CONTRIBUTION);


    private boolean isAllCompleted;

    @Override
    public boolean saveBloodDonation(BloodDTO validate) throws Exception {
        isAllCompleted = false;
        return SuperBO.doMiddleOFCommit(() -> {
            Blood blood = modelToEntity(validate);
            isAllCompleted = bloodDAO.save(blood);
            Integer lastId = bloodDAO.getLastIncrementedValue();
            for (DoctorContributionDTO doctorContributionDTO : validate.getDoctorList()) {
                DoctorContribution docConEnt = doctorContributionBO.modelToEntity(doctorContributionDTO);
                docConEnt.setBloodId(lastId);
                isAllCompleted = isAllCompleted && doctorContributionDAO.save(docConEnt);
            }

            for (NurseContributionDTO nurseContributionDTO : validate.getNurseList()) {
                NurseContribution nurseCon = nurseContributionBO.modelToEntity(nurseContributionDTO);
                nurseCon.setBloodId(lastId);
                isAllCompleted = isAllCompleted && nurseContributionDAO.save(nurseCon);
            }
            return isAllCompleted;
        });
    }

    @Override
    public BloodDTO searchBloodDonationWithDetails(String donationId)  throws Exception{
        BloodDTO bloodDTO = searchBloodDonation(Integer.valueOf(donationId));
        List<CustomEntity> customEntities = queryDAO.getDoctorsContributionWithName(donationId);

        ArrayList<DoctorContributionDTO> doctorContributionDTOS = new ArrayList<>();
        ArrayList<NurseContributionDTO> nurseContributionDTOS = new ArrayList<>();

        DonorDTO donorDTO = donorBO.getDonorForThisBloodDonation(donationId);

        customEntities.forEach(customEntity -> {
            DoctorContributionDTO
                    docContribution =
                    doctorContributionBO.entityToModel(customEntity.getDoctorContribution());
                    docContribution.setDoctorDTO(
                            new DoctorDTO(docContribution.getDoctorId(), customEntity.getDoctorFName(), customEntity.getDoctorLName())
                    );
            doctorContributionDTOS.add(docContribution);
        });

        List<CustomEntity> customNurse = queryDAO.getNursesContributionWithName(donationId);
        customNurse.forEach(customEntity -> {
            NurseContributionDTO
                    nurContribution =
                    nurseContributionBO.entityToModel(customEntity.getNurseContribution());
            nurContribution.setNurseDTO(
                    new NurseDTO(nurContribution.getNurseId(), customEntity.getNurseFName(), customEntity.getNurseLName())
            );
            nurseContributionDTOS.add(nurContribution);
        });

        bloodDTO.setDoctorList(doctorContributionDTOS);
        bloodDTO.setNurseList(nurseContributionDTOS);
        bloodDTO.setDonorDTO(donorDTO);
        return bloodDTO;
    }

    @Override
    public BloodDTO searchBloodDonation(Integer id)  throws Exception{
        Blood blood = bloodDAO.search(id);
        return entityToModel(blood);
    }

    @Override
    public BloodDTO entityToModel(@Entity Blood blood) {
        return new BloodDTO(
                blood.getBloodId(),
                blood.getHemoglobin(),
                blood.getDefection(),
                blood.getDonorId(),
                blood.getPatientId()
        );
    }

    @Override
    public Blood modelToEntity(BloodDTO en) {
        return new Blood(
                en.getBloodId(),
                en.getHemoglobin(),
                en.getDefection(),
                en.getDonorId(),
                en.getPatientId()
        );
    }

    @Override
    public List<BloodDTO> getAllBloodDonationWithDonorsAndPatients() throws Exception {
        List<CustomEntity> customEntityList = queryDAO.getAllBloodDonationWithDonorsAndPatients();
        List<BloodDTO> bloodDonation = new ArrayList<>();

        customEntityList.forEach(
                customEntity -> {
                    BloodDTO bloodDTO = this.entityToModel(customEntity.getBlood());
                    bloodDTO.setDonorDTO(donorBO.entityToModel(customEntity.getDonor()));
                    bloodDTO.setPatientDTO(patientBO.entityToModel(customEntity.getPatient()));
                    bloodDonation.add(bloodDTO);
                }
        );
        return bloodDonation;
    }
}
