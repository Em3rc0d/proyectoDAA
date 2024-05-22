/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_daa.Paneles;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import proyecto_daa.Entidades.Medico;
import proyecto_daa.Entidades.Paciente;
import proyecto_daa.Entidades.Turno;
import proyecto_daa.Gestionadores.*;

/**
 *
 * @author farid
 */
public class panelRegistrarCita extends javax.swing.JFrame {

    GestionadorPaciente arbolPaciente;
    GestionadorMedico arbolMedico;
    GestionadorCitaMedica arbolCita;
    
    public panelRegistrarCita(GestionadorPaciente arbolPaciente, GestionadorMedico arbolMedico, GestionadorCitaMedica arbolCita) {
        this.arbolPaciente = arbolPaciente;
        this.arbolMedico = arbolMedico;
        this.arbolCita = arbolCita;
        initComponents();
        setLocationRelativeTo(null);
        cbMedico.removeAllItems();
        cbPaciente.removeAllItems();
        cbHorarioD.removeAllItems();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbPaciente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbMedico = new javax.swing.JComboBox<>();
        btnRegPaciente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnRegCita = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbHorarioD = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(192, 206, 161));

        jLabel1.setText("Registrar Cita");

        jLabel2.setText("Paciente:");

        cbPaciente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPacienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Medico:");

        cbMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMedicoActionPerformed(evt);
            }
        });

        btnRegPaciente.setText("Registrar Paciente");
        btnRegPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegPacienteActionPerformed(evt);
            }
        });

        jLabel5.setText("Si no encuentra su nombre: ");

        btnRegCita.setText("Registro Cita");
        btnRegCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegCitaActionPerformed(evt);
            }
        });

        txtDetalle.setColumns(20);
        txtDetalle.setRows(5);
        jScrollPane1.setViewportView(txtDetalle);

        jLabel6.setText("Detalle de Cita:");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_daa/Paneles/registroCita.png"))); // NOI18N
        jLabel7.setText("jLabel7");

        jLabel4.setText("Horario Disponible:");

        // cbHorarioD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbHorarioD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHorarioDActionPerformed(evt);
            }
        });

        btnBack.setText("Retornar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(85, 85, 85)
                                .addComponent(btnRegPaciente))
                            .addComponent(jLabel6))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbPaciente, 0, 319, Short.MAX_VALUE)
                    .addComponent(cbMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbHorarioD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbHorarioD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(btnRegPaciente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegCita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegPacienteActionPerformed
        // TODO add your handling code here:
        new panelRegistrarPaciente(arbolPaciente, arbolMedico).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnRegPacienteActionPerformed

    private void btnRegCitaActionPerformed(java.awt.event.ActionEvent evt) {
        // Obtener el objeto seleccionado del JComboBox
        Object selectedPaciente = cbPaciente.getSelectedItem();
        Object selectedMedico = cbMedico.getSelectedItem();
        Object selectedHorario = cbHorarioD.getSelectedItem();
    
        // Verificar que los objetos sean de los tipos esperados
        if (selectedPaciente instanceof Paciente && selectedMedico instanceof Medico && selectedHorario instanceof Date) {
            Paciente paciente = (Paciente) selectedPaciente;
            Medico medico = (Medico) selectedMedico;
            String horario = selectedHorario.toString();
    
            int idCita;
            if (arbolCita.raiz == null) {
                idCita = 1;
            } else {
                idCita = arbolCita.raiz.CitaMedica.getIdCita() + 1;
            }
    
            // Insertar la nueva cita médica
            arbolCita.insertarCitaMedica(idCita, paciente, medico, horario, horario, "Pendiente");
        } else {
            // Manejar el caso en que uno de los objetos no sea del tipo esperado
            System.out.println("Uno o más objetos seleccionados no son del tipo esperado.");
        }
    }
    

    private void cbPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPacienteActionPerformed
        // TODO add your handling code here:
        cbPaciente.removeAllItems();
        String listaPacientes = arbolPaciente.listarPacientes();
        String[] pacientes = listaPacientes.split("\n");
        if (pacientes.length > 0 && !listaPacientes.isEmpty()) {
            for (String paciente : pacientes) {
                if (!paciente.trim().isEmpty()) {
                    try {
                        String[] infoPaciente = paciente.split(", ");
                        String nombre = infoPaciente[0].substring(infoPaciente[0].indexOf('=') + 1).trim();
                        String apellido = infoPaciente[1].substring(infoPaciente[1].indexOf('=') + 1).trim();
                        cbPaciente.addItem(nombre + " " + apellido);
                    } catch (Exception e) {
                        System.out.println("Error al registrar el paciente: " + e.getMessage());
                    }
                }
            }
        }else{
            cbPaciente.addItem("No hay pacientes registrados");
        }
    }//GEN-LAST:event_cbPacienteActionPerformed

    private void cbMedicoActionPerformed(java.awt.event.ActionEvent evt) {
        // Limpiar los elementos existentes en el JComboBox
        cbMedico.removeAllItems();
        // Obtener la lista de médicos como un String
        String listaMedicos = arbolMedico.listarMedicos();
        // Dividir la lista de médicos en un array usando el carácter de nueva línea como delimitador
        String[] medicos = listaMedicos.split("\n");
        if (medicos.length > 0 && !listaMedicos.isEmpty()) {
            // Agregar cada médico (solo nombre, apellido y especialidad) al JComboBox
            for (String medico : medicos) {
                if (!medico.trim().isEmpty()) {
                    try {
                        // Dividir la información del médico en un array usando la coma como delimitador
                        String[] infoMedico = medico.split(", ");
                        // Asegurarse de que el array tiene la cantidad esperada de elementos
                        if (infoMedico.length >= 5) {
                            // Tomar el nombre, apellido y especialidad del médico del array
                            String nombre = infoMedico[0].substring(infoMedico[0].indexOf('=') + 1).trim();
                            String apellido = infoMedico[1].substring(infoMedico[1].indexOf('=') + 1).trim();
                            String especialidad = infoMedico[4].substring(infoMedico[4].indexOf(':') + 2).trim(); // Cambiar el índice de inicio para especialidad
                            // Agregar el nombre, apellido y especialidad al JComboBox
                            cbMedico.addItem(nombre + " " + apellido + " - " + especialidad);
                        }
                    } catch (Exception e) {
                        System.out.println("Error parsing medico: " + medico);
                        e.printStackTrace();
                    }
                }
            }
        } else {
            cbMedico.addItem("No contamos con médicos registrados");
        }  
    }
    
    
    

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new panelPaciente(arbolPaciente, arbolMedico).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cbHorarioDActionPerformed(java.awt.event.ActionEvent evt) {
        // Obtener el objeto seleccionado del JComboBox de médicos
        Object selectedMedico = cbMedico.getSelectedItem();
    
        // Verificar que el objeto seleccionado es de tipo Medico
        if (selectedMedico instanceof Medico) {
            Medico medico = (Medico) selectedMedico;
    
            // Obtener el turno del médico
            Turno turno = medico.getTurno();
    

    
            // Agregar elementos al JComboBox dependiendo del turno del médico
            if (turno.getCategoria().equals("manana")) {
                cbHorarioD.addItem("8:00 - 8:30");
                cbHorarioD.addItem("8:30 - 9:00");
                cbHorarioD.addItem("9:00 - 9:30");
                cbHorarioD.addItem("9:30 - 10:00");
                cbHorarioD.addItem("10:00 - 10:30");
                cbHorarioD.addItem("10:30 - 11:00");
                cbHorarioD.addItem("11:00 - 11:30");
                cbHorarioD.addItem("11:30 - 12:00");
            } else{
                cbHorarioD.addItem("14:00 - 14:30");
                cbHorarioD.addItem("14:30 - 15:00");
                cbHorarioD.addItem("15:00 - 15:30");
                cbHorarioD.addItem("15:30 - 16:00");
                cbHorarioD.addItem("16:00 - 16:30");
                cbHorarioD.addItem("16:30 - 17:00");
                cbHorarioD.addItem("17:00 - 17:30");
                cbHorarioD.addItem("17:30 - 18:00");
            } 
        } else {
            System.out.println("El objeto seleccionado no es un médico.");
        }
    }
    

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
            java.util.logging.Logger.getLogger(panelRegistrarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panelRegistrarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panelRegistrarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panelRegistrarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new panelRegistrarCita().setVisible(true);
                //x
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRegCita;
    private javax.swing.JButton btnRegPaciente;
    private javax.swing.JComboBox<String> cbHorarioD;
    private javax.swing.JComboBox<String> cbMedico;
    private javax.swing.JComboBox<String> cbPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDetalle;
    // End of variables declaration//GEN-END:variables
}
