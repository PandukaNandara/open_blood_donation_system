package lk.sliit.iblood.model;

import lk.sliit.iblood.business.Modeler;
import lk.sliit.iblood.common.Tools;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 2:28 AM
 */
public class DoctorContributionDTO implements Modeler {

    private boolean isNew;
    private DoctorDTO doctorDTO;
    private Integer doctorConId;
    private Integer bloodId;
    private Integer doctorId;

    public DoctorContributionDTO() {
    }

    public DoctorContributionDTO(DoctorDTO doctorDTO, boolean isNew) {
        setDoctorDTO(doctorDTO);
        this.isNew = isNew;
    }

    public DoctorContributionDTO(Integer bloodId, Integer doctorId) {
        this.bloodId = bloodId;
        this.doctorId = doctorId;
    }

    public DoctorContributionDTO(Integer doctorConId, Integer bloodId, Integer doctorId) {
        this(bloodId, doctorId);
        this.doctorConId = doctorConId;

    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
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

    public DoctorDTO getDoctorDTO() {
        return doctorDTO;
    }

    public void setDoctorDTO(DoctorDTO doctorDTO) {
        this.doctorDTO = doctorDTO;
        this.doctorId = doctorDTO.getDoctorId();
    }

    @Override
    public String[] toStringArray() {
        throw new UnsupportedOperationException();
    }

    public String[] toStringArrayDoctorName() {
        return new String[]{
                doctorId.toString(),
                Tools.joinFNameAndLName(doctorDTO.getDoctorFName(), doctorDTO.getDoctorLName())
        };
    }

    @Override
    public Object validateAndReturn() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object validateWithPKeyAndReturn() throws Exception {
        throw new UnsupportedOperationException();
    }
}
