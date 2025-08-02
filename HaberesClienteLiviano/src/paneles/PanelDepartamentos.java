package paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import DTO.DepartamentoDTO;
import componentesGraficos.BotonSeleccion;
import controladores.DepartamentoController;
import modelosVistas.PanelDepartamentosModelView;

public class PanelDepartamentos extends PanelVista{

	private static final long serialVersionUID = 1L;
	private PanelDepartamentosModelView modeloVista;
	
	public PanelDepartamentos(PanelDepartamentosModelView modelo) {
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.modeloVista=modelo;
		
		setTituloPrincipal("DEPARTAMENTOS");
		panelCentro=new JPanel();
		panelCentro.setLayout(new GridLayout(20,1,5,5));
		panelCentro.setBackground(Color.white);
		titulos=new JPanel();
		titulos.setLayout(new GridLayout(1,7,0,0));
		
		panelInferior=new JPanel();
		panelInferior.setLayout(new GridLayout(1,8,1,1));
		panelInferior.setBackground(Color.white);
		this.add(panelInferior,BorderLayout.SOUTH);
		
		this.setearTitulos("NOMBRE");
		this.setearTitulos("Editar");
		this.setearTitulos("Ver");
		panelCentro.add(titulos);
		titulos.setBackground(new Color(169, 223, 191));
		this.add(panelCentro,BorderLayout.CENTER);
		
		for(String cv:modelo.getDepartamentos().keySet()) {
			DepartamentoDTO departamento=modelo.getDepartamentos().get(cv);
			JPanel container=new JPanel();
			container.setLayout(new GridLayout(1,5,20,0));
			Font fuenteFila=new Font("Arial", java.awt.Font.PLAIN, 22);
			
			JLabel lNombre= new JLabel(departamento.getNombre(),SwingConstants.CENTER);
			lNombre.setFont(fuenteFila);
			container.add(lNombre);
			

			BotonSeleccion btnEditar =new BotonSeleccion("Editar");
			btnEditar.setDto(departamento);
			btnEditar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DepartamentoController.preNuevoDepartamento(modelo.getPadre(), departamento);
				}
			});
			container.add(btnEditar);
			
			BotonSeleccion boton =new BotonSeleccion("Ver");
			boton.setDto(departamento);
			boton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DepartamentoDTO departamentoSeleccionado =(DepartamentoDTO)boton.getDto();
					//VehiculoController.preVistaControlesVehiculo(modelo.getPadre(),departamentoSeleccionado);
				}
				
			});
			
			container.add(boton);
			container.setBackground(new Color(214, 234, 248));
			container.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					container.setBackground(new Color(253, 235, 208));
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					container.setBackground(new Color(214, 234, 248));
					
				}
				
			});
			panelCentro.add(container);
			validate();
		}
		
		JButton btnNuevo=new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//VehiculoController.preVistaNuevoVehiculo(null,modeloVista.getPadre());
				
			}
			
		});
		panelInferior.add(btnNuevo);
		
		
	}

}
