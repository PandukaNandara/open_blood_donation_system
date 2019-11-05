package lk.sliit.iblood.business.custom.impl;

import lk.sliit.iblood.business.BOFactory;
import lk.sliit.iblood.business.BOType;
import lk.sliit.iblood.business.SuperBO;
import lk.sliit.iblood.business.custom.BloodGroupBO;
import lk.sliit.iblood.business.custom.DonorBO;
import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.common.Tools;
import lk.sliit.iblood.dao.DAOFactory;
import lk.sliit.iblood.dao.DAOType;
import lk.sliit.iblood.dao.custom.DonorDAO;
import lk.sliit.iblood.dao.custom.QueryDAO;
import lk.sliit.iblood.entity.Donor;
import lk.sliit.iblood.model.DonorDTO;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:30 AM
 */
public class DonorBOImpl implements DonorBO {

    private DonorDAO donorDAO = DAOFactory.getInstance().getDAO(DAOType.DONOR);
    private BloodGroupBO bloodGroupBO = BOFactory.getInstance().getBO(BOType.BLOOD_GROUP);

    private QueryDAO queryDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOM);
    @Override
    public boolean saveDonor(DonorDTO donor) throws Exception {
        donor.setRegistrationDate(java.sql.Date.valueOf(LocalDate.now()));
        donor.setRegistrationTime(Time.valueOf(LocalTime.now()));
        return SuperBO.doMiddleOFCommit(
                () -> donorDAO.save(modelToEntity(donor))
        );
    }


    @Override
    public boolean updateDonor(DonorDTO donor) throws Exception {
        return SuperBO.doMiddleOFCommit(
                () -> donorDAO.update(modelToEntityWithoutRegDate(donor))
        );
    }

    private Donor modelToEntityWithoutRegDate(DonorDTO en) {

        return new Donor(
                en.getDonorId(),
                en.getDonorFName(),
                en.getDonorLName(),
                en.getDonorNIC(),
                Tools.sqlDateToUtilDate(en.getDonorDOB()),
                en.getDonorGender(),
                en.getDonorAddress(),
                en.getDonorEmail(),
                en.getDonorMobile(),
                en.getBloodGroupId()
        );
    }

    @Override
    public boolean deleteDonor(Integer id) throws Exception {
        return donorDAO.delete(id);
    }

    @Override
    public List<DonorDTO> getAllDonors() throws Exception {
        List<DonorDTO> donorDTOS = new ArrayList<>();
        for (Donor donor : donorDAO.getAll()) {
            DonorDTO donorDTO = DonorBOImpl.this.entityToModel(donor);
            donorDTO.setBloodGroupDTO(
                    bloodGroupBO.searchBloodGroup(
                            donorDTO.getBloodGroupId()
                    )
            );
            donorDTOS.add(donorDTO);
        }
        return donorDTOS;
    }

    @Override
    public DonorDTO searchDonor(Integer id) throws Exception {
        DonorDTO donorDTO = entityToModel(donorDAO.search(id));
        donorDTO.setBloodGroupDTO(
                bloodGroupBO.searchBloodGroup(
                        donorDTO.getBloodGroupId()
                )
        );
        return donorDTO;
    }

    @Override
    public DonorDTO searchDonor(String id) throws Exception {
        DonorDTO donorDTO = searchDonor(Integer.valueOf(id));
        if (Objects.isNull(donorDTO))
            throw new NoSuchElementException();
        return donorDTO;
    }

    @Override
    public DonorDTO getDonorOfThisPatient(Integer idInt) throws Exception {

        Donor donor = queryDAO.getDonorOfThisPatient(idInt);

        return entityToModel(donor);
    }


    @Override
    public List<DonorDTO> getDonorsWhoHaveThisBloodGroupDoNotHavePatient(Integer bloodGroupId) throws Exception {
        List<DonorDTO> donorDTOList = new ArrayList<>();
        List<Donor> donors = queryDAO.getDonorsWhoHaveThisBloodGroupDoNotHavePatient(bloodGroupId);
        donors.forEach(donor -> donorDTOList.add(entityToModel(donor)));
        return donorDTOList;
    }

    @Override
    public DonorDTO getDonorForThisBloodDonation(String donationId) throws Exception {
        Donor donor = donorDAO.getDonorForThisBloodDonation(Integer.valueOf(donationId));
        DonorDTO donorDTO = entityToModel(donor);
        donorDTO.setBloodGroupDTO(
                bloodGroupBO.searchBloodGroup(
                        donorDTO.getBloodGroupId()
                )
        );
        return donorDTO;
    }

    @Override
    public DonorDTO entityToModel(@Entity Donor donor) {
        DonorDTO donorDTO = new DonorDTO(
                donor.getDonorId(),
                donor.getDonorFName(),
                donor.getDonorLName(),
                donor.getDonorNIC(),
                donor.getDonorDOB(),
                donor.getDonorGender(),
                donor.getRegistrationDate(),
                donor.getRegistrationTime(),
                donor.getDonorAddress(),
                donor.getDonorEmail(),
                donor.getDonorMobile(),
                donor.getBloodGroupId()
        );
        donorDTO.setBloodId(donor.getBloodId());
        return donorDTO;
    }

    @Override
    public Donor modelToEntity(DonorDTO en) {

        return new Donor(
                en.getDonorId(),
                en.getDonorFName(),
                en.getDonorLName(),
                en.getDonorNIC(),
                Tools.sqlDateToUtilDate(en.getDonorDOB()),
                en.getDonorGender(),
                Tools.sqlDateToUtilDate(en.getRegistrationDate()),
                en.getRegistrationTime(),
                en.getDonorAddress(),
                en.getDonorEmail(),
                en.getDonorMobile(),
                en.getBloodGroupId()
        );
    }
}
