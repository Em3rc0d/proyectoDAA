package proyecto_daa.Paneles;

import java.util.Date;
import java.util.List;

import proyecto_daa.Entidades.Medico;
import proyecto_daa.Entidades.Paciente;
import proyecto_daa.Entidades.Turno;
import proyecto_daa.Gestionadores.*;
import proyecto_daa.ManejadorAchivos.ManejoArchivos;

public class panelRegistrarCita extends javax.swing.JFrame {

    GestionadorPaciente arbolPaciente = new GestionadorPaciente();
    GestionadorMedico arbolMedico = new GestionadorMedico();
    GestionadorCitaMedica arbolCita;
    
    public panelRegistrarCita() {
        initComponents();
        setLocationRelativeTo(null);

        arbolPaciente = ManejoArchivos.cargarArbol("arbolPacientes.txt", arbolPaciente);
        arbolMedico = ManejoArchivos.cargarArbol("arbolMedicos.txt", arbolMedico);

        // cbMedico.removeAllItems();
        agregarMedicosALista();
        // cbPaciente.removeAllItems();
        agregarPacientesALista();
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

    private void btnRegPacienteActionPerformed(java.awt.event.ActionEvent evt) {
        new panelRegistrarPaciente().setVisible(true);
        setVisible(false);
    }

    private void btnRegCitaActionPerformed(java.awt.event.ActionEvent evt) {
        // Obtener el objeto seleccionado del JComboBox
        Object selectedPaciente = cbPaciente.getSelectedItem();
        Object selectedMedico = cbMedico.getSelectedItem();
        String selectedHorario = cbHorarioD.getSelectedItem().toString();

        if (selectedPaciente == null || selectedMedico == null || selectedHorario == null) {
            // Manejar el caso en que uno de los objetos no este seleccionado
            System.out.println("Uno o más objetos no han sido seleccionados.");
            return;
        }

        // Verificar si los objetos seleccionados son del tipo esperado
        if (!(selectedPaciente instanceof Paciente) || !(selectedMedico instanceof Medico) || !(selectedHorario instanceof String)) {
            // Manejar el caso en que uno de los objetos no sea del tipo esperado
            System.out.println("Uno o más objetos seleccionados no son del tipo esperado.");
            return;
        }

        // Obtener los objetos seleccionados
        if (selectedPaciente instanceof Paciente && selectedMedico instanceof Medico) {
            Paciente paciente = (Paciente) selectedPaciente;
            Medico medico = (Medico) selectedMedico;
            String horario = selectedHorario.toString();
            String[] partes = horario.split(" - ");
            String horaInicio = partes[0]; 
            String horaFin = partes[1];  
            
            int idCita;
            if (arbolCita.raiz == null) {
                idCita = 1;
            } else {
                idCita = arbolCita.raiz.CitaMedica.getIdCita() + 1;
            }
    
            // Insertar la nueva cita médica
            arbolCita.insertarCitaMedica(idCita, paciente, medico, horaInicio, horaFin, "Pendiente");
        } else {
            // Manejar el caso en que uno de los objetos no sea del tipo esperado
            System.out.println("Uno o más objetos seleccionados no son del tipo esperado.");
        }
    }
        
    private void cbPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPacienteActionPerformed
        // // TODO add your handling code here:
        // cbPaciente.removeAllItems();
        // String listaPacientes = arbolPaciente.listarPacientes();
        // String[] pacientes = listaPacientes.split("\n");
        // if (pacientes.length > 0 && !listaPacientes.isEmpty()) {
        //     for (String paciente : pacientes) {
        //         if (!paciente.trim().isEmpty()) {
        //             try {
        //                 String[] infoPaciente = paciente.split(", ");
        //                 String nombre = infoPaciente[0].substring(infoPaciente[0].indexOf('=') + 1).trim();
        //                 String apellido = infoPaciente[1].substring(infoPaciente[1].indexOf('=') + 1).trim();
        //                 cbPaciente.addItem(nombre + " " + apellido);
        //             } catch (Exception e) {
        //                 System.out.println("Error al registrar el paciente: " + e.getMessage());
        //             }
        //         }
        //     }
        // }else{
        //     cbPaciente.addItem("No hay pacientes registrados");
        // }
    }//GEN-LAST:event_cbPacienteActionPerformed

    private void cbMedicoActionPerformed(java.awt.event.ActionEvent evt) {
        // Obtener el médico seleccionado del JComboBox
        Object selectedMedicoObj = cbMedico.getSelectedItem();
        if (selectedMedicoObj != null) {
            String selectedMedico = selectedMedicoObj.toString();
            System.out.println("Medico seleccionado: " + selectedMedico);
            // Encontrar el índice del primer guion ("-")
            int primerGuionIndex = selectedMedico.indexOf('-');

            // Encontrar el índice del segundo guion ("-"), comenzando desde el índice después del primer guion
            int segundoGuionIndex = selectedMedico.indexOf('-', primerGuionIndex + 1);

            // Obtener el turno del médico
            String turno = selectedMedico.substring(segundoGuionIndex + 1).trim();
            cbHorarioD.removeAllItems();
            System.out.println("Turno: " + turno);
            if(turno.equals("Mañana")){
                cbHorarioD.addItem("8:00 - 8:30");
                cbHorarioD.addItem("8:30 - 9:00");
                cbHorarioD.addItem("9:00 - 9:30");
                cbHorarioD.addItem("9:30 - 10:00");
                cbHorarioD.addItem("10:00 - 10:30");
                cbHorarioD.addItem("10:30 - 11:00");
                cbHorarioD.addItem("11:00 - 11:30");
                cbHorarioD.addItem("11:30 - 12:00");
            }else if(turno.equals("Tarde")){
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
            System.out.println("No se ha seleccionado ningún médico.");
        }

    }
    //agregao
    public void agregarPacientesALista() {
        // Limpiar los elementos existentes en el JComboBox
        cbPaciente.removeAllItems();
        // Obtener la lista de pacientes como objetos Paciente  
        List<Paciente> listaPacientes = arbolPaciente.getListaPacientes();
        if (!listaPacientes.isEmpty()) {
            // Agregar cada paciente (solo nombre y apellido) al JComboBox
            for (Paciente paciente : listaPacientes) {
                try {
                    String nombre = paciente.getNombre();
                    String apellido = paciente.getApellido();
                    // Agregar el nombre y apellido al JComboBox
                    cbPaciente.addItem(nombre + " " + apellido);
                } catch (Exception e) {
                    System.out.println("Error parsing paciente: " + paciente);
                    e.printStackTrace();
                }
            }
        }
    }
    public void agregarMedicosALista() {
        // Limpiar los elementos existentes en el JComboBox
        cbMedico.removeAllItems();

        // Obtener la lista de médicos como objetos Medico
        List<Medico> listaMedicos = arbolMedico.getListaMedicos();

        if (!listaMedicos.isEmpty()) {
            // Agregar cada médico (solo nombre, apellido y especialidad) al JComboBox
            for (Medico medico : listaMedicos) {
                try {
                    String nombre = medico.getNombre();
                    String apellido = medico.getApellido();
                    String especialidad = medico.getEspecialidad();
                    String turno = medico.getTurno().getCategoria();
                    // Agregar el nombre, apellido y especialidad al JComboBox
                    cbMedico.addItem(nombre + " " + apellido + " - " + especialidad + " - " + turno);
                } catch (Exception e) {
                    System.out.println("Error parsing medico: " + medico);
                    e.printStackTrace();
                }
            }
        } else {
            cbMedico.addItem("No contamos con médicos registrados");
        }
    }
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new panelPaciente().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cbHorarioDActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panelRegistrarCita().setVisible(true);
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
