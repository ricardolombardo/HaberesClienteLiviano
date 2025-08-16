package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import DTO.EventoDTO;
import componentesGraficos.PanelDato;
import controladores.EventoController;

public class VistaEditorEvento extends JDialog{
	
	private VistaEditorEvento mismo;
	private VistaPrincipal padre;
	private JTextField txtIdentificador;
	private JTextField txtDescripcion;
	
	public VistaEditorEvento(VistaPrincipal padre,EventoDTO evento) {
		super(new JFrame(),"Editor Evento",true);
		this.setLocationRelativeTo(null);
		this.setSize(400,150);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		mismo=this;
		this.padre=padre;
		JPanel panelCentro=new JPanel();
		panelCentro.setLayout(new GridLayout(3,1,2,2));
		panelCentro.setBackground(Color.white);
		
		
		txtIdentificador=new JTextField();
		PanelDato datoIdentificador=new PanelDato("Identificador",txtIdentificador);
		panelCentro.add(datoIdentificador);

		txtDescripcion=new JTextField();
		PanelDato datoDescripcion=new PanelDato("Descripcion",txtDescripcion);
		panelCentro.add(datoDescripcion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				evento.setIdentificador(txtIdentificador.getText());
				evento.setDescripcion(txtDescripcion.getText());
				EventoController.posNuevoEvento(padre, evento);
				mismo.dispose();
			}
		});
		
		panelCentro.add(btnAceptar);
		panelCentro.setBorder(new EmptyBorder(10, 10, 10, 10));
		validate();
		
		this.add(panelCentro,BorderLayout.CENTER);
	}

}
