/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.sliit.iblood.main;

import lk.sliit.iblood.common.OptionPane;
import lk.sliit.iblood.common.strings.Strings;
import lk.sliit.iblood.view_controller.MainMenu;

import javax.swing.*;
import java.io.IOException;

/**
 * @author pandu
 */
public class Main {
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            try {
                JFrame main = new MainMenu();
                main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                Strings.loadStrings();
                main.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
