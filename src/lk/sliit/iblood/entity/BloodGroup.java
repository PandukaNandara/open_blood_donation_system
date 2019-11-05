package lk.sliit.iblood.entity;

import lk.sliit.iblood.common.Attribute;
import lk.sliit.iblood.common.Entity;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 1:38 AM
 */
@Entity
public class BloodGroup {

    @Attribute private Integer bloodGroupId;
    @Attribute private String bloodGroupName;

    public BloodGroup() {
    }

    public BloodGroup(String bloodGroupName) {
        this.bloodGroupName = bloodGroupName;
    }

    public BloodGroup(Integer bloodGroupId, String bloodGroupName) {
        this(bloodGroupName);
        this.bloodGroupId = bloodGroupId;
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
}
