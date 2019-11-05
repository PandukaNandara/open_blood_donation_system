package lk.sliit.iblood.business.custom.impl;

import lk.sliit.iblood.business.SuperBO;
import lk.sliit.iblood.business.custom.NurseBO;
import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.common.Tools;
import lk.sliit.iblood.dao.DAOFactory;
import lk.sliit.iblood.dao.DAOType;
import lk.sliit.iblood.dao.custom.NurseDAO;
import lk.sliit.iblood.entity.Nurse;
import lk.sliit.iblood.model.NurseDTO;

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
public class NurseBOImpl implements NurseBO {

    private NurseDAO nurseDAO = DAOFactory.getInstance().getDAO(DAOType.NURSE);

    @Override
    public boolean saveNurse(NurseDTO nurse) throws Exception {
        return SuperBO.doMiddleOFCommit(
                () -> nurseDAO.save(modelToEntity(nurse))
        );
    }


    @Override
    public boolean updateNurse(NurseDTO nurse) throws Exception {
        return SuperBO.doMiddleOFCommit(
                () -> nurseDAO.update(modelToEntity(nurse))
        );
    }

    @Override
    public boolean deleteNurse(Integer id) throws Exception {
        return nurseDAO.delete(id);
    }

    @Override
    public List<NurseDTO> getAllNurses() throws Exception {
        List<NurseDTO> nurseDTOSDTOS = new ArrayList<>();
        nurseDAO.getAll().forEach(nurse -> nurseDTOSDTOS.add(NurseBOImpl.this.entityToModel(nurse)));
        return nurseDTOSDTOS;
    }

    @Override
    public NurseDTO searchNurse(Integer id) throws Exception {
        return entityToModel(nurseDAO.search(id));
    }

    @Override
    public NurseDTO searchNurse(String id) throws Exception {
        NurseDTO nurseDTO = searchNurse(Integer.valueOf(id));
        if(Objects.isNull(nurseDTO))
            throw new NoSuchElementException();
        return nurseDTO;
    }

    @Override
    public String getNameOfNurse(String id) throws Exception {
        NurseDTO nurseDTO = searchNurse(id);
        System.out.println(nurseDTO);
        return Tools.joinFNameAndLName(nurseDTO.getNurseFName(),nurseDTO.getNurseLName());
    }

    @Override
    public NurseDTO entityToModel(@Entity Nurse nurse) {
        return new NurseDTO(
                nurse.getNurseId(),
                nurse.getNurseFName(),
                nurse.getNurseLName(),
                nurse.getService(),
                nurse.getNurseDOB(),
                nurse.getNurseAddress()
        );
    }

    @Override
    public Nurse modelToEntity(NurseDTO en) {
        return new Nurse(
                en.getNurseId(),
                en.getNurseFName(),
                en.getNurseLName(),
                en.getService(),
                Tools.sqlDateToUtilDate(en.getNurseDOB()),
                en.getNurseAddress()
        );
    }
}
