package lk.sliit.iblood.business.custom.impl;

import lk.sliit.iblood.business.SuperBO;
import lk.sliit.iblood.business.custom.BloodGroupBO;
import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.dao.DAOFactory;
import lk.sliit.iblood.dao.DAOType;
import lk.sliit.iblood.dao.custom.BloodGroupDAO;
import lk.sliit.iblood.entity.BloodGroup;
import lk.sliit.iblood.model.BloodGroupDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 2:35 AM
 */
public class BloodGroupBOImpl implements BloodGroupBO {
    private BloodGroupDAO bloodGroupDAO = DAOFactory.getInstance().getDAO(DAOType.BLOOD_GROUP);

    @Override
    public boolean saveBloodGroup(BloodGroupDTO bloodGroupDTO) throws Exception {
        return SuperBO.doMiddleOFCommit(() -> bloodGroupDAO.save(BloodGroupBOImpl.this.modelToEntity(bloodGroupDTO)));
    }


    @Override
    public boolean updateBloodGroup(BloodGroupDTO bloodGroupDTO) throws Exception {
        return SuperBO.doMiddleOFCommit(
                () -> bloodGroupDAO.update(modelToEntity(bloodGroupDTO))
        );
    }

    @Override
    public boolean deleteBloodGroup(Integer id) throws Exception {
        return SuperBO.doMiddleOFCommit(()->bloodGroupDAO.delete(id));
    }

    @Override
    public List<BloodGroupDTO> getAllBloodGroups() throws Exception {
        List<BloodGroupDTO> bloodGroupDTOS = new ArrayList<>();
        bloodGroupDAO.getAll().forEach(bloodGroup ->
                bloodGroupDTOS.add(BloodGroupBOImpl.this.entityToModel(bloodGroup))
        );
        return bloodGroupDTOS;
    }

    @Override
    public BloodGroupDTO searchBloodGroup(Integer id) throws Exception {
        return entityToModel(bloodGroupDAO.search(id));
    }

    @Override
    public BloodGroupDTO searchBloodGroup(String id) throws Exception {
        BloodGroupDTO bloodGroupDTO = searchBloodGroup(Integer.valueOf(id));
        if (Objects.isNull(bloodGroupDTO))
            throw new NoSuchElementException();
        return bloodGroupDTO;
    }

    @Override
    public BloodGroupDTO entityToModel(@Entity BloodGroup bloodGroup) {
        return new BloodGroupDTO(
                bloodGroup.getBloodGroupId(),
                bloodGroup.getBloodGroupName()
        );
    }

    @Override
    public BloodGroup modelToEntity(BloodGroupDTO en) {
        return new BloodGroup(en.getBloodGroupId(), en.getBloodGroupName());
    }
}
