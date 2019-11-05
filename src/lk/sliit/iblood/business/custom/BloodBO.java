package lk.sliit.iblood.business.custom;

import lk.sliit.iblood.business.SuperBO;
import lk.sliit.iblood.entity.Blood;
import lk.sliit.iblood.model.BloodDTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:24 AM
 */
public interface BloodBO extends SuperBO<Blood, BloodDTO> {

    BloodDTO searchBloodDonation(Integer id)  throws Exception;

    List<BloodDTO> getAllBloodDonationWithDonorsAndPatients() throws Exception;

    boolean saveBloodDonation(BloodDTO validate) throws Exception;

    BloodDTO searchBloodDonationWithDetails(String donation) throws Exception;
}
