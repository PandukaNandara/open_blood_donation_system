package lk.sliit.iblood.entity;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-11-02
 * Time: 5:28 PM
 */
public class CustomEntity {
    private Blood blood;
    private Patient patient;
    private Donor donor;
    private String doctorFName;
    private String doctorLName;
    private DoctorContribution doctorContribution;
    private NurseContribution nurseContribution;
    private String nurseFName;
    private String nurseLName;

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

    public Blood getBlood() {
        return blood;
    }

    public void setBlood(Blood blood) {
        this.blood = blood;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public String getDoctorFName() {
        return doctorFName;
    }

    public void setDoctorFName(String doctorFName) {
        this.doctorFName = doctorFName;
    }

    public String getDoctorLName() {
        return doctorLName;
    }

    public void setDoctorLName(String doctorLName) {
        this.doctorLName = doctorLName;
    }

    public DoctorContribution getDoctorContribution() {
        return doctorContribution;
    }

    public void setDoctorContribution(DoctorContribution doctorContribution) {
        this.doctorContribution = doctorContribution;
    }

    public NurseContribution getNurseContribution() {
        return nurseContribution;
    }

    public void setNurseContribution(NurseContribution nurseContribution) {
        this.nurseContribution = nurseContribution;
    }
}
