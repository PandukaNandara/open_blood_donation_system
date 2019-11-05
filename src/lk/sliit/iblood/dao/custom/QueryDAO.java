package lk.sliit.iblood.dao.custom;

import lk.sliit.iblood.dao.SuperDAO;
import lk.sliit.iblood.entity.CustomEntity;
import lk.sliit.iblood.entity.Donor;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-11-02
 * Time: 5:27 PM
 */
public interface QueryDAO extends SuperDAO {
    Donor getDonorOfThisPatient(Integer idInt) throws Exception;

    List<Donor> getDonorsWhoHaveThisBloodGroupDoNotHavePatient(Integer bloodGroupId) throws Exception;

    List<CustomEntity> getAllBloodDonationWithDonorsAndPatients() throws Exception;

    List<CustomEntity> getDoctorsContributionWithName(String donationId) throws Exception;

    List<CustomEntity> getNursesContributionWithName(String donationId) throws Exception;
}
