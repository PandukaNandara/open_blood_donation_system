package lk.sliit.iblood.business.custom;

import lk.sliit.iblood.business.SuperBO;
import lk.sliit.iblood.entity.Doctor;
import lk.sliit.iblood.model.DoctorDTO;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:25 AM
 */
public interface DoctorBO extends SuperBO<Doctor, DoctorDTO> {
    boolean saveDoctor(DoctorDTO doctor) throws Exception;

    boolean updateDoctor(DoctorDTO doctor) throws Exception;

    boolean deleteDoctor(Integer id) throws Exception;

    List<DoctorDTO> getAllDoctors() throws Exception;

    DoctorDTO searchDoctor(Integer id) throws Exception;

    DoctorDTO searchDoctor(String id) throws Exception;

    String getNameOfDoctor(String id) throws Exception;
}
