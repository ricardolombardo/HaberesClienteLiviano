package paneles;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controladores.UseCaseController;
import modelosVistas.FiltroModelView;
import vistas.VistaPrincipal;

public class PanelFiltro extends JPanel{
	
	private JComboBox <String> comboAnioDesde;
	private JComboBox <String> comboMesDesde;
	private JComboBox <String> comboAnioHasta;
	private JComboBox <String> comboMesHasta;
	private VistaPrincipal padre;
	
	public PanelFiltro(UseCaseController controlador,VistaPrincipal padre) {
		
		this.setLayout(new GridLayout(3,1,5,5));
		this.setBackground(Color.white);
		
		String aniosDesde[]= {"2020","2021","2022","2023"};
		String mesesDesde[]= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		String aniosHasta[]= {"2020","2021","2022","2023"};
		String mesesHasta[]= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		this.padre=padre;
		
		comboAnioDesde=new JComboBox <String>(aniosDesde);
		comboAnioDesde.setBackground(Color.white);
		comboMesDesde =new JComboBox <String>(mesesDesde);
		comboMesDesde.setBackground(Color.white);
		comboAnioHasta =new JComboBox <String>(aniosHasta);
		comboAnioHasta.setBackground(Color.white);
		comboMesHasta=new JComboBox <String>(mesesHasta);
		comboMesHasta.setBackground(Color.white);
		
		JPanel panelDesde=new JPanel();
		panelDesde.setLayout(new GridLayout(1,3,5,5));
		panelDesde.setBackground(Color.white);
		panelDesde.add(new JLabel("DESDE"));
		panelDesde.add(comboAnioDesde);
		panelDesde.add(comboMesDesde);
		this.add(panelDesde);
		
		JPanel panelHasta=new JPanel();
		panelHasta.setLayout(new GridLayout(1,3,5,5));
		panelHasta.setBackground(Color.white);
		panelHasta.add(new JLabel("HASTA"));
		panelHasta.add(comboAnioHasta);
		panelHasta.add(comboMesHasta);
		this.add(panelHasta);
		
		JButton botonFiltrar =new JButton("Filtrar");
		botonFiltrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FiltroModelView filtro=new FiltroModelView();
				filtro.setPadre(padre);
				
				filtro.setIndiceAnioDesde(comboAnioDesde.getSelectedIndex());
				filtro.setIndiceMesDesde(comboMesDesde.getSelectedIndex());
				filtro.setIndiceAnioHasta(comboAnioHasta.getSelectedIndex());
				filtro.setIndiceMesHasta(comboMesHasta.getSelectedIndex());
				
				filtro.setAnioDesde(comboAnioDesde.getSelectedItem().toString());
				filtro.setMesDesde(String.valueOf(comboMesDesde.getSelectedIndex()+1));
				filtro.setAnioHasta(comboAnioHasta.getSelectedItem().toString());
				filtro.setMesHasta(String.valueOf(comboMesHasta.getSelectedIndex()+1));
				
				controlador.ejecucionFiltro(filtro);
			}
			
		});
		this.add(botonFiltrar);
		
	}
	
	public FiltroModelView armarFiltro() {
		FiltroModelView filtro=new FiltroModelView();
		filtro.setPadre(padre);
		
		filtro.setIndiceAnioDesde(comboAnioDesde.getSelectedIndex());
		filtro.setIndiceMesDesde(comboMesDesde.getSelectedIndex());
		filtro.setIndiceAnioHasta(comboAnioHasta.getSelectedIndex());
		filtro.setIndiceMesHasta(comboMesHasta.getSelectedIndex());
		
		filtro.setAnioDesde(comboAnioDesde.getSelectedItem().toString());
		filtro.setMesDesde(String.valueOf(comboMesDesde.getSelectedIndex()+1));
		filtro.setAnioHasta(comboAnioHasta.getSelectedItem().toString());
		filtro.setMesHasta(String.valueOf(comboMesHasta.getSelectedIndex()+1));
		return filtro;
	}

	public JComboBox<String> getComboAnioDesde() {
		return comboAnioDesde;
	}

	public void setComboAnioDesde(JComboBox<String> comboAnioDesde) {
		this.comboAnioDesde = comboAnioDesde;
	}

	public JComboBox<String> getComboMesDesde() {
		return comboMesDesde;
	}

	public void setComboMesDesde(JComboBox<String> comboMesDesde) {
		this.comboMesDesde = comboMesDesde;
	}

	public JComboBox<String> getComboAnioHasta() {
		return comboAnioHasta;
	}

	public void setComboAnioHasta(JComboBox<String> comboAnioHasta) {
		this.comboAnioHasta = comboAnioHasta;
	}

	public JComboBox<String> getComboMesHasta() {
		return comboMesHasta;
	}

	public void setComboMesHasta(JComboBox<String> comboMesHasta) {
		this.comboMesHasta = comboMesHasta;
	}
	
	

}
