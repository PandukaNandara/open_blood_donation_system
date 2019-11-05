package lk.sliit.iblood.model;

import lk.sliit.iblood.business.Modeler;
import lk.sliit.iblood.common.Tools;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 2:22 AM
 */
public class NurseContributionDTO implements Modeler<NurseContributionDTO> {

    private
    Integer nurseConId;

    private
    Integer bloodId;

    private
    Integer nurseId;
    private NurseDTO nurseDTO;
    private boolean isNew;

    public NurseContributionDTO() {
    }

    public NurseContributionDTO(Integer bloodId, Integer nurseId) {
        this.bloodId = bloodId;
        this.nurseId = nurseId;
    }

    public NurseContributionDTO(Integer nurseConId, Integer bloodId, Integer nurseId) {
        this(bloodId, nurseId);
        this.nurseConId = nurseConId;
    }
    public NurseContributionDTO(NurseDTO nurseDTO, boolean isNew) {
        setNurseDTO(nurseDTO);
        this.isNew = isNew;
    }

    public NurseDTO getNurseDTO() {
        return nurseDTO;
    }

    public void setNurseDTO(NurseDTO nurseDTO) {
        this.nurseDTO = nurseDTO;
        nurseId = nurseDTO.getNurseId();
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public Integer getNurseConId() {
        return nurseConId;
    }

    public void setNurseConId(Integer nurseConId) {
        this.nurseConId = nurseConId;
    }

    public Integer getBloodId() {
        return bloodId;
    }

    public void setBloodId(Integer bloodId) {
        this.bloodId = bloodId;
    }

    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
    }

    public String[] toStringArrayNurseName() {
        return new String[]{
                nurseId.toString(),
                Tools.joinFNameAndLName(
                        nurseDTO.getNurseFName(),
                        nurseDTO.getNurseLName()
                )
        };
    }

    @Override
    public String[] toStringArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public NurseContributionDTO validateAndReturn() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public NurseContributionDTO validateWithPKeyAndReturn() throws Exception {
        throw new UnsupportedOperationException();
    }
}
