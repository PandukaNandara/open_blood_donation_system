/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.sliit.iblood.view_controller;

import lk.sliit.iblood.business.BOFactory;
import lk.sliit.iblood.business.BOType;
import lk.sliit.iblood.business.custom.NurseBO;
import lk.sliit.iblood.common.OptionPane;
import lk.sliit.iblood.common.Tools;
import lk.sliit.iblood.common.ValidationException;
import lk.sliit.iblood.common.Validator;
import lk.sliit.iblood.common.strings.Strings;
import lk.sliit.iblood.model.NurseDTO;

import javax.swing.table.DefaultTableModel;
import java.util.NoSuchElementException;

/**
 * @author pandu
 */
public class NursePanel extends javax.swing.JPanel {

    private NurseBO nurseBO = BOFactory.getInstance().getBO(BOType.NURSE);

    public NursePanel() {
        initComponents();
        loadNurseList();
    }

    private void loadNurseList() {
        try {
            Tools.removeRowsFromJTable((DefaultTableModel) tblNurse.getModel());
            nurseBO.getAllNurses().forEach(nurseDTO ->
                    ((DefaultTableModel) tblNurse.getModel()).addRow(nurseDTO.toStringArray())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHead = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        txtFName = new javax.swing.JTextField();
        dateDOB = new datechooser.beans.DateChooserCombo();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtService = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaAddress = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNurse = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtLName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setPreferredSize(new java.awt.Dimension(1024, 768));

        lblHead.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblHead.setText("Nurse");

        btnSearch.setBackground(new java.awt.Color(51, 51, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/sliit/iblood/assets/Search_15px.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setMaximumSize(new java.awt.Dimension(87, 23));
        btnSearch.setMinimumSize(new java.awt.Dimension(87, 23));
        btnSearch.setPreferredSize(new java.awt.Dimension(87, 23));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFNameActionPerformed(evt);
            }
        });

        dateDOB.setFormat(2);

        jLabel2.setText("Id<Auto generate>:");

        jLabel3.setText("First name:");

        jLabel5.setText("Address:");

        jLabel4.setText("Birthday:");

        txtaAddress.setColumns(20);
        txtaAddress.setRows(5);
        jScrollPane1.setViewportView(txtaAddress);

        jLabel6.setText("Service:");

        btnSave.setBackground(new java.awt.Color(51, 255, 51));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/sliit/iblood/assets/Save_15px.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setMaximumSize(new java.awt.Dimension(87, 23));
        btnSave.setMinimumSize(new java.awt.Dimension(87, 23));
        btnSave.setPreferredSize(new java.awt.Dimension(87, 23));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 153, 0));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/sliit/iblood/assets/Update_15px.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/sliit/iblood/assets/Delete_15px.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMaximumSize(new java.awt.Dimension(87, 23));
        btnDelete.setMinimumSize(new java.awt.Dimension(87, 23));
        btnDelete.setPreferredSize(new java.awt.Dimension(87, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tblNurse.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Nurse Id", "First Name", "Last Name", "Date of birth", "Address", "Service"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblNurse.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(tblNurse);

        jLabel7.setText("Last name:");

        txtLName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(lblHead))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel3)
                                                                .addComponent(jLabel4)
                                                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(jLabel7))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(dateDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                                                .addComponent(txtFName, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(txtService, javax.swing.GroupLayout.Alignment.LEADING))
                                                        .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnUpdate)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
                                                .addComponent(jSeparator1)))
                                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lblHead)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dateDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtService, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnUpdate)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            if (isTxtIdIsNotEmpty()) {
                NurseDTO nurseDTO = nurseBO.searchNurse(txtId.getText().trim());
                setOnTextFields(nurseDTO);
            }
        } catch (NullPointerException e) {
            OptionPane.showNotDone(Strings.MESSAGE_PROBLEM_CANNOT_FIND_RECORD);
        } catch (Exception e) {
            OptionPane.showError(Strings.MESSAGE_ERROR_OCCURRED_BY_EXCEPTION_WHEN_FETCHING_VALUES);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private boolean isTxtIdIsNotEmpty() {
        if (!Validator.isInteger(txtId.getText())) {
            OptionPane.showError(Strings.MESSAGE_PROBLEM_PLEASE_FILL_ID);
            return false;
        } else return true;
    }

    private void setOnTextFields(NurseDTO dto) {
        txtId.setText(dto.getNurseId().toString());
        txtFName.setText(dto.getNurseFName());
        txtLName.setText(dto.getNurseLName());
        dateDOB.setSelectedDate(Tools.toCalendar(dto.getNurseDOB()));
        txtaAddress.setText(dto.getNurseAddress());
        txtService.setText(dto.getService());
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            NurseDTO validate = new NurseDTO(
                    txtFName.getText(),
                    txtLName.getText(),
                    txtService.getText(),
                    dateDOB.getSelectedDate().getTime(),
                    txtaAddress.getText()

            ).validateAndReturn();

            if (OptionPane.confirmAsInfo(Strings.ASK_SHOULD_VALUES_BE_ADDED).equals(OptionPane.YES) &&
                    nurseBO.saveNurse(validate)) {
                OptionPane.showDoneMessage(Strings.MESSAGE_SUCCESSFULLY_ADDED_VALUE);
                loadNurseList();
                clearAllTextFields();
            }

        } catch (ValidationException e) {
            OptionPane.showNotDone(e.getMessage());
        } catch (Exception e) {
            OptionPane.showError(Strings.MESSAGE_PROBLEM_OCCURRED_BY_EXCEPTION_WHEN_ADDING_VALUES);
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void clearAllTextFields() {
        Tools.clearTextOfJTextField(txtFName, txtId, txtLName, txtService, txtaAddress);
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {

            NurseDTO validate = new NurseDTO(
                    txtId.getText(),
                    txtFName.getText(),
                    txtLName.getText(),
                    txtService.getText(),
                    dateDOB.getSelectedDate().getTime(),
                    txtaAddress.getText()
            ).validateWithPKeyAndReturn();

            nurseBO.searchNurse(txtId.getText());
            clearAllTextFields();
            if (OptionPane.confirmAsInfo(Strings.ASK_SHOULD_VALUES_BE_UPDATED).equals(OptionPane.YES) &&
                    nurseBO.updateNurse(validate)) {
                OptionPane.showDoneMessage(Strings.MESSAGE_SUCCESSFULLY_ADDED_VALUE);
                loadNurseList();
            }

        } catch (NoSuchElementException e) {
            OptionPane.showNotDone(Strings.MESSAGE_PROBLEM_NO_SUCH_ELEMENT_WITH_ID);
        } catch (ValidationException e) {
            OptionPane.showNotDone(e.getMessage());
        } catch (Exception e) {
            OptionPane.showError(Strings.MESSAGE_PROBLEM_OCCURRED_BY_EXCEPTION_WHEN_ADDING_VALUES);
            e.printStackTrace();

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            if (isTxtIdIsNotEmpty()) {
                Integer nurseId = nurseBO.searchNurse(txtId.getText()).getNurseId();
                if (OptionPane.confirmAsInfo(Strings.ASK_SHOULD_VALUES_BE_DELETED).equals(OptionPane.YES) &&
                        nurseBO.deleteNurse(nurseId)) {
                    OptionPane.showDoneMessage(Strings.MESSAGE_SUCCESSFULLY_DELETED_VALUE);
                    clearAllTextFields();
                    loadNurseList();
                }
            }
        } catch (NoSuchElementException e) {
            OptionPane.showNotDone(Strings.MESSAGE_PROBLEM_NO_SUCH_ELEMENT_WITH_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtLNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLNameActionPerformed

    private void txtFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private datechooser.beans.DateChooserCombo dateDOB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHead;
    private javax.swing.JTable tblNurse;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtService;
    private javax.swing.JTextArea txtaAddress;
    // End of variables declaration//GEN-END:variables
}
