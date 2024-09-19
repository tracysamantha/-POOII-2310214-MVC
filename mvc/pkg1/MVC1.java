/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvc.pkg1;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author tracy
 */
public class MVC1 extends javax.swing.JFrame {

    private JTextField txtDescripcion;
    private JTextField txtEmail;
    private JFormattedTextField txtFecha;
    private JRadioButton rbtnDiario;
    private JRadioButton rbtnSemanal;
    private JRadioButton rbtnMensual;
    private JCheckBox chkAlarma;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JTable tablaEventos;
    private DefaultTableModel modeloTabla;

    public MVC1() {
        setTitle("Gestor de Eventos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JTabbedPane pestañas = new JTabbedPane();

        JPanel pnlFormulario = new JPanel();
        pnlFormulario.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlFormulario.add(new JLabel("Event description"), gbc);
        gbc.gridx = 1;
        txtDescripcion = new JTextField(20);
        pnlFormulario.add(txtDescripcion, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pnlFormulario.add(new JLabel("Forward e-mail"), gbc);
        gbc.gridx = 1;
        txtEmail = new JTextField(20);
        pnlFormulario.add(txtEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pnlFormulario.add(new JLabel("Date"), gbc);
        gbc.gridx = 1;
        txtFecha = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        txtFecha.setColumns(10);
        pnlFormulario.add(txtFecha, gbc);

        // Frecuencia del evento
        gbc.gridx = 0;
        gbc.gridy = 3;
        pnlFormulario.add(new JLabel("Frequency"), gbc);
        JPanel pnlFrecuencia = new JPanel();
        ButtonGroup grupoFrecuencia = new ButtonGroup();
        rbtnDiario = new JRadioButton("Daily");
        rbtnSemanal = new JRadioButton("Weekly");
        rbtnMensual = new JRadioButton("Monthly");
        grupoFrecuencia.add(rbtnDiario);
        grupoFrecuencia.add(rbtnSemanal);
        grupoFrecuencia.add(rbtnMensual);
        pnlFrecuencia.add(rbtnDiario);
        pnlFrecuencia.add(rbtnSemanal);
        pnlFrecuencia.add(rbtnMensual);
        gbc.gridx = 1;
        pnlFormulario.add(pnlFrecuencia, gbc);

        // Casilla de verificación Alarma
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;  // Alinear hacia la izquierda
        chkAlarma = new JCheckBox("Alarm");
        pnlFormulario.add(chkAlarma, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        btnGuardar = new JButton("Save");
        pnlFormulario.add(btnGuardar, gbc);
        gbc.gridx = 1;
        btnLimpiar = new JButton("Clean");
        pnlFormulario.add(btnLimpiar, gbc);

        pestañas.add("New event", pnlFormulario);

        // Segunda pestaña - Tabla de eventos
        JPanel pnlTabla = new JPanel(new BorderLayout());
        String[] columnas = {"Date", "Description", "Frequency", "E-mail", "Alarm"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaEventos = new JTable(modeloTabla);
        tablaEventos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(tablaEventos);
        pnlTabla.add(scrollPane, BorderLayout.CENTER);
        pestañas.add("Events", pnlTabla);

        add(pestañas);
// tercera pestaña- registrar invitados

        JPanel pnlRegistrarInvitado = new JPanel();
        pnlRegistrarInvitado.setLayout(new GridBagLayout());
        GridBagConstraints gbcInv = new GridBagConstraints();
        gbcInv.insets = new Insets(5, 5, 5, 5);
        gbcInv.fill = GridBagConstraints.HORIZONTAL;

        pestañas.add("Registrar Invitado", pnlRegistrarInvitado);

        add(pestañas);


        gbcInv.gridx = 0;
        gbcInv.gridy = 0;
        pnlRegistrarInvitado.add(new JLabel("Nombre"), gbcInv);
        gbcInv.gridx = 1;
        JTextField txtNombre = new JTextField(20);
        pnlRegistrarInvitado.add(txtNombre, gbcInv);

        gbcInv.gridx = 0;
        gbcInv.gridy = 1;
        pnlRegistrarInvitado.add(new JLabel("Ingrese numero celular:"), gbcInv);
        gbcInv.gridx = 1;
        JTextField txtCelular = new JTextField(20);
        pnlRegistrarInvitado.add(txtCelular, gbcInv);

        gbcInv.gridx = 0;
        gbcInv.gridy = 2;
        pnlRegistrarInvitado.add(new JLabel("Genero:"), gbcInv);
        gbcInv.gridx = 1;
        JPanel pnlGenero = new JPanel();
        JRadioButton rbtnMasculino = new JRadioButton("Masculino");
        JRadioButton rbtnFemenino = new JRadioButton("Femenino");
        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(rbtnMasculino);
        grupoGenero.add(rbtnFemenino);
        pnlGenero.add(rbtnMasculino);
        pnlGenero.add(rbtnFemenino);
        pnlRegistrarInvitado.add(pnlGenero, gbcInv);


        gbcInv.gridx = 0;
        gbcInv.gridy = 3;
        pnlRegistrarInvitado.add(new JLabel("Fecha de Nacimiento:"), gbcInv);
        gbcInv.gridx = 1;
        JComboBox<String> comboDia = new JComboBox<>();
        JComboBox<String> comboMes = new JComboBox<>();
        JComboBox<String> comboAno = new JComboBox<>();
        JPanel pnlFechaNacimiento = new JPanel();
        pnlFechaNacimiento.add(comboDia);
        pnlFechaNacimiento.add(comboMes);
        pnlFechaNacimiento.add(comboAno);
        pnlRegistrarInvitado.add(pnlFechaNacimiento, gbcInv);

// Dirección
        gbcInv.gridx = 0;
        gbcInv.gridy = 4;
        pnlRegistrarInvitado.add(new JLabel("Dirección:"), gbcInv);
        gbcInv.gridx = 1;
        JTextField txtDireccion = new JTextField(20);
        pnlRegistrarInvitado.add(txtDireccion, gbcInv);

// Aceptar términos y condiciones
        gbcInv.gridx = 0;
        gbcInv.gridy = 5;
        JCheckBox chkTerminos = new JCheckBox("Acepta Términos y Condiciones");
        pnlRegistrarInvitado.add(chkTerminos, gbcInv);

// Botón Registrar
        gbcInv.gridx = 0;
        gbcInv.gridy = 3;
        JButton btnRegistrar = new JButton("Registrar");
        pnlRegistrarInvitado.add(btnRegistrar, gbcInv);

// Botón Resetear
        gbcInv.gridx = 1;
        JButton btnResetear = new JButton("Resetear");
        pnlRegistrarInvitado.add(btnResetear, gbcInv);

// Acción del botón Registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String celular = txtCelular.getText();
                String direccion = txtDireccion.getText();
                boolean aceptaTerminos = chkTerminos.isSelected();

                // Validación de campos
                if (nombre.isEmpty() || celular.isEmpty() || direccion.isEmpty() || !aceptaTerminos) {
                    JOptionPane.showMessageDialog(pnlRegistrarInvitado, "Complete todos los campos y acepte los términos.");
                } else {
                    // Guardar datos en un archivo o procesar la información
                    JOptionPane.showMessageDialog(pnlRegistrarInvitado, "Invitado registrado exitosamente.");
                    limpiarFormulario();
                }
            }

            private void limpiarFormulario() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        
    }
    
}
