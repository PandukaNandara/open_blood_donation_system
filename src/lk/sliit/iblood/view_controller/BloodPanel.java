/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.sliit.iblood.view_controller;

import lk.sliit.iblood.business.BOFactory;
import lk.sliit.iblood.business.BOType;
import lk.sliit.iblood.business.custom.BloodBO;
import lk.sliit.iblood.business.custom.DoctorBO;
import lk.sliit.iblood.business.custom.DonorBO;
import lk.sliit.iblood.business.custom.NurseBO;
import lk.sliit.iblood.common.OptionPane;
import lk.sliit.iblood.common.Tools;
import lk.sliit.iblood.common.ValidationException;
import lk.sliit.iblood.common.Validator;
import lk.sliit.iblood.common.strings.Strings;
import lk.sliit.iblood.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author pandu
 */
public class BloodPanel extends javax.swing.JPanel implements SuperController {
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDoctor;
    private javax.swing.JButton btnAddNurse;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInformPatient;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearchDoctor;
    private javax.swing.JButton btnSearchDonation;
    private javax.swing.JButton btnSearchDonor;
    private javax.swing.JButton btnSearchNurse;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblHead;
    private javax.swing.JLabel lblHead1;
    private javax.swing.JLabel lblHead2;
    private javax.swing.JTable tblDoctorList;
    private javax.swing.JTable tblDonations;
    private javax.swing.JTable tblDonor;
    private javax.swing.JTable tblNurseList;
    private javax.swing.JTextArea txtDefection;
    private javax.swing.JTextField txtDoctorId;
    private javax.swing.JTextField txtDoctorName;
    private javax.swing.JTextField txtDonationId;
    private javax.swing.JTextField txtDonorId;
    private javax.swing.JTextField txtHemoglobin;
    private javax.swing.JTextField txtNurseId;
    private javax.swing.JTextField txtNurseName;
    // End of variables declaration//GEN-END:variables

    private DonorBO donorBO = BOFactory.getInstance().getBO(BOType.DONOR);
    private DoctorBO doctorBO = BOFactory.getInstance().getBO(BOType.DOCTOR);


    private BloodBO bloodBO = BOFactory.getInstance().getBO(BOType.BLOOD);
    private NurseBO nurseBO = BOFactory.getInstance().getBO(BOType.NURSE);
    private NurseDTO selectedNurse;
    private DonorDTO selectedDonor;
    private DoctorDTO selectedDoctor;
    private ArrayList<DoctorContributionDTO> doctorList = new ArrayList<>();
    private ArrayList<NurseContributionDTO> nurseList = new ArrayList<>();

    // TODO later we will utilize
//    private void setOnTextFields(DonorDTO dto) {
//        txtDonationId.setText(dto.getDonorId().toString());
//        txtPateintId.setText(dto.getDonorFName());
//        txtHemoglobin.setText(dto.getDonorLName());
//        dateDOB.setSelectedDate(Tools.toCalendar(dto.getDonorDOB()));
//        txtaAddress.setText(dto.getDonorAddress());
//        txtEmail.setText(dto.getDonorEmail());
//        txtMobile.setText(dto.getDonorMobile());
//        txtNIC.setText(dto.getDonorNIC());
//    }

    public BloodPanel() {
        initComponents();
        System.out.println("Passed");
        try {
            loadDonationList();
        } catch (Exception e) {
            callLogger(e);
        }

    }

    private void loadDonationList() throws Exception {

        bloodBO.getAllBloodDonationWithDonorsAndPatients().forEach(bloodDTO -> {
                    ((DefaultTableModel) tblDonations.getModel()).addRow(bloodDTO.toStringArrayWithDonorAndPatient());
                    System.out.println(Arrays.toString(bloodDTO.toStringArrayWithDonorAndPatient()));
                }
        );
    }

    private boolean isTxtIdIsNotEmpty() {
        if (!Validator.isInteger(txtDonationId.getText())) {
            OptionPane.showError(Strings.MESSAGE_PROBLEM_PLEASE_FILL_ID);
            return false;
        } else return true;
    }

    private void clearAllTextFields() {
        Tools.clearTextOfJTextField(txtDonorId, txtDonationId,
                txtHemoglobin, txtDefection,
                txtDoctorId, txtDoctorName,
                txtNurseId, txtNurseName);
        selectedDoctor = null;
        selectedNurse = null;
    }

    private void txtHemoglobinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHemoglobinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHemoglobinActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
//        try {
//            if (isTxtIdIsNotEmpty()) {
//                Integer donorId = donorBO.searchDonor(txtDonationId.getText()).getDonorId();
//                if (OptionPane.confirmAsInfo(Strings.ASK_SHOULD_VALUES_BE_DELETED).equals(OptionPane.YES) &&
//                        donorBO.deleteDonor(donorId)) {
//                    OptionPane.showDoneMessage(Strings.MESSAGE_SUCCESSFULLY_DELETED_VALUE);
//                    clearAllTextFields();
//                    loadDonorList();
//                }
//            }
//        } catch (NoSuchElementException e) {
//            OptionPane.showNotDone(Strings.MESSAGE_PROBLEM_NO_SUCH_ELEMENT_WITH_ID);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
//        try {
//            BloodDTO validate = new BloodDTO(
//                    txtDonationId.getText(),
//                    txtDonorId.getText(),
//                    txtHemoglobin.getText(),
//                    txtNIC.getText(),
//                    dateDOB.getSelectedDate().getTime(),
//                    (Gender) comboGender.getSelectedItem(),
//                    txtaAddress.getText(),
//                    txtEmail.getText(),
//                    txtMobile.getText(),
//                    (BloodGroupDTO) comboBloodType.getSelectedItem()
//            ).validateWithPKeyAndReturn();
//
//            donorBO.searchDonor(txtDonationId.getText());
//            clearAllTextFields();
//            if (OptionPane.confirmAsInfo(Strings.ASK_SHOULD_VALUES_BE_UPDATED).equals(OptionPane.YES) &&
//                    donorBO.updateDonor(validate)) {
//                OptionPane.showDoneMessage(Strings.MESSAGE_SUCCESSFULLY_ADDED_VALUE);
//                loadDonorList();
//            }
//
//        } catch (NoSuchElementException e) {
//            OptionPane.showNotDone(Strings.MESSAGE_PROBLEM_NO_SUCH_ELEMENT_WITH_ID);
//        } catch (ValidationException e) {
//            OptionPane.showNotDone(e.getMessage());
//        } catch (Exception e) {
//            OptionPane.showError(Strings.MESSAGE_PROBLEM_OCCURRED_BY_EXCEPTION_WHEN_ADDING_VALUES);
//            e.printStackTrace();
//
//        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            BloodDTO validate = new BloodDTO(
                    txtHemoglobin.getText(),
                    txtDefection.getText(),
                    selectedDonor,
                    doctorList,
                    nurseList
            ).validateAndReturn();

            if (OptionPane.confirmAsInfo(Strings.ASK_SHOULD_VALUES_BE_ADDED).equals(OptionPane.YES) &&
                    bloodBO.saveBloodDonation(validate)) {
                OptionPane.showDoneMessage(Strings.MESSAGE_SUCCESSFULLY_ADDED_VALUE);
                clearAllTextFields();
            }

        } catch (ValidationException e) {
            OptionPane.showNotDone(e.getMessage());
        } catch (Exception e) {
            OptionPane.showError(Strings.MESSAGE_PROBLEM_OCCURRED_BY_EXCEPTION_WHEN_ADDING_VALUES);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtDonorIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonorIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonorIdActionPerformed

    private void btnSearchDonationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDonationActionPerformed
        doctorList.clear();
        nurseList.clear();
        clearAllTables();

        try {
            if (isTxtIdIsNotEmpty()) {
                BloodDTO bloodDTO = bloodBO.searchBloodDonationWithDetails(txtDonationId.getText().trim());
                ((DefaultTableModel) tblDonor.getModel()).addRow(bloodDTO.getDonorDTO().toStringArray());
                bloodDTO.getNurseList().forEach(nurseContributionDTO ->
                        ((DefaultTableModel) tblNurseList.getModel()).addRow(nurseContributionDTO.toStringArrayNurseName())
                );

                bloodDTO.getDoctorList().forEach(doctorContributionDTO ->
                        ((DefaultTableModel) tblDoctorList.getModel()).addRow(doctorContributionDTO.toStringArrayDoctorName())
                );
            }
        } catch (NullPointerException e) {
            OptionPane.showNotDone(Strings.MESSAGE_PROBLEM_CANNOT_FIND_RECORD);
            e.printStackTrace();
        } catch (Exception e) {
            OptionPane.showError(Strings.MESSAGE_ERROR_OCCURRED_BY_EXCEPTION_WHEN_FETCHING_VALUES);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSearchDonationActionPerformed

    private void clearAllTables() {
        JTable[] tbls = {tblNurseList, tblDonor, tblDoctorList, tblDonations};
        for (JTable tbl : tbls)
            Tools.removeRowsFromJTable((DefaultTableModel) tbl.getModel());
    }

    private void btnSearchDonorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDonorActionPerformed
        String id = txtDonorId.getText();
        if (!Validator.isInteger(id))
            OptionPane.showError(Strings.MESSAGE_ERROR_ID_IS_INVALID);
        else {
            try {
                DonorDTO donorDTO = donorBO.searchDonor(id);
                if (Objects.isNull(donorDTO))
                    throw new NullPointerException();

                selectedDonor = donorDTO;
                Tools.removeRowsFromJTable(((DefaultTableModel) tblDonor.getModel()));
                ((DefaultTableModel) tblDonor.getModel()).addRow(
                        selectedDonor.toStringArray()
                );
            } catch (NullPointerException e) {
                OptionPane.showError(Strings.MESSAGE_PROBLEM_NO_SUCH_ELEMENT_WITH_ID);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnSearchDonorActionPerformed

    private void txtDoctorIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoctorIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDoctorIdActionPerformed

    private void btnSearchDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDoctorActionPerformed
        String id = txtDoctorId.getText();
        if (!Validator.isInteger(id))
            OptionPane.showError(Strings.MESSAGE_ERROR_ID_IS_INVALID);
        else {
            try {
                String nameOfDoctor = doctorBO.getNameOfDoctor(id);

                txtDoctorName.setText(nameOfDoctor);
                selectedDoctor = doctorBO.searchDoctor(id);

            } catch (NullPointerException e) {
                OptionPane.showError(Strings.MESSAGE_PROBLEM_NO_SUCH_ELEMENT_WITH_ID);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSearchDoctorActionPerformed

    private void txtDoctorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoctorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDoctorNameActionPerformed

    private void btnAddDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDoctorActionPerformed
        DoctorContributionDTO docContribution = new DoctorContributionDTO(selectedDoctor, true);

        ((DefaultTableModel) tblDoctorList.getModel())
                .addRow(docContribution.toStringArrayDoctorName());

        doctorList.add(docContribution);
    }//GEN-LAST:event_btnAddDoctorActionPerformed

    private void txtNurseIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNurseIdActionPerformed

    }//GEN-LAST:event_txtNurseIdActionPerformed

    private void btnSearchNurseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchNurseActionPerformed
        String id = txtNurseId.getText();
        if (!Validator.isInteger(id))
            OptionPane.showError(Strings.MESSAGE_ERROR_ID_IS_INVALID);
        else {
            try {
                String nameOfNurse = nurseBO.getNameOfNurse(id);
                txtNurseName.setText(nameOfNurse);
                selectedNurse = nurseBO.searchNurse(id);

            } catch (NullPointerException e) {
                OptionPane.showError(Strings.MESSAGE_PROBLEM_NO_SUCH_ELEMENT_WITH_ID);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSearchNurseActionPerformed

    private void txtNurseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNurseNameActionPerformed

    }//GEN-LAST:event_txtNurseNameActionPerformed

    private void btnAddNurseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNurseActionPerformed
        NurseContributionDTO nurseContribution = new NurseContributionDTO(selectedNurse, true);

        ((DefaultTableModel) tblNurseList.getModel())
                .addRow(nurseContribution.toStringArrayNurseName());

        nurseList.add(nurseContribution);
    }//GEN-LAST:event_btnAddNurseActionPerformed

    private void btnInformPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformPatientActionPerformed
        String defectionText = txtDefection.getText();

        if (Validator.isNullOrEmpty(defectionText)) {
            OptionPane.showNotDone("Please specify a defection.");
        }else {

            Tools.openMailApp(
                    selectedDonor.getDonorEmail(),
                    "About defection problem of blood.",
                    defectionText
            );

        }

    }//GEN-LAST:event_btnInformPatientActionPerformed


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHead = new javax.swing.JLabel();
        txtDonationId = new javax.swing.JTextField();
        btnSearchDonation = new javax.swing.JButton();
        txtDonorId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDonor = new javax.swing.JTable();
        txtHemoglobin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnSearchDonor = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDefection = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        lblHead1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDoctorList = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtDoctorId = new javax.swing.JTextField();
        btnSearchDoctor = new javax.swing.JButton();
        txtDoctorName = new javax.swing.JTextField();
        btnAddDoctor = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblHead2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNurseId = new javax.swing.JTextField();
        btnSearchNurse = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtNurseName = new javax.swing.JTextField();
        btnAddNurse = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblNurseList = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDonations = new javax.swing.JTable();
        btnInformPatient = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setPreferredSize(new java.awt.Dimension(1024, 768));

        lblHead.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblHead.setText("Donation");

        btnSearchDonation.setBackground(new java.awt.Color(51, 51, 255));
        btnSearchDonation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/sliit/iblood/assets/Search_15px.png"))); // NOI18N
        btnSearchDonation.setText("Search");
        btnSearchDonation.setMaximumSize(new java.awt.Dimension(87, 23));
        btnSearchDonation.setMinimumSize(new java.awt.Dimension(87, 23));
        btnSearchDonation.setPreferredSize(new java.awt.Dimension(87, 23));
        btnSearchDonation.addActionListener(this::btnSearchDonationActionPerformed);

        txtDonorId.addActionListener(this::txtDonorIdActionPerformed);

        jLabel2.setText("Donation Id<Auto generate>:");

        jLabel3.setText("Donor ID");

        btnSave.setBackground(new java.awt.Color(51, 255, 51));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/sliit/iblood/assets/Save_15px.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setMaximumSize(new java.awt.Dimension(87, 23));
        btnSave.setMinimumSize(new java.awt.Dimension(87, 23));
        btnSave.setPreferredSize(new java.awt.Dimension(87, 23));
        btnSave.addActionListener(this::btnSaveActionPerformed);

        btnUpdate.setBackground(new java.awt.Color(255, 153, 0));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/sliit/iblood/assets/Update_15px.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/sliit/iblood/assets/Delete_15px.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMaximumSize(new java.awt.Dimension(87, 23));
        btnDelete.setMinimumSize(new java.awt.Dimension(87, 23));
        btnDelete.setPreferredSize(new java.awt.Dimension(87, 23));
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        tblDonor.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Donor ID", "First Name", "Last Name", "NIC number", "Date of birth", "Gender", "Mobile", "Email", "Address", "Blood type", "Regi. date", "Regi. time"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblDonor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(tblDonor);

        txtHemoglobin.addActionListener(this::txtHemoglobinActionPerformed);

        jLabel8.setText("Hemoglobin");

        btnSearchDonor.setBackground(new java.awt.Color(51, 51, 255));
        btnSearchDonor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/sliit/iblood/assets/Search_15px.png"))); // NOI18N
        btnSearchDonor.setText("Search Donor");
        btnSearchDonor.setMaximumSize(new java.awt.Dimension(87, 23));
        btnSearchDonor.setMinimumSize(new java.awt.Dimension(87, 23));
        btnSearchDonor.setPreferredSize(new java.awt.Dimension(87, 23));
        btnSearchDonor.addActionListener(this::btnSearchDonorActionPerformed);

        txtDefection.setColumns(20);
        txtDefection.setRows(5);
        jScrollPane3.setViewportView(txtDefection);

        jLabel9.setText("Defection");

        lblHead1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHead1.setText("Doctor's contribution");

        tblDoctorList.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Doctor Id", "Name"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblDoctorList);

        jLabel10.setText("Doctor Id");

        txtDoctorId.addActionListener(this::txtDoctorIdActionPerformed);

        btnSearchDoctor.setBackground(new java.awt.Color(51, 51, 255));
        btnSearchDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/sliit/iblood/assets/Search_15px.png"))); // NOI18N
        btnSearchDoctor.setText("Search Doctor to add");
        btnSearchDoctor.setMaximumSize(new java.awt.Dimension(87, 23));
        btnSearchDoctor.setMinimumSize(new java.awt.Dimension(87, 23));
        btnSearchDoctor.setPreferredSize(new java.awt.Dimension(87, 23));
        btnSearchDoctor.addActionListener(this::btnSearchDoctorActionPerformed);

        txtDoctorName.setEditable(false);
        txtDoctorName.addActionListener(this::txtDoctorNameActionPerformed);

        btnAddDoctor.setText("Add Doctor");
        btnAddDoctor.addActionListener(this::btnAddDoctorActionPerformed);

        jLabel12.setText("Doctor name:");

        lblHead2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHead2.setText("Nurse's contribution");

        jLabel13.setText("Nurse Id");

        txtNurseId.addActionListener(this::txtNurseIdActionPerformed);

        btnSearchNurse.setBackground(new java.awt.Color(51, 51, 255));
        btnSearchNurse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/sliit/iblood/assets/Search_15px.png"))); // NOI18N
        btnSearchNurse.setText("Search Nurse to add");
        btnSearchNurse.setMaximumSize(new java.awt.Dimension(87, 23));
        btnSearchNurse.setMinimumSize(new java.awt.Dimension(87, 23));
        btnSearchNurse.setPreferredSize(new java.awt.Dimension(87, 23));
        btnSearchNurse.addActionListener(this::btnSearchNurseActionPerformed);

        jLabel14.setText("Nurse name:");

        txtNurseName.setEditable(false);
        txtNurseName.addActionListener(this::txtNurseNameActionPerformed);

        btnAddNurse.setText("Add Nurse");
        btnAddNurse.setMaximumSize(new java.awt.Dimension(87, 23));
        btnAddNurse.setMinimumSize(new java.awt.Dimension(87, 23));
        btnAddNurse.setPreferredSize(new java.awt.Dimension(87, 23));
        btnAddNurse.addActionListener(this::btnAddNurseActionPerformed);

        tblNurseList.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Nurse Id", "Name"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblNurseList);

        tblDonations.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Donation ID", "Hemoglobin", "Defection", "Donor ID", "Donor Name", "Pateint Id", "Pateint Name"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDonations);
        if (tblDonations.getColumnModel().getColumnCount() > 0) {
            tblDonations.getColumnModel().getColumn(0).setResizable(false);
            tblDonations.getColumnModel().getColumn(1).setResizable(false);
            tblDonations.getColumnModel().getColumn(2).setResizable(false);
            tblDonations.getColumnModel().getColumn(3).setResizable(false);
            tblDonations.getColumnModel().getColumn(4).setResizable(false);
            tblDonations.getColumnModel().getColumn(5).setResizable(false);
            tblDonations.getColumnModel().getColumn(6).setResizable(false);
        }

        btnInformPatient.setBackground(new java.awt.Color(255, 153, 0));
        btnInformPatient.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnInformPatient.setText("Inform pateint");
        btnInformPatient.setMaximumSize(new java.awt.Dimension(87, 23));
        btnInformPatient.setMinimumSize(new java.awt.Dimension(87, 23));
        btnInformPatient.setPreferredSize(new java.awt.Dimension(87, 23));
        btnInformPatient.addActionListener(this::btnInformPatientActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane5)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(lblHead))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(txtDonationId, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(btnSearchDonation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(txtDonorId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(btnSearchDonor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jScrollPane2)
                                                                .addComponent(jScrollPane4)
                                                                .addComponent(lblHead1)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel8)
                                                                                .addComponent(jLabel9))
                                                                        .addGap(55, 55, 55)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(txtHemoglobin, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                        .addComponent(btnInformPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel10)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(txtDoctorId, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btnSearchDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jLabel12)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(txtDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btnAddDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(lblHead2)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel13)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtNurseId, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnSearchNurse, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel14)
                                                                .addGap(8, 8, 8)
                                                                .addComponent(txtNurseName, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnAddNurse, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnUpdate)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lblHead)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDonationId, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearchDonation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDonorId, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(btnSearchDonor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(txtHemoglobin, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel9)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(btnInformPatient, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblHead1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(txtDoctorId, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearchDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddDoctor)
                                        .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblHead2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(txtNurseId, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearchNurse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNurseName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddNurse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
        );
    }// </editor-fold>//GEN-END:initComponents

}
