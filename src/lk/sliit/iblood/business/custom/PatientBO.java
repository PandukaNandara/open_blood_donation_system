package lk.sliit.iblood.business.custom;

import lk.sliit.iblood.business.SuperBO;
import lk.sliit.iblood.entity.Patient;
import lk.sliit.iblood.model.DonorDTO;
import lk.sliit.iblood.model.PatientDTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:25 AM
 */
public interface PatientBO extends SuperBO<Patient, PatientDTO> {

    boolean savePatient(PatientDTO patient) throws Exception;

    boolean updatePatient(PatientDTO patient) throws Exception;

    boolean deletePatient(Integer id) throws Exception;

    List<PatientDTO> getAllPatients() throws Exception;

    PatientDTO searchPatient(Integer id) throws Exception;

    PatientDTO searchPatient(String id) throws Exception;

    PatientDTO searchPatientWithDonor(String trim) throws Exception;
}
