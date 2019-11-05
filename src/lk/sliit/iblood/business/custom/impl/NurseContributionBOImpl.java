package lk.sliit.iblood.business.custom.impl;

import lk.sliit.iblood.business.SuperBO;
import lk.sliit.iblood.business.custom.NurseContributionBO;
import lk.sliit.iblood.common.Entity;
import lk.sliit.iblood.entity.NurseContribution;
import lk.sliit.iblood.model.NurseContributionDTO;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:25 AM
 */
public class NurseContributionBOImpl implements NurseContributionBO {
    @Override
    public NurseContributionDTO entityToModel(@Entity NurseContribution nurseContribution) {
        return new NurseContributionDTO(
                nurseContribution.getNurseConId(),
                nurseContribution.getBloodId(),
                nurseContribution.getNurseId()
        );
    }

    @Override
    public NurseContribution modelToEntity(NurseContributionDTO en) {
        return new NurseContribution(
                en.getNurseConId(),
                en.getBloodId(),
                en.getNurseId()
        );
    }
}
