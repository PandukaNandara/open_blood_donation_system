package lk.sliit.iblood.entity;

import lk.sliit.iblood.common.Attribute;
import lk.sliit.iblood.common.Entity;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 2:22 AM
 */
@Entity
public class NurseContribution {
    @Attribute
    private
    Integer nurseConId;
    @Attribute
    private
    Integer bloodId;
    @Attribute
    private
    Integer nurseId;

    public NurseContribution() {
    }

    public NurseContribution(Integer bloodId, Integer nurseId) {
        this.bloodId = bloodId;
        this.nurseId = nurseId;
    }

    public NurseContribution(Integer nurseConId, Integer bloodId, Integer nurseId) {
        this(bloodId, nurseId);
        this.nurseConId = nurseConId;
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
}
