package com.gestionclinica.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.gestionclinica.model.Medicos;
import com.gestionclinica.model.pacientes;
import com.gestionclinica.repository.clinicas.Repository;
import com.gestionclinica.repository.clinicas.medicosRepository;
import com.gestionclinica.repository.clinicas.pacientesRepository;

public class SwingApp extends JFrame{
    private final Repository<Medicos> medicosRepository;
    private final JTable MedicoTable;

    public SwingApp(){
        setTitle("Gestion mEDICOS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,300);

        MedicoTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(MedicoTable);
        add(scrollPane,BorderLayout.CENTER);

        JButton addButton = new JButton("Agregar");
        JButton updateButton = new JButton("Actualizar");
        JButton deleteButton = new JButton("Borrar");
        JButton botonNOespecialistas = new JButton("listar especialistas");
        JButton botonApellidoEspecifico = new JButton("listar apellido especifico");


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(botonNOespecialistas);
        buttonPanel.add(botonApellidoEspecifico);

        add(buttonPanel,BorderLayout.SOUTH);

        medicosRepository = new medicosRepository();

        listAll();

        botonNOespecialistas.addActionListener(e-> {
            try {
                listMedicosNoEspecialistas();
            } catch (Exception ex) {
                ex.printStackTrace(); 
            }
        });
        addButton.addActionListener(e-> {
            try {
            //   addActor();
            } catch (Exception ex) {
                ex.printStackTrace(); 
            }
        });

        updateButton.addActionListener(e-> {
            try {
              //  actualizarActor();
            } catch (Exception ex) {
                ex.printStackTrace(); 
            }
        });

        deleteButton.addActionListener(e-> {
            try {
               // eliminarEmpleado();
            } catch (Exception ex) {
                ex.printStackTrace(); 
            }
        });

        botonApellidoEspecifico.addActionListener(e-> {
            try {
                listApellidoEspecifico();
            } catch (Exception ex) {
                ex.printStackTrace(); 
            }
        });

    }

   
    private void listMedicosNoEspecialistas() {
        try {
            List<Medicos> medicos = medicosRepository.findNoEspecialista();

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Nombre");
            tableModel.addColumn("Apellido");

            for (Medicos medico : medicos) {
                Object[] dataRow = {
                    medico.getNombre(),
                    medico.getEspecialista()
                };
                tableModel.addRow(dataRow);
            }
            MedicoTable.setModel(tableModel);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Error getAll","Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void listApellidoEspecifico() {
        try {
            List<Medicos> medicos = medicosRepository.findNoEspecialista();

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Apellido");

            for (Medicos medico : medicos) {
                Object[] dataRow = {
                    medico.getNombre(),
                    medico.getEspecialista()
                };
                tableModel.addRow(dataRow);
            }
            MedicoTable.setModel(tableModel);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Error getAll","Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void listAll() {
        try {
            List<Medicos> medicos = medicosRepository.findAll();

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Nombre");
            tableModel.addColumn("Apellido");
            tableModel.addColumn("esp");

            for (Medicos medico : medicos) {
                Object[] dataRow = {
                    medico.getNombre(),
                    medico.getApellido(),
                    medico.getEspecialista()

                };
                tableModel.addRow(dataRow);
            }
            MedicoTable.setModel(tableModel);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Error getAll","Error", JOptionPane.ERROR_MESSAGE);
        }

    }   



    private void listApellido() {
        try {
            List<pacientes> pacien = pacientesRepository.listApellido();

            DefaultTableModel tableModel = new DefaultTableModel(); 
            tableModel.addColumn("Apellido");
            for (Medicos medico : medicos) {
                Object[] dataRow = {
                    medico.getNombre(),
                    medico.getApellido(),
                    medico.getEspecialista()

                };
                tableModel.addRow(dataRow);
            }
            MedicoTable.setModel(tableModel);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Error getAll","Error", JOptionPane.ERROR_MESSAGE);
        }

}




