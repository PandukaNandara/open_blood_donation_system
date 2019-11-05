package lk.sliit.iblood.entity;

import lk.sliit.iblood.common.Attribute;
import lk.sliit.iblood.common.Entity;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 2:29 AM
 */
@Entity
public class Blood {
    @Attribute
    private
    Integer bloodId;
    @Attribute
    private
    BigDecimal hemoglobin;
    @Attribute
    private
    String defection;
    @Attribute
    private
    Integer donorId;
    @Attribute
    private
    Integer patientId;

    public Blood() {
    }
    public Blood(BigDecimal hemoglobin, String defection, Integer donorId, Integer patientId) {
        this.hemoglobin = hemoglobin;
        this.defection = defection;
        this.donorId = donorId;
        this.patientId = patientId;
    }

    public Blood(Integer bloodId, BigDecimal hemoglobin, String defection, Integer donorId, Integer patientId) {
        this(hemoglobin, defection, donorId, patientId);
        this.bloodId = bloodId;
    }

    @Override
    public String toString() {
        return "Blood{" +
                "bloodId=" + bloodId +
                ", hemoglobin=" + hemoglobin +
                ", defection='" + defection + '\'' +
                ", donorId=" + donorId +
                ", patientId=" + patientId +
                '}';
    }

    public Integer getBloodId() {
        return bloodId;
    }

    public void setBloodId(Integer bloodId) {
        this.bloodId = bloodId;
    }

    public BigDecimal getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(BigDecimal hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public String getDefection() {
        return defection;
    }

    public void setDefection(String defection) {
        this.defection = defection;
    }

    public Integer getDonorId() {
        return donorId;
    }

    public void setDonorId(Integer donorId) {
        this.donorId = donorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }
}
