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

import DTO.NOUDTO;
import DTO.PersonaDTO;
import componentesGraficos.PanelDato;
import controladores.EventoController;
import controladores.NOUController;
import excepciones.NOUException;
import servicios.ServicioNous;

public class VistaEditorNou extends JDialog{
	
	private JTextField txtNumero;
	private VistaPrincipal padre;
	private VistaEditorNou mismo;

	public VistaEditorNou(VistaPrincipal padre,PersonaDTO persona) {
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
		
		txtNumero=new JTextField();
		PanelDato datoIdentificador=new PanelDato("Numero",txtNumero);
		panelCentro.add(datoIdentificador);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				NOUDTO nou=new NOUDTO();
				nou.setNumeroNOU(Integer.parseInt(txtNumero.getText()));
				nou.setPersona(persona);
				NOUController.posCrearNou(padre, nou);
				mismo.dispose();
			}
		});
		
		panelCentro.add(btnAceptar);
		panelCentro.setBorder(new EmptyBorder(10, 10, 10, 10));
		validate();
		
		this.add(panelCentro,BorderLayout.CENTER);
	}
	
}
