package lk.sliit.iblood.business.custom.impl;

import lk.sliit.iblood.business.SuperBO;
import lk.sliit.iblood.business.custom.DoctorContributionBO;
import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.dao.custom.DoctorContributionDAO;
import lk.sliit.iblood.entity.DoctorContribution;
import lk.sliit.iblood.model.DoctorContributionDTO;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:25 AM
 */
public class DoctorContributionBOImpl implements DoctorContributionBO {
    @Override
    public DoctorContributionDTO entityToModel(@Entity DoctorContribution doctorContribution) {
        return new DoctorContributionDTO(
                doctorContribution.getDoctorConId(),
                doctorContribution.getBloodId(),
                doctorContribution.getDoctorId()
        );
    }

    @Override
    public DoctorContribution modelToEntity(DoctorContributionDTO en) {
        return new DoctorContribution(
                en.getDoctorConId(),
                en.getBloodId(),
                en.getDoctorId()
        );
    }
}
