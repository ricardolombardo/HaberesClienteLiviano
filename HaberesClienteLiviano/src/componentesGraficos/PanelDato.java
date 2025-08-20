package componentesGraficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;


public class PanelDato extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lNombre;
	private JLabel lDato1;
	private JLabel lDato2;
	
	public PanelDato(String nombre, String dato) {
		lNombre= new JLabel(nombre,SwingConstants.CENTER);
		lDato1=new JLabel(dato);
		this.setLayout(new GridLayout(1,2,5,5));
		Font fuenteFila=new Font("Arial", java.awt.Font.PLAIN, 22);
		lNombre.setFont(fuenteFila);
		lDato1.setFont(fuenteFila);
		this.add(lNombre);
		this.add(lDato1);
	}
	
	public PanelDato(String nombre, JTextField dato) {
		lNombre= new JLabel(nombre,SwingConstants.CENTER);
		lNombre.setBackground(Color.white);
		this.setLayout(new GridLayout(1,2,5,5));
		Font fuenteFila=new Font("Arial", java.awt.Font.PLAIN, 22);
		lNombre.setFont(fuenteFila);
		this.add(lNombre);
		this.add(dato);
	}
	
	public PanelDato(String nombre, JDateChooser dato) {
		lNombre= new JLabel(nombre,SwingConstants.CENTER);
		lNombre.setBackground(Color.white);
		this.setLayout(new GridLayout(1,2,5,5));
		Font fuenteFila=new Font("Arial", java.awt.Font.PLAIN, 22);
		lNombre.setFont(fuenteFila);
		this.add(lNombre);
		this.add(dato);
	}
	
	public PanelDato(String nombre, ComboDTO dato) {
		lNombre= new JLabel(nombre,SwingConstants.CENTER);
		lNombre.setBackground(Color.white);
		this.setLayout(new GridLayout(1,2,5,5));
		Font fuenteFila=new Font("Arial", java.awt.Font.PLAIN, 22);
		lNombre.setFont(fuenteFila);
		this.add(lNombre);
		this.add(dato);
	}
	
	public PanelDato(String nombre, String dato, JButton btn) {
		lNombre= new JLabel(nombre,SwingConstants.CENTER);
		lDato1=new JLabel(dato,SwingConstants.CENTER);
		this.setLayout(new GridLayout(1,3,5,5));
		Font fuenteFila=new Font("Arial", java.awt.Font.PLAIN, 22);
		lNombre.setFont(fuenteFila);
		lDato1.setFont(fuenteFila);
		
		this.add(lNombre);
		this.add(lDato1);
		if(btn!=null) {
			this.add(btn);	
		}else {
			this.add(new JPanel());	
		}
		
		this.setBackground(new Color(214, 234, 248));
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(253, 235, 208));	
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(214, 234, 248));
			}
		});
	}
	
	public PanelDato(String nombre, String dato1,String dato2, JButton btn) {
		lNombre= new JLabel(nombre,SwingConstants.CENTER);
		lDato1=new JLabel(dato1);
		lDato2=new JLabel(dato2);
		
		this.setLayout(new GridLayout(1,4,5,5));
		Font fuenteFila=new Font("Arial", java.awt.Font.PLAIN, 22);
		
		lNombre.setFont(fuenteFila);
		lDato1.setFont(fuenteFila);
		lDato2.setFont(fuenteFila);
		
		this.add(lNombre);
		this.add(lDato1);
		this.add(lDato2);
		if(btn!=null) {
			this.add(btn);	
		}else {
			this.add(new JPanel());	
		}
		
		this.setBackground(new Color(214, 234, 248));
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(253, 235, 208));	
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(214, 234, 248));
			}
		});
	}
	

	public JLabel getlNombre() {
		return lNombre;
	}

	public void setlNombre(JLabel lNombre) {
		this.lNombre = lNombre;
	}

	public JLabel getlDato1() {
		return lDato1;
	}

	public void setlDato1(JLabel lDato1) {
		this.lDato1 = lDato1;
	}

	public JLabel getlDato2() {
		return lDato2;
	}

	public void setlDato2(JLabel lDato2) {
		this.lDato2 = lDato2;
	}
	
	
}