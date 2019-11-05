package lk.sliit.iblood.entity;

import lk.sliit.iblood.common.Attribute;
import lk.sliit.iblood.common.Entity;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 2:28 AM
 */
@Entity
public class DoctorContribution {
    @Attribute
    private Integer doctorConId;
    @Attribute
    private Integer bloodId;
    @Attribute
    private Integer doctorId;

    public DoctorContribution() {
    }

    public DoctorContribution(Integer bloodId, Integer doctorId) {
        this.bloodId = bloodId;
        this.doctorId = doctorId;
    }

    public DoctorContribution(Integer doctorConId, Integer bloodId, Integer doctorId) {
        this(bloodId, doctorId);
        this.doctorConId = doctorConId;

    }

    public Integer getDoctorConId() {
        return doctorConId;
    }

    public void setDoctorConId(Integer doctorConId) {
        this.doctorConId = doctorConId;
    }

    public Integer getBloodId() {
        return bloodId;
    }

    public void setBloodId(Integer bloodId) {
        this.bloodId = bloodId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }
}
