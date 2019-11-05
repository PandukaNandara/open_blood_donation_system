/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.sliit.iblood.dao;


import lk.sliit.iblood.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory dAOFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (dAOFactory == null) {
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOType daoType) {
        switch (daoType) {
            case BLOOD:
                return (T) new BloodDAOImpl();
            case BLOOD_GROUP:
                return (T) new BloodGroupDAOImpl();
            case DOCTOR:
                return (T) new DoctorDAOImpl();
            case DOCTOR_CONTRIBUTION:
                return (T) new DoctorContributionDAOImpl();
            case DONOR:
                return (T) new DonorDAOImpl();
            case NURSE:
                return (T) new NurseDAOImpl();
            case NURSE_CONTRIBUTION:
                return (T) new NurseContributionDAOImpl();
            case PATIENT:
                return (T) new PatientDAOImpl();
            case CUSTOM:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }


}
