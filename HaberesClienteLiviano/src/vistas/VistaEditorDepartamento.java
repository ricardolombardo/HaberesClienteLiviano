package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import DTO.DepartamentoDTO;
import controladores.DepartamentoController;

public class VistaEditorDepartamento extends JDialog{
	
	private VistaEditorDepartamento mismo;
	private VistaPrincipal padre;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	
	public VistaEditorDepartamento(VistaPrincipal padre,DepartamentoDTO departamento) {
		super(new JFrame(),"Editor Departamento",true);
		this.setLocationRelativeTo(null);
		this.setSize(400,150);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		mismo=this;
		this.padre=padre;
		JPanel panelCentro=new JPanel();
		panelCentro.setLayout(new GridLayout(3,1,2,2));
		panelCentro.setBackground(Color.white);
		
		JPanel cont1=new JPanel();
		cont1.setLayout(new GridLayout(1,2,0,0));
		cont1.add(new JLabel("Nombre"));
		txtNombre=new JTextField();
		txtNombre.setText(departamento.getNombre());
		cont1.add(txtNombre);
		
		JPanel cont2=new JPanel();
		cont2.setLayout(new GridLayout(1,2,0,0));
		cont2.add(new JLabel("Descripcion"));
		txtDescripcion=new JTextField();
		txtDescripcion.setText(departamento.getDescripcion());
		cont2.add(txtDescripcion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				departamento.setNombre(txtNombre.getText());
				departamento.setDescripcion(txtDescripcion.getText());
				DepartamentoController.posEditarDepartamento(departamento, padre);
				mismo.dispose();
			}
		});
		
		panelCentro.add(cont1);
		panelCentro.add(cont2);
		panelCentro.add(btnAceptar);
		panelCentro.setBorder(new EmptyBorder(10, 10, 10, 10));
		validate();
		
		this.add(panelCentro,BorderLayout.CENTER);
	}

}
