package com.gestionclinica.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gestionclinica.model.Medicos;
import com.gestionclinica.model.pacientes;
import com.gestionclinica.model.tratamientos;
import com.gestionclinica.repository.clinicas.medicosRepository;
import com.gestionclinica.repository.clinicas.pacientesRepository;
import com.gestionclinica.repository.clinicas.tratamientosRepository;

public class SwingApp extends JFrame {
    private final medicosRepository medicosRepository;
    private final pacientesRepository pacientesRepository;
    private final tratamientosRepository tratamientosRepository;
    private String apellidoIngresado; // Variable para almacenar el apellido ingresado

    public SwingApp() {
        setTitle("Gestión de Clínica Médica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null); // Centrar ventana

        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        add(mainPanel);

        medicosRepository = new medicosRepository();
        pacientesRepository = new pacientesRepository();
        tratamientosRepository = new tratamientosRepository();

        // Botón para consultar médicos especialistas
        JButton consultaMedicosButton = new JButton("Consultar Médicos Especialistas");
        consultaMedicosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Medicos> especialistas = medicosRepository.findNoEspecialista();
                    StringBuilder result = new StringBuilder();
                    result.append("Médicos Especialistas:\n");
                    for (Medicos medico : especialistas) {
                        result.append(medico.getNombre()).append(" ").append(medico.getApellido()).append("\n");
                    }
                    JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Médicos Especialistas", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Error al consultar médicos especialistas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(consultaMedicosButton);

        // Botón para consultar pacientes por apellido
        JButton consultaPacientesPorApellidoButton = new JButton("Consultar Pacientes por Apellido");
        consultaPacientesPorApellidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (apellidoIngresado == null) {
                    // Si el apellido no ha sido ingresado previamente, solicitarlo al usuario
                    apellidoIngresado = JOptionPane.showInputDialog(SwingApp.this, "Ingrese el apellido del paciente:");
                }

                // Resto del código de la acción del botón
                // ...
            }
        });
        mainPanel.add(consultaPacientesPorApellidoButton);

        // Botón para mostrar información de contacto de todos los pacientes
        JButton informacionContactoPacientesButton = new JButton("Información de Contacto de Pacientes");
        informacionContactoPacientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<pacientes> pacientesList = pacientesRepository.findAll();
                    StringBuilder result = new StringBuilder();
                    result.append("Información de Contacto de Pacientes:\n");
                    for (pacientes paciente : pacientesList) {
                        result.append("Nombre: ").append(paciente.getNombre()).append(" ").append(paciente.getApellido())
                                .append(", Teléfono: ").append(paciente.getNo_telefono()).append("\n");
                    }
                    JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Información de Contacto de Pacientes", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Error al consultar la información de contacto de los pacientes: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(informacionContactoPacientesButton);

        // Botón para contar tratamientos por tipo
        JButton contarTratamientosPorTipoButton = new JButton("Contar Tratamientos por Tipo");
        contarTratamientosPorTipoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<tratamientos> tratamientos = tratamientosRepository.findAll();
                    StringBuilder result = new StringBuilder();
                    result.append("Conteo de tratamientos por tipo:\n");
                    // Crear un mapa para almacenar el conteo de tratamientos por tipo
                    Map<String, Integer> conteoTratamientos = new HashMap<>();
                    for (tratamientos tratamiento : tratamientos) {
                        String tipo = tratamiento.getTipo();
                        conteoTratamientos.put(tipo, conteoTratamientos.getOrDefault(tipo, 0) + 1);
                    }
                    // Construir el mensaje de resultado
                    for (Map.Entry<String, Integer> entry : conteoTratamientos.entrySet()) {
                        result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                    }
                    JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Conteo de Tratamientos por Tipo", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Error al contar tratamientos por tipo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(contarTratamientosPorTipoButton);

        // Botón para buscar tratamientos que se deban consumir en un "largo plazo"
        JButton buscarTratamientosLargoPlazoButton = new JButton("Buscar Tratamientos a Largo Plazo");
        buscarTratamientosLargoPlazoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<tratamientos> tratamientosLargoPlazo = tratamientosRepository.findTratamientosLargoPlazo();
                StringBuilder result = new StringBuilder();
                result.append("Tratamientos a Largo Plazo:\n");
                for (tratamientos tratamiento : tratamientosLargoPlazo) {
                    result.append(tratamiento.getNombre()).append(": ").append(tratamiento.getDireccion()).append("\n");
                }
                JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Tratamientos a Largo Plazo", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        mainPanel.add(buscarTratamientosLargoPlazoButton);

        // Botón para identificar pacientes registrados en más de un tratamiento
        JButton pacientesEnMasDeUnTratamientoButton = new JButton("Pacientes en Más de un Tratamiento");
        pacientesEnMasDeUnTratamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<pacientes> pacientesEnMasDeUnTratamiento = pacientesRepository.findPacientesEnMasDeUnTratamiento();
                StringBuilder result = new StringBuilder();
                result.append("Pacientes registrados en más de un tratamiento:\n");
                for (pacientes paciente : pacientesEnMasDeUnTratamiento) {
                    result.append(paciente.getNombre()).append(" ").append(paciente.getApellido()).append("\n");
                }
                JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Pacientes en Más de un Tratamiento", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        mainPanel.add(pacientesEnMasDeUnTratamientoButton);

        // Botón para listar la información de los pacientes y el nombre de su médico general asociado
        JButton pacientesConMedicoGeneralButton = new JButton("Pacientes con Médico General Asociado");
        pacientesConMedicoGeneralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Object[]> pacientesConMedicoGeneral = pacientesRepository.findPacientesConMedicoGeneral();
                StringBuilder result = new StringBuilder();
                result.append("Pacientes con su Médico General Asociado:\n");
                for (Object[] pacienteMedico : pacientesConMedicoGeneral) {
                    result.append("Paciente: ").append(pacienteMedico[0]).append(" ").append(pacienteMedico[1])
                            .append(", Médico General: ").append(pacienteMedico[2]).append(" ").append(pacienteMedico[3]).append("\n");
                }
                JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Pacientes con Médico General Asociado", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        mainPanel.add(pacientesConMedicoGeneralButton);

        // Botón para listar los médicos que supervisan tratamientos y los detalles de esos tratamientos
        JButton medicosSupervisanTratamientosButton = new JButton("Médicos que Supervisan Tratamientos");
        medicosSupervisanTratamientosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Object[]> medicosYTratamientos = medicosRepository.findMedicosSupervisanTratamientos();
                StringBuilder result = new StringBuilder();
                result.append("Médicos y Detalles de los Tratamientos que Supervisan:\n");
                for (Object[] medicoTratamiento : medicosYTratamientos) {
                    result.append("Médico: ").append(medicoTratamiento[0]).append(" ").append(medicoTratamiento[1])
                            .append(", Tratamiento: ").append(medicoTratamiento[2]).append(" - ").append(medicoTratamiento[3]).append("\n");
                }
                JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Médicos y Tratamientos Supervisados", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        mainPanel.add(medicosSupervisanTratamientosButton);

        JButton medicosSupervisanTratamientosButton = new JButton("Médicos que Supervisan Tratamientos");
        medicosSupervisanTratamientosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Object[]> medicosYTratamientos = medicosRepository.findMedicosSupervisanTratamientos();
                StringBuilder result = new StringBuilder();
                result.append("Médicos y Detalles de los Tratamientos que Supervisan:\n");
                for (Object[] medicoTratamiento : medicosYTratamientos) {
                    result.append("Médico: ").append(medicoTratamiento[0]).append(" ").append(medicoTratamiento[1])
                            .append(", Tratamiento: ").append(medicoTratamiento[2]).append(" - ").append(medicoTratamiento[3]).append("\n");
                }
                JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Médicos y Tratamientos Supervisados", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        mainPanel.add(medicosSupervisanTratamientosButton);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingApp app = new SwingApp();
            app.setVisible(true);
        });
    }
}


        
