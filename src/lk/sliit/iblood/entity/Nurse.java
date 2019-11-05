package lk.sliit.iblood.entity;

import lk.sliit.iblood.common.Attribute;
import lk.sliit.iblood.common.Entity;

import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 2:15 AM
 */
@Entity
public class Nurse {
    @Attribute
    private
    Integer nurseId;
    @Attribute
    private
    String nurseFName;
    @Attribute
    private
    String nurseLName;
    @Attribute
    private
    String service;
    @Attribute
    private
    Date nurseDOB;
    @Attribute
    private
    String nurseAddress;

    public Nurse() {
    }

    public Nurse(String nurseFName, String nurseLName, String service, Date nurseDOB, String nurseAddress) {
        this.nurseFName = nurseFName;
        this.nurseLName = nurseLName;
        this.service = service;
        this.nurseDOB = nurseDOB;
        this.nurseAddress = nurseAddress;
    }

    public Nurse(Integer nurseId, String nurseFName, String nurseLName, String service, Date nurseDOB, String nurseAddress) {
        this(nurseFName, nurseLName, service, nurseDOB, nurseAddress);
        this.nurseId = nurseId;
    }

    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
    }

    public String getNurseFName() {
        return nurseFName;
    }

    public void setNurseFName(String nurseFName) {
        this.nurseFName = nurseFName;
    }

    public String getNurseLName() {
        return nurseLName;
    }

    public void setNurseLName(String nurseLName) {
        this.nurseLName = nurseLName;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Date getNurseDOB() {
        return nurseDOB;
    }

    public void setNurseDOB(Date nurseDOB) {
        this.nurseDOB = nurseDOB;
    }

    public String getNurseAddress() {
        return nurseAddress;
    }

    public void setNurseAddress(String nurseAddress) {
        this.nurseAddress = nurseAddress;
    }
}
