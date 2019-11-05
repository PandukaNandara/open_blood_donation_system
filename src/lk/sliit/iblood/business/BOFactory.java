package lk.sliit.iblood.business;

import lk.sliit.iblood.business.custom.impl.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 4:32 PM
 */
public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType) {
        switch (boType) {
            case BLOOD:
                return (T) new BloodBOImpl();
            case BLOOD_GROUP:
                return (T) new BloodGroupBOImpl();
            case DOCTOR:
                return (T) new DoctorBOImpl();
            case DOCTOR_CONTRIBUTION:
                return (T) new DoctorContributionBOImpl();
            case DONOR:
                return (T) new DonorBOImpl();
            case NURSE:
                return (T) new NurseBOImpl();
            case NURSE_CONTRIBUTION:
                return (T) new NurseContributionBOImpl();
            case PATIENT:

                return (T) new PatientBOImpl();
            default:
                return null;
        }
    }

}
