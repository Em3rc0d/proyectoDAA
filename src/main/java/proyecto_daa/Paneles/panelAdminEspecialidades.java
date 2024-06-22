package proyecto_daa.Paneles;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto_daa.Entidades.Especialidad;
import proyecto_daa.Especialidades.ListaEspecialidades;
import proyecto_daa.Nodos.NodoEspecialidad;

public class panelAdminEspecialidades extends javax.swing.JFrame {

    DefaultTableModel modelo;
    ListaEspecialidades listaEspecialidades;

    public panelAdminEspecialidades() {
        initComponents();
        setLocationRelativeTo(null);

        // Inicializar la lista de especialidades
        listaEspecialidades = new ListaEspecialidades();

        // Configurar modelo para la tabla
        modelo = new DefaultTableModel();
        modelo.addColumn("Especialidad Médica");

        // Llenar el modelo con las especialidades
        NodoEspecialidad actual = listaEspecialidades.getCabeza();
        while (actual != null) {
            modelo.addRow(new Object[]{actual.getEspecialidadMedica()});
            actual = actual.getSiguiente();
        }

        // Asignar el modelo a la tabla
        tblEspecialidades.setModel(modelo);
    }

    // Método generado automáticamente por NetBeans para la configuración visual
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEspecialidades = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblEspecialidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Especialidad Médica"
            }
        ));
        jScrollPane1.setViewportView(tblEspecialidades);

        btnAgregar.setText("Agregar Especialidad");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar Especialidad");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // Preguntar al usuario por la nueva especialidad
        String nuevaEspecialidad = JOptionPane.showInputDialog(this, "Ingrese la nueva especialidad:", "Agregar Especialidad", JOptionPane.PLAIN_MESSAGE);
        
        // Validar que se haya ingresado algo
        if (nuevaEspecialidad != null && !nuevaEspecialidad.trim().isEmpty()) {
            
            // Agregar el nodo a la lista enlazada
            listaEspecialidades.agregarEspecialidad(nuevaEspecialidad);
            
            // Actualizar la tabla
            modelo.addRow(new Object[]{nuevaEspecialidad});
        }
    }                                          

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // Obtener el índice de la fila seleccionada
        int selectedRow = tblEspecialidades.getSelectedRow();
        
        // Validar que haya una fila seleccionada
        if (selectedRow != -1) {
            // Obtener la especialidad a eliminar
            String especialidadAEliminar = (String) tblEspecialidades.getValueAt(selectedRow, 0);
            
            // Eliminar la especialidad de la lista enlazada
            listaEspecialidades.eliminarEspecialidad(especialidadAEliminar);
            
            // Eliminar la fila seleccionada del modelo de la tabla
            modelo.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una especialidad para eliminar.", "Eliminar Especialidad", JOptionPane.WARNING_MESSAGE);
        }
    }                                           

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
            java.util.logging.Logger.getLogger(panelAdminEspecialidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panelAdminEspecialidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panelAdminEspecialidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panelAdminEspecialidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panelAdminEspecialidades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEspecialidades;
    // End of variables declaration                   
}
