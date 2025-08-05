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
import DTO.LiquidacionDTO;
import componentesGraficos.BotonSeleccion;
import controladores.LiquidacionController;
import controladores.TabuladosController;
import modelosVistas.PanelLiquidacionesModelView;
import servicios.ServicioLiquidaciones;

public class PanelLiquidaciones extends PanelVista{

	private static final long serialVersionUID = 1L;
	private PanelLiquidacionesModelView modeloVista;
	
	public PanelLiquidaciones(PanelLiquidacionesModelView modelo) {
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.modeloVista=modelo;
		
		setTituloPrincipal("Liquidaciones");
		panelCentro=new JPanel();
		panelCentro.setLayout(new GridLayout(20,1,5,5));
		panelCentro.setBackground(Color.white);
		titulos=new JPanel();
		titulos.setLayout(new GridLayout(1,8,0,0));
		
		panelInferior=new JPanel();
		panelInferior.setLayout(new GridLayout(1,8,1,1));
		panelInferior.setBackground(Color.white);
		this.add(panelInferior,BorderLayout.SOUTH);
		
		this.setearTitulos("AÑO");
		this.setearTitulos("MES");
		this.setearTitulos("DESCRIPCION");
		this.setearTitulos("LIQUIDADA");
		this.setearTitulos("Editar");
		this.setearTitulos("Ver");
		this.setearTitulos("Liquidar");
		panelCentro.add(titulos);
		titulos.setBackground(new Color(169, 223, 191));
		this.add(panelCentro,BorderLayout.CENTER);
		
		for(String cv:modelo.getLiquidaciones().keySet()) {
			LiquidacionDTO liqudiacion=modelo.getLiquidaciones().get(cv);
			JPanel container=new JPanel();
			container.setLayout(new GridLayout(1,5,20,0));
			Font fuenteFila=new Font("Arial", java.awt.Font.PLAIN, 22);
			
			JLabel lAnio= new JLabel(String.valueOf(liqudiacion.getAnio()),SwingConstants.CENTER);
			lAnio.setFont(fuenteFila);
			container.add(lAnio);
			
			JLabel lMes= new JLabel(String.valueOf(liqudiacion.getMes()),SwingConstants.CENTER);
			lMes.setFont(fuenteFila);
			container.add(lMes);
			
			JLabel lDescripcion= new JLabel(liqudiacion.getDescripcion(),SwingConstants.CENTER);
			lDescripcion.setFont(fuenteFila);
			container.add(lDescripcion);
			
			JLabel lLiquidada;
			if(liqudiacion.getLiquidada()) {
				lLiquidada= new JLabel("Si ("+liqudiacion.getTabulados().size()+")",SwingConstants.CENTER);
			}else {
				lLiquidada= new JLabel("No",SwingConstants.CENTER);
			}
			lLiquidada.setFont(fuenteFila);
			container.add(lLiquidada);

			BotonSeleccion btnEditar =new BotonSeleccion("Editar");
			btnEditar.setDto(liqudiacion);
			btnEditar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
				
			});
			container.add(btnEditar);
			
			BotonSeleccion boton =new BotonSeleccion("Ver");
			boton.setDto(liqudiacion);
			boton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					LiquidacionDTO seleccionado=(LiquidacionDTO) boton.getDto();
					if(liqudiacion.getTabulados()!=null) {
						LiquidacionController.posVerTabuladosLiquidacion(liqudiacion, modelo.getPadre());
					}else {
						TabuladosController.getTabuladosLiquidacion(seleccionado.getId(), modelo.getPadre());
					}
				}
				
			});
			container.add(boton);
			
			BotonSeleccion botonLiquidar =new BotonSeleccion("Liquidar");
			botonLiquidar.setDto(liqudiacion);
			botonLiquidar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					LiquidacionDTO liquidacionSeleccionada=(LiquidacionDTO) botonLiquidar.getDto();
					ServicioLiquidaciones.liquidar(liquidacionSeleccionada);
				}
				
			});
			container.add(botonLiquidar);
			if(liqudiacion.getLiquidada()) {
				botonLiquidar.setEnabled(Boolean.FALSE);
			}
			
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
				LiquidacionController.preNuevaLiquidacion(modelo.getPadre(),new LiquidacionDTO());
				
			}
			
		});
		panelInferior.add(btnNuevo);
		
	}
	
}
