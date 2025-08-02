package vistas;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import componentesVisuales.BotonPrincipal;
import controladores.DepartamentoController;
import controladores.JerarquiaController;
import controladores.LiquidacionController;
import controladores.PersonaController;
import servicios.ServicioJerarquias;
import servicios.ServicioLiquidaciones;

public class VistaPrincipal extends Vista{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VistaPrincipal mismo;
	
	public VistaPrincipal() {
		super("Liquidacion de Haberes");
		mismo=this;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Botones
		BotonPrincipal btnPersonas=new BotonPrincipal("Personas");
		btnPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonaController.preVisualizarPersonas(mismo);
			}

		});
		agregarBoton(btnPersonas);
		
		BotonPrincipal btnDepartamentos=new BotonPrincipal("Departamentos");
		btnDepartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartamentoController.preVistaDepartamentos(mismo);
			}

		});
		agregarBoton(btnDepartamentos);
		
		BotonPrincipal btnJerarquias=new BotonPrincipal("Jerarquias");
		btnJerarquias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ServicioJerarquias.getJerarquias();
				JerarquiaController.preVisualizarJerarquias(mismo);
			}

		});
		agregarBoton(btnJerarquias);
		
		String nombreRecurso="Configuraciones";
		BotonPrincipal btnConfiguraciones=new BotonPrincipal(nombreRecurso);
		btnConfiguraciones.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Container contBtn=new Container();
				contBtn.setLayout(null);
				
				JButton btnMarcas=new JButton("Marcas");
				btnMarcas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					}
				});
				btnMarcas.setBounds(0, 5, 140,30);
				contBtn.add(btnMarcas);
				
				JButton btnModelos=new JButton("Modelos");
				btnModelos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					}
				});
				btnModelos.setBounds(0,contBtn.getComponentCount()*40, 140,30);
				contBtn.add(btnModelos);

				contBtn.setMaximumSize(new Dimension(300,contBtn.getComponentCount()*40));
				getPanelBotones().actualizarDesplegado(contBtn,nombreRecurso);
				
				JButton btnTipos=new JButton("Tipos");
				btnTipos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					}
				});
				btnTipos.setBounds(0,contBtn.getComponentCount()*40, 140,30);
				contBtn.add(btnTipos);

				contBtn.setMaximumSize(new Dimension(300,contBtn.getComponentCount()*40));
				getPanelBotones().actualizarDesplegado(contBtn,nombreRecurso);
				
				
				JButton btnFiltros=new JButton("Filtros");
				btnFiltros.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					}
				});
				btnFiltros.setBounds(0,contBtn.getComponentCount()*40, 140,30);
				contBtn.add(btnFiltros);

				contBtn.setMaximumSize(new Dimension(300,contBtn.getComponentCount()*40));
				getPanelBotones().actualizarDesplegado(contBtn,nombreRecurso);
				
				
			}

		});
		agregarBoton(btnConfiguraciones);
		BotonPrincipal btnLiquidaciones=new BotonPrincipal("Liquidaciones");
		btnLiquidaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LiquidacionController.preVisualizarLiquidaciones(mismo);
			}

		});
		agregarBoton(btnLiquidaciones);
		
	}
	
	
}
