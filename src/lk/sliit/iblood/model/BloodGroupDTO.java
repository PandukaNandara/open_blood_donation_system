package lk.sliit.iblood.model;

import lk.sliit.iblood.business.Modeler;
import lk.sliit.iblood.common.ValidationException;
import lk.sliit.iblood.common.Validator;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 1:38 AM
 */
public class BloodGroupDTO implements Modeler<BloodGroupDTO> {

    private Integer bloodGroupId;

    private String bloodGroupIdStr;

    private String bloodGroupName;

    public BloodGroupDTO() {
    }

    public BloodGroupDTO(Integer bloodGroupId) {
        this.bloodGroupId = bloodGroupId;
    }

    public BloodGroupDTO(String bloodGroupName) {
        this.bloodGroupName = bloodGroupName;
    }

    public BloodGroupDTO(Integer bloodGroupId, String bloodGroupName) {
        this(bloodGroupName);
        this.bloodGroupId = bloodGroupId;
    }

    public BloodGroupDTO(String bloodGroupIdStr, String bloodGroupName) {
        this(bloodGroupName);
        this.bloodGroupIdStr = bloodGroupIdStr;
    }

    @Override
    public String toString() {
        return bloodGroupName;
    }

    public Integer getBloodGroupId() {
        return bloodGroupId;
    }

    public void setBloodGroupId(Integer bloodGroupId) {
        this.bloodGroupId = bloodGroupId;
    }

    public String getBloodGroupName() {
        return bloodGroupName;
    }

    public void setBloodGroupName(String bloodGroupName) {
        this.bloodGroupName = bloodGroupName;
    }

    @Override
    public String[] toStringArray() {
        return new String[]{
                bloodGroupId.toString(),
                bloodGroupName
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BloodGroupDTO)) return false;
        BloodGroupDTO that = (BloodGroupDTO) o;
        return getBloodGroupId().equals(that.getBloodGroupId());
    }

    @Override
    public BloodGroupDTO validateAndReturn() throws Exception {
        if (Validator.isNullOrEmpty(bloodGroupName))
            throw new ValidationException("blood group name is not valid.");
        else return this;
    }

    @Override
    public BloodGroupDTO validateWithPKeyAndReturn() throws Exception {
        if (Validator.isNullOrEmpty(bloodGroupIdStr))
            throw new ValidationException("blood group name is not valid.");
        else {
            setBloodGroupId(Integer.valueOf(bloodGroupIdStr));
            return validateAndReturn();
        }
    }
}
