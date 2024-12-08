/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import RSA.EncryptionPublic;
import RSA.EncryptionPrivate;
import RSA.KeyGenerator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utils.AppColors;
import utils.FontAwesomeIcons;

public class Main extends javax.swing.JFrame {
  private static Main instance;
  private Main() {
    initComponents();
    setLocationRelativeTo(null);
    setLockIcon();
  }
  
  public static Main getInstance() {
    if(instance == null) {
      instance = new Main();
    }
    
    return instance;
  }
  
  private void setLockIcon() {
    this.labelLockIcon.setIcon(FontAwesomeIcons.getLock(labelLockIcon.getWidth()));
    this.BtnGenerateKey.setBackground(AppColors.getSECONDARY_COLOR());
    this.BtnPrivate.setBackground(AppColors.getSECONDARY_COLOR());
    this.BtnPublic.setBackground(AppColors.getSECONDARY_COLOR());
    this.BtnGenerateKey.setForeground(AppColors.getWHITE_COLOR());
    this.BtnPrivate.setForeground(AppColors.getWHITE_COLOR());
    this.BtnPublic.setForeground(AppColors.getWHITE_COLOR());
  }
  
  private void writeMessageOnFile (String fileName, String message) throws IOException {
    File file = new File(fileName);
            
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
      writer.write(message);
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

        PanelMain = new javax.swing.JPanel();
        LabelOption = new javax.swing.JLabel();
        labelLockIcon = new javax.swing.JLabel();
        LabelTitle = new javax.swing.JLabel();
        BtnGenerateKey = new javax.swing.JButton();
        BtnPrivate = new javax.swing.JButton();
        BtnPublic = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelOption.setBackground(new java.awt.Color(255, 255, 255));
        LabelOption.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        LabelOption.setForeground(new java.awt.Color(0, 153, 255));
        LabelOption.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelOption.setText("Selecciona una opción");
        PanelMain.add(LabelOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 220, 50));
        PanelMain.add(labelLockIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 100, 110));

        LabelTitle.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitle.setText("Cifrado RSA");
        PanelMain.add(LabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 220, 50));

        BtnGenerateKey.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnGenerateKey.setText("Generar Llaves");
        BtnGenerateKey.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnGenerateKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGenerateKeyActionPerformed(evt);
            }
        });
        PanelMain.add(BtnGenerateKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 370, 40));

        BtnPrivate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnPrivate.setText("Firma");
        BtnPrivate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnPrivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrivateActionPerformed(evt);
            }
        });
        PanelMain.add(BtnPrivate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 370, 40));

        BtnPublic.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnPublic.setText("Cifrado");
        BtnPublic.setActionCommand("Cifrado");
        BtnPublic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnPublic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPublicActionPerformed(evt);
            }
        });
        PanelMain.add(BtnPublic, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 370, 40));

        getContentPane().add(PanelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 510, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void BtnGenerateKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGenerateKeyActionPerformed
    String userInput = JOptionPane.showInputDialog(rootPane, "Ingresar nombre:");
    if(userInput != null && !userInput.trim().isEmpty()) {
      KeyGenerator keyGen = new KeyGenerator();
      try {
        keyGen.generateAndSaveKeys(userInput);
        JOptionPane.showMessageDialog(rootPane, "Llaves generadas correctamente.\n" +
            "Archivos:\n" + userInput.trim() + "_publicKey\n" + userInput.trim() + "_privateKey");
      } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Ocurrió un error al generar las llaves:\n" + e.getMessage(), 
          "Error", JOptionPane.ERROR_MESSAGE);
          e.printStackTrace(); // Para depuración (opcional)
      }
    }
    
    else {
      JOptionPane.showMessageDialog(rootPane, "No se ingresó un nombre válido", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_BtnGenerateKeyActionPerformed

  private void BtnPrivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrivateActionPerformed
    String[] options = {"Cifrar", "Descifrar", "Cancelar"};
    int choice = JOptionPane.showOptionDialog(
      rootPane, 
      "¿Qué desea realizar con la llave privada?", 
      "Seleccione una acción", 
      JOptionPane.DEFAULT_OPTION, 
      JOptionPane.QUESTION_MESSAGE, 
      null, 
      options, 
      options[0]
    );
    
    EncryptionPrivate crypto = new EncryptionPrivate();
    switch (choice) {
      case 0: // Opción cifrar
        JFileChooser fileChooserEncrypt = new JFileChooser();
        fileChooserEncrypt.setDialogTitle("Selecciona el archivo con el texto a cifrar");

        int userSelectionEncrypt = fileChooserEncrypt.showOpenDialog(rootPane);
        if (userSelectionEncrypt == JFileChooser.APPROVE_OPTION) {
            File selectedFileEncrypt = fileChooserEncrypt.getSelectedFile();
            try {
                // Leer el contenido del archivo seleccionado
                String message = new String(Files.readAllBytes(selectedFileEncrypt.toPath()), StandardCharsets.UTF_8);

                if (!message.trim().isEmpty()) {
                    // Cifrar el mensaje
                    String encryptedMessage = crypto.encryptWithPrivateKey(message);

                    // Guardar el mensaje cifrado en un archivo
                    writeMessageOnFile("mensaje_cifrado_privateKey.txt", encryptedMessage);

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(
                        rootPane,
                        "Cifrado correctamente y guardado en 'mensaje_cifrado_privateKey.txt'",
                        "Cifrado Exitoso",
                        JOptionPane.INFORMATION_MESSAGE,
                        FontAwesomeIcons.getSuccess(25)
                    );
                } else {
                    JOptionPane.showMessageDialog(
                        rootPane,
                        "El archivo seleccionado está vacío.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                    );
                }
            } catch (Exception e) {
                // Manejo de errores
                JOptionPane.showMessageDialog(
                    rootPane,
                    "Error al cifrar el mensaje: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                rootPane,
                "No se seleccionó ningún archivo.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
            );
        }
        break;

    case 1: // Opción descifrar
        JFileChooser fileChooserDecrypt = new JFileChooser();
        fileChooserDecrypt.setDialogTitle("Selecciona el archivo a descifrar");

        int userSelectionDecrypt = fileChooserDecrypt.showOpenDialog(rootPane);
        if (userSelectionDecrypt == JFileChooser.APPROVE_OPTION) {
            File selectedFileDecrypt = fileChooserDecrypt.getSelectedFile();
            try {
                // Leer el contenido del archivo seleccionado
                String encryptedMessage = new String(Files.readAllBytes(selectedFileDecrypt.toPath()), StandardCharsets.UTF_8);

                // Desencriptar el mensaje
                System.out.println(encryptedMessage);
                String decryptedMessage = crypto.decryptWithPublicKey(encryptedMessage);

                // Guardar el mensaje descifrado en un archivo
                writeMessageOnFile("mensaje_descifrado_publicKey.txt", decryptedMessage);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(
                    rootPane,
                    "Descifrado correctamente y guardado en 'mensaje_descifrado_publicKey.txt'",
                    "Descifrado Exitoso",
                    JOptionPane.INFORMATION_MESSAGE,
                    FontAwesomeIcons.getSuccess(25)
                );
            } catch (Exception e) {
                // Manejo de errores
                JOptionPane.showMessageDialog(
                    rootPane,
                    "Error al descifrar el mensaje: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                rootPane,
                "No se seleccionó ningún archivo.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
            );
        }
        break;
        
      default:
        throw new AssertionError();
    }
  }//GEN-LAST:event_BtnPrivateActionPerformed

    private void BtnPublicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPublicActionPerformed
        String[] options = {"Cifrar", "Descifrar", "Cancelar"};
        int choice = JOptionPane.showOptionDialog(
            rootPane, 
            "¿Qué desea realizar con la llave pública?", 
            "Seleccione una acción", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            options, 
            options[0]
        );

        EncryptionPublic crypto = new EncryptionPublic();

        switch (choice) {
            case 0: // Cifrar
                JFileChooser fileChooserEncrypt = new JFileChooser();
                fileChooserEncrypt.setDialogTitle("Seleccione el archivo con el texto a cifrar");

                int resultEncrypt = fileChooserEncrypt.showOpenDialog(rootPane);
                if (resultEncrypt == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooserEncrypt.getSelectedFile();
                    try {
                        // Leer el contenido del archivo seleccionado
                        String message = new String(Files.readAllBytes(selectedFile.toPath()), StandardCharsets.UTF_8);
                        
                        if (!message.trim().isEmpty()) {
                            // Cifrar el mensaje
                            String encryptedMessage = crypto.encryptWithPublicKey(message);
                            // Guardar el mensaje cifrado en un archivo
                            String filename = selectedFile.getName();
                            String filenameWithoutExtension = filename.substring(0, filename.lastIndexOf('.'));

                            writeMessageOnFile(filenameWithoutExtension + "RSAc.txt", encryptedMessage);

                            JOptionPane.showMessageDialog(rootPane, "Cifrado correctamente y guardado en 'mensaje_cifrado_publicKey.txt'", "Cifrado Exitoso", JOptionPane.INFORMATION_MESSAGE, FontAwesomeIcons.getSuccess(25));
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "El archivo seleccionado está vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, "Error al cifrar el mensaje: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;

            case 1: // Descifrar
                JFileChooser fileChooserDecrypt = new JFileChooser();
                fileChooserDecrypt.setDialogTitle("Seleccione el archivo con el texto cifrado");

                int resultDecrypt = fileChooserDecrypt.showOpenDialog(rootPane);
                if (resultDecrypt == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooserDecrypt.getSelectedFile();
                    try {
                        // Leer el contenido del archivo seleccionado
                        String encryptedMessage = new String(Files.readAllBytes(selectedFile.toPath()), StandardCharsets.UTF_8);

                        if (!encryptedMessage.trim().isEmpty()) {
                            // Descifrar el mensaje
                            String decryptedMessage = crypto.decryptWithPrivateKey(encryptedMessage);

                            // Guardar el mensaje descifrado en un archivo
                            String filename = selectedFile.getName();
                            String filenameWithoutExtension = filename.substring(0, filename.lastIndexOf('.'));

                            writeMessageOnFile(filenameWithoutExtension + "RSA.txt", decryptedMessage);

                            JOptionPane.showMessageDialog(rootPane, "Descifrado correctamente y guardado en " + filename, "Descifrado Exitoso", JOptionPane.INFORMATION_MESSAGE, FontAwesomeIcons.getSuccess(25));
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "El archivo seleccionado está vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, "Error al descifrar el mensaje: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;

            default:
                throw new AssertionError();
        }
        
    }//GEN-LAST:event_BtnPublicActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Main().setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGenerateKey;
    private javax.swing.JButton BtnPrivate;
    private javax.swing.JButton BtnPublic;
    private javax.swing.JLabel LabelOption;
    private javax.swing.JLabel LabelTitle;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JLabel labelLockIcon;
    // End of variables declaration//GEN-END:variables
}
