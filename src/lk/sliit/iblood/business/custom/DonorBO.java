package lk.sliit.iblood.business.custom;

import lk.sliit.iblood.business.SuperBO;
import lk.sliit.iblood.entity.Donor;
import lk.sliit.iblood.model.DonorDTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:30 AM
 */
public interface DonorBO extends SuperBO<Donor, DonorDTO> {
    boolean saveDonor(DonorDTO donor) throws Exception;

    boolean updateDonor(DonorDTO donor) throws Exception;

    boolean deleteDonor(Integer id) throws Exception;

    List<DonorDTO> getAllDonors() throws Exception;

    DonorDTO searchDonor(Integer id) throws Exception;

    DonorDTO searchDonor(String id) throws Exception;

    DonorDTO getDonorOfThisPatient(Integer idInt) throws Exception;

    List<DonorDTO> getDonorsWhoHaveThisBloodGroupDoNotHavePatient(Integer bloodGroupId) throws Exception;

    DonorDTO getDonorForThisBloodDonation(String donationId) throws Exception;
}
