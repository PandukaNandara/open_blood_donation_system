package lk.sliit.iblood.business.custom;

import lk.sliit.iblood.business.SuperBO;
import lk.sliit.iblood.entity.BloodGroup;
import lk.sliit.iblood.model.BloodGroupDTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 2:35 AM
 */
public interface BloodGroupBO extends SuperBO<BloodGroup, BloodGroupDTO> {
    boolean saveBloodGroup(BloodGroupDTO bloodGroupDTO) throws Exception;

    boolean updateBloodGroup(BloodGroupDTO bloodGroupDTO) throws Exception;

    boolean deleteBloodGroup(Integer id) throws Exception;

    List<BloodGroupDTO> getAllBloodGroups() throws Exception;

    BloodGroupDTO searchBloodGroup(Integer id) throws Exception;

    BloodGroupDTO searchBloodGroup(String id) throws Exception;
}
