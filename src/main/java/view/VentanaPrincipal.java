package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorEstudiante;
import controller.ControladorMateria;
import controller.ControladorMunicipio;
import controller.ControladorNota;
import controller.ControladorProfesor;
import controller.ControladorValoracionMateria;
import model.Estudiante;
import model.Materia;
import model.Nota;
import model.Profesor;
import model.Provincia;
import model.Valoracionmateria;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JList jListNoSelec;
	private JList jListSelec;
	private DefaultListModel<Estudiante> listModelEstudianteSelec = null;
	private DefaultListModel<Estudiante> listModelEstudianteNoSelec = null;
	private List<Estudiante> estudiantes = ControladorEstudiante.findAll();
	private int indiceProximaEstudianteParaAgregar = 0;
	private JComboBox<Nota> jcbNota;
	private JComboBox<Profesor> jcbProfesor; 
	private JComboBox<Materia> jcbMateria; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(187, 187, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNewLabel_2 = new JLabel("Nota:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbNota = new JComboBox<Nota>();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel.add(jcbNota, gbc_jcbNota);
		
		JButton bActualizar = new JButton("Botón actualizar alumnado");
		bActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_bActualizar = new GridBagConstraints();
		gbc_bActualizar.anchor = GridBagConstraints.EAST;
		gbc_bActualizar.gridx = 1;
		gbc_bActualizar.gridy = 3;
		panel.add(bActualizar, gbc_bActualizar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 181));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Alumnado no seleccionado");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Alumnado seleccionado");
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1.gridx = 11;
		gbc_lblNewLabel_3_1.gridy = 0;
		panel_1.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		jListNoSelec = new JList(this.getDefaultListModelNoSelec());
		this.jListNoSelec.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(jListNoSelec);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(248, 153, 107));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 5;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 4;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton bNoselec = new JButton("<<");
		bNoselec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarTodosANoSeleccionados();
			}
		});
		GridBagConstraints gbc_bNoselec = new GridBagConstraints();
		gbc_bNoselec.insets = new Insets(0, 0, 5, 5);
		gbc_bNoselec.gridx = 2;
		gbc_bNoselec.gridy = 1;
		panel_2.add(bNoselec, gbc_bNoselec);
		
		JButton bAnterior = new JButton("<");
		bAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarANoSeleccionados();
			}
		});
		GridBagConstraints gbc_bAnterior = new GridBagConstraints();
		gbc_bAnterior.insets = new Insets(0, 0, 5, 5);
		gbc_bAnterior.gridx = 2;
		gbc_bAnterior.gridy = 2;
		panel_2.add(bAnterior, gbc_bAnterior);
		
		JButton bSiguiente = new JButton(">");
		bSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarASeleccionados();
			}
		});
		GridBagConstraints gbc_bSiguiente = new GridBagConstraints();
		gbc_bSiguiente.insets = new Insets(0, 0, 5, 5);
		gbc_bSiguiente.gridx = 2;
		gbc_bSiguiente.gridy = 3;
		panel_2.add(bSiguiente, gbc_bSiguiente);
		
		JButton bSelec = new JButton(">>");
		bSelec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarTodosASeleccionados();
			}
		});
		GridBagConstraints gbc_bSelec = new GridBagConstraints();
		gbc_bSelec.insets = new Insets(0, 0, 0, 5);
		gbc_bSelec.gridx = 2;
		gbc_bSelec.gridy = 4;
		panel_2.add(bSelec, gbc_bSelec);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 9;
		gbc_scrollPane_1.gridy = 1;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		jListSelec = new JList(this.getDefaultListModelSelec());
		this.jListSelec.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane_1.setViewportView(jListSelec);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		contentPane.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton guardar = new JButton("Guardar las notas de todos los alumnos seleccionados");
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_guardar = new GridBagConstraints();
		gbc_guardar.insets = new Insets(0, 0, 0, 5);
		gbc_guardar.gridx = 10;
		gbc_guardar.gridy = 2;
		panel_3.add(guardar, gbc_guardar);
		
		cargarCombos();
		agregarEstudiantes();
	}
	
	
	/**
	 * 
	 * @return
	 */
	private DefaultListModel getDefaultListModelSelec () {
		this.listModelEstudianteSelec = new DefaultListModel<Estudiante>();
		return this.listModelEstudianteSelec;
	}
	
	/**
	 * 
	 * @return
	 */
	private DefaultListModel getDefaultListModelNoSelec () {
		this.listModelEstudianteNoSelec = new DefaultListModel<Estudiante>();
		return this.listModelEstudianteNoSelec;
	}
	
	/**
	 * 
	 */
	private void guardar () {
		
		Materia m = (Materia) jcbMateria.getSelectedItem();
		Profesor p = (Profesor) jcbProfesor.getSelectedItem();
		Nota n = (Nota) jcbNota.getSelectedItem();
		List<Estudiante> listaParaGuardar = new ArrayList<Estudiante>();
		
		
		for (int i = listModelEstudianteSelec.getSize() -1; i >= 0  ; i--) {
			listaParaGuardar.add( (Estudiante) listModelEstudianteSelec.getElementAt(i));
		}

		for (Estudiante e : listaParaGuardar) {
			Valoracionmateria v = new Valoracionmateria();
			v.setEstudiante(e);
			v.setMateria(m);
			v.setProfesor(p);
			v.setValoracion(n.getNota());
			ControladorValoracionMateria.guardar(v);
		}	
	}
			
		

	
	/**
	 * 
	 */
	private void agregarEstudiantes() {
		
		if (estudiantes != null) {
			for (Estudiante e : estudiantes) {
				this.listModelEstudianteNoSelec.add(indiceProximaEstudianteParaAgregar, e);
				indiceProximaEstudianteParaAgregar++;
			}	
		}
	}
	
	/**
	 * 
	 */
	private void pasarASeleccionados() {
		for (int i = this.jListNoSelec.getSelectedIndices().length - 1; i >= 0; i--) {
			
//			if (this.jListNoSelec.getSelectedIndices().length == 1) {
//				this.listModelEstudianteSelec.add(i,(Estudiante) jListNoSelec.getSelectedValue());
//			} else {
//				this.listModelEstudianteSelec.addElement(this.listModelEstudianteNoSelec.get(i));
//			}
			this.listModelEstudianteSelec.addElement(this.listModelEstudianteNoSelec.get(this.jListNoSelec.getSelectedIndices()[i]));
			this.listModelEstudianteNoSelec.removeElementAt(this.jListNoSelec.getSelectedIndices()[i]);
		}
	}
	
	/**
	 * 
	 */
	private void pasarANoSeleccionados() {
		for (int i = this.jListSelec.getSelectedIndices().length - 1; i >= 0; i--) {
			
//			if (this.jListSelec.getSelectedIndices().length == 1) {
//				this.listModelEstudianteNoSelec.add(i,(Estudiante) jListSelec.getSelectedValue());
//			} else {
//				this.listModelEstudianteNoSelec.addElement(this.listModelEstudianteSelec.get(i));
//			}
			
			this.listModelEstudianteNoSelec.addElement(this.listModelEstudianteSelec.get(this.jListSelec.getSelectedIndices()[i]));
			this.listModelEstudianteSelec.removeElementAt(this.jListSelec.getSelectedIndices()[i]);
		}
	}
	
	
	/**
	 * 
	 */
	private void pasarTodosASeleccionados() {
		
		listModelEstudianteNoSelec.removeAllElements();
		listModelEstudianteSelec.removeAllElements();
		listModelEstudianteSelec.addAll(estudiantes);

		
	}
	
	/**
	 * 
	 */
	private void pasarTodosANoSeleccionados() {
		
		listModelEstudianteSelec.removeAllElements();
		listModelEstudianteNoSelec.removeAllElements();
		listModelEstudianteNoSelec.addAll(estudiantes);

	}
	
	
	private void cargarCombos() {
		
		cargarComboMateria();
		cargarComboProfesor();
		cargarComboNota();
		
	}
	
	private void cargarComboMateria() {
		
		List<Materia> lista = ControladorMateria.findAll();
		
		if (lista != null) {
			for (Materia m : lista) {
				this.jcbMateria.addItem(m);
			}	
		}
		
	}
	
	private void cargarComboProfesor() {
		
		List<Profesor> lista = ControladorProfesor.findAll();
		
		if (lista != null) {
			for (Profesor p : lista) {
				this.jcbProfesor.addItem(p);
			}	
		}
		
	}
	
	private void cargarComboNota() {
		
		List<Nota> lista = ControladorNota.findAll();
		
		if (lista != null) {
			for (Nota n : lista) {
				this.jcbNota.addItem(n);
			}	
		}
		
	}

}
