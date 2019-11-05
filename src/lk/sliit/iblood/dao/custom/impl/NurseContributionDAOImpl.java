package lk.sliit.iblood.dao.custom.impl;
import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.dao.CrudDAO;
import lk.sliit.iblood.dao.CrudUtil;
import lk.sliit.iblood.dao.custom.NurseContributionDAO;
import lk.sliit.iblood.entity.NurseContribution;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:25 AM
 */
public class NurseContributionDAOImpl implements NurseContributionDAO {
    @Override
    public Boolean save(@Entity NurseContribution ent) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO nurse_contribution(bld_id, nur_id) VALUES (?,?)",
                ent.getBloodId(),
                ent.getNurseId()) > 0;
    }

    @Override
    public Boolean update(@Entity NurseContribution ent) throws Exception {
        return null;
    }

    @Override
    public Boolean delete(Integer e) throws Exception {
        return null;
    }

    @Override
    public NurseContribution search(@Entity Integer id) throws Exception {
        return null;
    }

    @Override
    public List<NurseContribution> getAll() throws Exception {
        return null;
    }
}
