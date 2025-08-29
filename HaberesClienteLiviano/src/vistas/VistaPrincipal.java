package vistas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import componentesVisuales.BotonPrincipal;
import controladores.DepartamentoController;
import controladores.EventoController;
import controladores.JerarquiaController;
import controladores.LiquidacionController;
import controladores.PersonaController;
import controladores.Principal;

public class VistaPrincipal extends Vista{

	private static final long serialVersionUID = 1L;
	private VistaPrincipal mismo;
	
	public VistaPrincipal() {
		super("Liquidacion de Haberes "+Principal.modo);
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

				JButton btnMarcas=new JButton("Conceptos");
				btnMarcas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					}
				});
				agregarBotonInterno( contBtn, btnMarcas, nombreRecurso);
				
				JButton btnEventos=new JButton("Eventos");
				btnEventos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EventoController.preVisualizarEventos(mismo);
					}
				});
				agregarBotonInterno( contBtn, btnEventos, nombreRecurso);
				
				JButton btnFiltros=new JButton("Filtros");
				agregarBotonInterno( contBtn, btnFiltros, nombreRecurso);
				
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
