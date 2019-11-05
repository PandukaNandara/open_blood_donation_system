package lk.sliit.iblood.business.custom;

import lk.sliit.iblood.business.SuperBO;
import lk.sliit.iblood.entity.Nurse;
import lk.sliit.iblood.model.NurseDTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:25 AM
 */
public interface NurseBO extends SuperBO<Nurse, NurseDTO> {
    boolean saveNurse(NurseDTO nurse) throws Exception;

    boolean updateNurse(NurseDTO nurse) throws Exception;

    boolean deleteNurse(Integer id) throws Exception;

    List<NurseDTO> getAllNurses() throws Exception;

    NurseDTO searchNurse(Integer id) throws Exception;

    NurseDTO searchNurse(String id) throws Exception;

    String getNameOfNurse(String id) throws Exception;
}
