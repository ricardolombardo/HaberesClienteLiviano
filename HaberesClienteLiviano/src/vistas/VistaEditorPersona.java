package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import componentesGraficos.ComboDTO;
import controladores.PersonaController;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DTO.*;

public class VistaEditorPersona extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private ComboDTO cmbDepartamentos;
	private ComboDTO cmbJerarquias;
	private JTextField txtNombre;
	private JTextField txtApellidoPaterno;
	private JTextField txtApellidoMaterno;
	private VistaEditorPersona mismo;
	private VistaPrincipal padre;
	
	public VistaEditorPersona(VistaPrincipal padre,PersonaDTO persona,List<DepartamentoDTO>departamentos,List<JerarquiaDTO> jerarquias) {
		super(new JFrame(),"Editor Persona",true);
		this.setLocationRelativeTo(null);
		this.setSize(400,200);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		mismo=this;
		this.padre=padre;
		JPanel panelCentro=new JPanel();
		panelCentro.setLayout(new GridLayout(6,1,2,2));
		panelCentro.setBackground(Color.white);
		
		JPanel cont1=new JPanel();
		cont1.setLayout(new GridLayout(1,2,0,0));
		cont1.add(new JLabel("Nombre"));
		txtNombre=new JTextField();
		txtNombre.setText(persona.getNombre());
		cont1.add(txtNombre);
		
		JPanel cont2=new JPanel();
		cont2.setLayout(new GridLayout(1,2,0,0));
		cont2.add(new JLabel("Apellido"));
		txtApellidoPaterno=new JTextField();
		txtApellidoPaterno.setText(persona.getApellidoPaterno());
		cont2.add(txtApellidoPaterno);
		
		JPanel cont3=new JPanel();
		cont3.setLayout(new GridLayout(1,2,0,0));
		cont3.add(new JLabel("Apellido Materno"));
		txtApellidoMaterno=new JTextField();
		txtApellidoMaterno.setText(persona.getApellidoPaterno());
		cont3.add(txtApellidoMaterno);
		
		
		JPanel cont4=new JPanel();
		cont4.setLayout(new GridLayout(1,2,0,0));
		cont4.add(new JLabel("Departamento"));
		cmbDepartamentos=new ComboDTO();
		for(DepartamentoDTO departamento:departamentos) {
			cmbDepartamentos.addItem(departamento);
		}
		cont4.add(cmbDepartamentos);
		
		JPanel cont5=new JPanel();
		cont5.setLayout(new GridLayout(1,2,0,0));
		cont5.add(new JLabel("Jerarquia"));
		cmbJerarquias=new ComboDTO();
		for(JerarquiaDTO jerarquia:jerarquias) {
			cmbJerarquias.addItem(jerarquia);
		}
		cont5.add(cmbJerarquias);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				long id=((DepartamentoDTO)cmbDepartamentos.getSelectedItem()).getId();
				persona.setNombre(txtNombre.getText());
				persona.setApellidoPaterno(txtApellidoPaterno.getText());
				persona.setApellidoMaterno(txtApellidoMaterno.getText());
				
				DepartamentoDTO departamento=(DepartamentoDTO) cmbDepartamentos.getSelectedItem();
				persona.setDepartamento(departamento);
				
				JerarquiaDTO jerarquia=(JerarquiaDTO)cmbJerarquias.getSelectedItem();
				persona.setJerarquia(jerarquia);
				
				PersonaController.posEditarPersona(persona, padre);
				mismo.dispose();
			}
		});
		
		panelCentro.add(cont1);
		panelCentro.add(cont2);
		panelCentro.add(cont3);
		panelCentro.add(cont4);
		panelCentro.add(cont5);
		panelCentro.add(btnAceptar);
		panelCentro.setBorder(new EmptyBorder(10, 10, 10, 10));
		validate();
		
		this.add(panelCentro,BorderLayout.CENTER);
	}
	
}
