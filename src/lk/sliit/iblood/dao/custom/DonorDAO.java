package lk.sliit.iblood.dao.custom;
import lk.sliit.iblood.dao.CrudDAO;
import lk.sliit.iblood.entity.Donor;
import lk.sliit.iblood.model.DonorDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:30 AM
 */
public interface DonorDAO extends CrudDAO<Integer, Donor> {

    Donor getDonorForThisBloodDonation(Integer value) throws Exception;
}
