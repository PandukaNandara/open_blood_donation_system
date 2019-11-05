package lk.sliit.iblood.dao.custom.impl;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.ENTITYDatatypeValidator;
import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.dao.CrudUtil;
import lk.sliit.iblood.dao.custom.DoctorContributionDAO;
import lk.sliit.iblood.entity.DoctorContribution;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:35 AM
 */
public class DoctorContributionDAOImpl implements DoctorContributionDAO {
    @Override
    public Boolean save(@Entity DoctorContribution ent) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO doctor_contribution(bld_id, doc_id) VALUES (?,?)",
                ent.getBloodId(),
                ent.getDoctorId()) > 0;
    }

    @Override
    public Boolean update(@Entity DoctorContribution ent) throws Exception {
        return null;
    }

    @Override
    public Boolean delete(Integer e) throws Exception {
        return null;
    }

    @Override
    public DoctorContribution search(@Entity Integer id) throws Exception {
        return null;
    }

    @Override
    public List<DoctorContribution> getAll() throws Exception {
        return null;
    }
}
