package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import DTO.LiquidacionDTO;
import DTO.TareaDTO;
import DTO.TareaLiquidacionDTO;
import componentesGraficos.ComboDTO;
import componentesGraficos.PanelDato;
import controladores.LiquidacionController;
import modelosVistas.FiltroModelView;

public class VistaEditorTareasLiquidacion extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private VistaEditorTareasLiquidacion mismo;
	private VistaPrincipal padre;
	private ComboDTO comboTareas;
	private JTextField orden;
	
	private JPanel panelInferior; // Se declara aquí
	
	public VistaEditorTareasLiquidacion(LiquidacionDTO liquidacion, List<TareaDTO> tareas,FiltroModelView filtro) {
		
		super(new JFrame(), "Editor Evento", true);
		this.setLocationRelativeTo(null);
		this.setSize(500,350);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		mismo = this;
		this.padre = padre;
		JPanel panelCentro = new JPanel(new BorderLayout());
		panelCentro.setBackground(Color.white);
		
		// Panel superior
		JPanel panelSuperior = new JPanel(new BorderLayout());
		comboTareas = new ComboDTO();
		for (TareaDTO tarea : tareas) {
			comboTareas.addItem(tarea);
		}
		orden = new JTextField();
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TareaLiquidacionDTO tl = new TareaLiquidacionDTO();
				TareaDTO tarea = (TareaDTO) comboTareas.getSelectedItem();
				tl.setIdTarea(tarea.getId());
				tl.setIdLiquidacion(liquidacion.getId());
				tl.setNombreTarea(tarea.getNombre());
				tl.setOrden(Integer.parseInt(orden.getText()));
				liquidacion.getTareas().add(tl);
				cargarPanelTareasLiquidacion(liquidacion);
			}
		});
		
		PanelDato selectorTarea = new PanelDato("Tarea", comboTareas, orden, btnAgregar);
		panelSuperior.add(selectorTarea, BorderLayout.CENTER);
		
		// Panel inferior inicializado una sola vez
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.white);
		panelInferior.setLayout(new GridLayout(10, 1, 5, 5));
		
		// Cargo las tareas iniciales
		cargarPanelTareasLiquidacion(liquidacion);
		
		panelCentro.add(panelSuperior, BorderLayout.NORTH);
		panelCentro.add(panelInferior, BorderLayout.CENTER);
		
		JButton btnAceptar=new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LiquidacionController.preCrearTareasLiquidacion(liquidacion.getTareas(), filtro);
				mismo.dispose();
			}
			
		});
		
		this.add(panelCentro, BorderLayout.CENTER);
		this.add(btnAceptar, BorderLayout.SOUTH);
	}
	
	public void cargarPanelTareasLiquidacion(LiquidacionDTO liquidacion) {
		panelInferior.removeAll(); // Limpio el panel actual
		panelInferior.add(new PanelDato("Nombre", "Orden"));
		int cantRows = 10;
		if (liquidacion.getTareas() != null && !liquidacion.getTareas().isEmpty()) {
			for (TareaLiquidacionDTO t : liquidacion.getTareas()) {
				System.out.println(t.getNombreTarea()+" "+String.valueOf(t.getOrden()));
				panelInferior.add(new PanelDato(t.getNombreTarea(), String.valueOf(t.getOrden())));
			}
		}
		
		panelInferior.revalidate();
		panelInferior.repaint();
	}
}

