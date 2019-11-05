package lk.sliit.iblood.business.custom.impl;

import lk.sliit.iblood.business.SuperBO;
import lk.sliit.iblood.business.custom.DoctorBO;
import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.common.Tools;
import lk.sliit.iblood.dao.DAOFactory;
import lk.sliit.iblood.dao.DAOType;
import lk.sliit.iblood.dao.custom.DoctorDAO;
import lk.sliit.iblood.entity.Doctor;
import lk.sliit.iblood.model.DoctorDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:25 AM
 */
public class DoctorBOImpl implements DoctorBO {


    private DoctorDAO doctorDAO = DAOFactory.getInstance().getDAO(DAOType.DOCTOR);

    @Override
    public boolean saveDoctor(DoctorDTO doctor) throws Exception {
        return SuperBO.doMiddleOFCommit(
                () -> doctorDAO.save(modelToEntity(doctor))
        );
    }


    @Override
    public boolean updateDoctor(DoctorDTO doctor) throws Exception {
        return SuperBO.doMiddleOFCommit(
                () -> doctorDAO.update(modelToEntity(doctor))
        );
    }

    @Override
    public boolean deleteDoctor(Integer id) throws Exception {
        return doctorDAO.delete(id);
    }

    @Override
    public List<DoctorDTO> getAllDoctors() throws Exception {
        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        doctorDAO.getAll().forEach(doctor -> doctorDTOS.add(DoctorBOImpl.this.entityToModel(doctor)));
        return doctorDTOS;
    }

    @Override
    public DoctorDTO searchDoctor(Integer id) throws Exception {
        return entityToModel(doctorDAO.search(id));
    }

    @Override
    public DoctorDTO searchDoctor(String id) throws Exception {
        DoctorDTO doctorDTO = searchDoctor(Integer.valueOf(id));
        if(Objects.isNull(doctorDTO))
                throw new NoSuchElementException();
        return doctorDTO;
    }

    @Override
    public String getNameOfDoctor(String id) throws Exception {
        DoctorDTO doctorDTO = searchDoctor(id);
        return Tools.joinFNameAndLName(
                doctorDTO.getDoctorFName(),
                doctorDTO.getDoctorLName()
        );
    }


    @Override
    public DoctorDTO entityToModel(@Entity Doctor doctor) {
        return new DoctorDTO(
                doctor.getDoctorId(),
                doctor.getDoctorFName(),
                doctor.getDoctorLName(),
                doctor.getDoctorDOB(), doctor.getDoctorAddress(),
                doctor.getDoctorEmail()
        );
    }

    @Override
    public Doctor modelToEntity(DoctorDTO en) {
        return new Doctor(
                en.getDoctorId(),
                en.getDoctorFName(),
                en.getDoctorLName(),
                Tools.sqlDateToUtilDate(en.getDoctorDOB()),
                en.getDoctorAddress(),
                en.getDoctorEmail()
        );
    }
}
