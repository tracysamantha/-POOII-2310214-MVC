/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.pkg1;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

/**
 *
 * @author tracy
 */
public class MVC2 extends JFrame {

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

    public MVC2() {
        // Configuración de la ventana
        setTitle("Gestor de Eventos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane pestañas = new JTabbedPane();

        // Panel del formulario de eventos
        JPanel pnlFormulario = new JPanel();
        pnlFormulario.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlFormulario.add(new JLabel("Descripción del evento"), gbc);
        gbc.gridx = 1;
        txtDescripcion = new JTextField(20);
        pnlFormulario.add(txtDescripcion, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pnlFormulario.add(new JLabel("Correo de reenvío"), gbc);
        gbc.gridx = 1;
        txtEmail = new JTextField(20);
        pnlFormulario.add(txtEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pnlFormulario.add(new JLabel("Fecha"), gbc);
        gbc.gridx = 1;
        txtFecha = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        txtFecha.setColumns(10);
        pnlFormulario.add(txtFecha, gbc);

        // Frecuencia del evento
        gbc.gridx = 0;
        gbc.gridy = 3;
        pnlFormulario.add(new JLabel("Frecuencia"), gbc);
        JPanel pnlFrecuencia = new JPanel();
        ButtonGroup grupoFrecuencia = new ButtonGroup();
        rbtnDiario = new JRadioButton("Diario");
        rbtnSemanal = new JRadioButton("Semanal");
        rbtnMensual = new JRadioButton("Mensual");
        grupoFrecuencia.add(rbtnDiario);
        grupoFrecuencia.add(rbtnSemanal);
        grupoFrecuencia.add(rbtnMensual);
        pnlFrecuencia.add(rbtnDiario);
        pnlFrecuencia.add(rbtnSemanal);
        pnlFrecuencia.add(rbtnMensual);
        gbc.gridx = 1;
        pnlFormulario.add(pnlFrecuencia, gbc);

        // Casilla de verificación de Alarma
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        chkAlarma = new JCheckBox("Alarma");
        pnlFormulario.add(chkAlarma, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        btnGuardar = new JButton("Guardar");
        pnlFormulario.add(btnGuardar, gbc);
        gbc.gridx = 1;
        btnLimpiar = new JButton("Limpiar");
        pnlFormulario.add(btnLimpiar, gbc);

        pestañas.add("Nuevo evento", pnlFormulario);

        JPanel pnlTabla = new JPanel(new BorderLayout());
        String[] columnas = {"Fecha", "Descripción", "Frecuencia", "Correo", "Alarma"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaEventos = new JTable(modeloTabla);
        tablaEventos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(tablaEventos);
        pnlTabla.add(scrollPane, BorderLayout.CENTER);
        pestañas.add("Eventos", pnlTabla);

        JPanel pnlRegistrarInvitado = new JPanel();
        pnlRegistrarInvitado.setLayout(new GridBagLayout());
        GridBagConstraints gbcInv = new GridBagConstraints();
        gbcInv.insets = new Insets(5, 5, 5, 5);
        gbcInv.fill = GridBagConstraints.HORIZONTAL;

        pestañas.add("Registrar Invitado", pnlRegistrarInvitado);

        gbcInv.gridx = 0;
        gbcInv.gridy = 0;
        pnlRegistrarInvitado.add(new JLabel("Nombre"), gbcInv);
        gbcInv.gridx = 1;
        JTextField txtNombre = new JTextField(20);
        pnlRegistrarInvitado.add(txtNombre, gbcInv);

        gbcInv.gridx = 0;
        gbcInv.gridy = 1;
        pnlRegistrarInvitado.add(new JLabel("Ingrese número celular:"), gbcInv);
        gbcInv.gridx = 1;
        JTextField txtCelular = new JTextField(20);
        pnlRegistrarInvitado.add(txtCelular, gbcInv);

        gbcInv.gridx = 0;
        gbcInv.gridy = 2;
        pnlRegistrarInvitado.add(new JLabel("Género:"), gbcInv);
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

        gbcInv.gridx = 0;
        gbcInv.gridy = 4;
        pnlRegistrarInvitado.add(new JLabel("Dirección:"), gbcInv);
        gbcInv.gridx = 1;
        JTextField txtDireccion = new JTextField(20);
        pnlRegistrarInvitado.add(txtDireccion, gbcInv);

        gbcInv.gridx = 0;
        gbcInv.gridy = 5;
        JCheckBox chkTerminos = new JCheckBox("Acepta Términos y Condiciones");
        pnlRegistrarInvitado.add(chkTerminos, gbcInv);

        gbcInv.gridx = 0;
        gbcInv.gridy = 6;
        JButton btnRegistrar = new JButton("Registrar");
        pnlRegistrarInvitado.add(btnRegistrar, gbcInv);

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
                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(pnlRegistrarInvitado, "Invitado registrado exitosamente.");
                    // Limpiar campos
                    txtNombre.setText("");
                    txtCelular.setText("");
                    txtDireccion.setText("");
                    chkTerminos.setSelected(false);
                }
            }
        });

        // Añadir el componente JTabbedPane al JFrame
        add(pestañas);
    }

 public static void main(String[] args) {
  java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new MVC2().setVisible(true); // Simplemente `true`, sin `b:`
        }
    });
}
}