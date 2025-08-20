package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import DTO.EventoDTO;
import DTO.EventoNOUDTO;
import DTO.NOUDTO;
import componentesGraficos.ComboDTO;
import componentesGraficos.PanelDato;
import controladores.EventoController;

public class VistaEditorEventoNOU extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private VistaEditorEventoNOU mismo;
	private VistaPrincipal padre;
	private JDateChooser fechaDesde;
	private JDateChooser fechaHasta;
	private ComboDTO comboEventos;
	
	public VistaEditorEventoNOU(VistaPrincipal padre,EventoNOUDTO evento,List<EventoDTO>eventos,NOUDTO nou) {
		super(new JFrame(),"Editor Evento",true);
		this.setLocationRelativeTo(null);
		this.setSize(400,200);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		mismo=this;
		this.padre=padre;
		JPanel panelCentro=new JPanel();
		panelCentro.setLayout(new GridLayout(4,1,2,2));
		panelCentro.setBackground(Color.white);
		
		comboEventos=new ComboDTO();
		for(EventoDTO e:eventos) {
			comboEventos.addItem(e);
		}
		
		fechaDesde= new JDateChooser();
        fechaDesde.setDate(new Date());
		
        PanelDato datoComboEvento=new PanelDato("Desde",comboEventos);
		panelCentro.add(datoComboEvento);
        
		PanelDato datoIdentificador=new PanelDato("Desde",fechaDesde);
		panelCentro.add(datoIdentificador);

		fechaHasta= new JDateChooser();
		fechaHasta.setDate(new Date());
		PanelDato datoDescripcion=new PanelDato("Hasta",fechaHasta);
		panelCentro.add(datoDescripcion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
		        LocalDate inicio = fechaDesde.getDate().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
		        LocalDate fin = fechaHasta.getDate().toInstant()
                     .atZone(ZoneId.systemDefault())
                     .toLocalDate();

		        evento.setFechaInicio(inicio.toString());
		        evento.setFechaFin(fin.toString());
				
				evento.setEvento((EventoDTO) comboEventos.getSelectedItem());
				EventoController.posNuevoEventoNOU(padre, evento,nou);
				mismo.dispose();
			}
		});
		
		panelCentro.add(btnAceptar);
		panelCentro.setBorder(new EmptyBorder(10, 10, 10, 10));
		validate();
		
		this.add(panelCentro,BorderLayout.CENTER);
	}

}
