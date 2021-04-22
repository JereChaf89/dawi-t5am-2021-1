package org.ciberfarma.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ciberfarma.modelo.Usuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class FrmCrudUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblClave;
	private JTextField txtClave;
	private JTextField txtFecha;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblNacimiento;
	private JLabel lblTipo;
	private JTextField txtTipo;
	private JLabel lblEstado;
	private JTextField txtEstado;
	private JButton btnRegistrar;
	private JTextField txtCodigo;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudUsuario frame = new FrmCrudUsuario();
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
	public FrmCrudUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(73, 57, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(15, 60, 75, 14);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblNewLabel);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(15, 97, 75, 14);
		lblApellido.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(73, 94, 86, 20);
		txtApellido.setColumns(10);
		contentPane.add(txtApellido);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(15, 134, 75, 14);
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(73, 131, 86, 20);
		txtUsuario.setColumns(10);
		contentPane.add(txtUsuario);
		
		lblClave = new JLabel("Clave");
		lblClave.setBounds(15, 169, 75, 14);
		lblClave.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblClave);
		
		txtClave = new JTextField();
		txtClave.setBounds(73, 166, 86, 20);
		txtClave.setColumns(10);
		contentPane.add(txtClave);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(73, 207, 86, 20);
		txtFecha.setColumns(10);
		contentPane.add(txtFecha);
		
		lblFechaDeNacimiento = new JLabel("Fecha de");
		lblFechaDeNacimiento.setBounds(15, 202, 75, 20);
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblFechaDeNacimiento);
		
		lblNacimiento = new JLabel("Nacimiento");
		lblNacimiento.setFont(new Font("Arial", Font.BOLD, 12));
		lblNacimiento.setBounds(10, 215, 75, 20);
		contentPane.add(lblNacimiento);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Arial", Font.BOLD, 12));
		lblTipo.setBounds(15, 241, 75, 14);
		contentPane.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(73, 238, 86, 20);
		contentPane.add(txtTipo);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Arial", Font.BOLD, 12));
		lblEstado.setBounds(15, 269, 75, 14);
		contentPane.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(73, 266, 86, 20);
		contentPane.add(txtEstado);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		btnRegistrar.setBounds(289, 44, 106, 39);
		contentPane.add(btnRegistrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(289, 142, 106, 39);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(289, 190, 106, 39);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(289, 94, 106, 39);
		contentPane.add(btnBuscar);
		
		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setFont(new Font("Arial", Font.BOLD, 12));
		lblCdigo.setBounds(15, 29, 75, 14);
		contentPane.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(73, 26, 86, 20);
		contentPane.add(txtCodigo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 294, 488, 138);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(397, 255, 99, 33);
		contentPane.add(btnListado);
	}
	
	void listado() {
		//Obtener un listado de los usuarios
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		//TypedQuery<Usuario> consulta = em.createNamedQuery("Usuario.findAll", Usuario.class);
		//List<Usuario> lstUsuarios = consulta.getResultList();
		
		TypedQuery<Usuario> consulta = em.createNamedQuery("Usuario.findAllWithType", Usuario.class);
		consulta.setParameter("xtipo", 1);
		List<Usuario> lstUsuarios = consulta.getResultList();
		em.close();
		
		//Pasar el listado a los campos
		for(Usuario u : lstUsuarios) {
			txtS.append(u.getCodigo() + "\t" + u.getNombre() + "\t" + u.getApellido() + "\n");
		}
		
	}
	
	void registrar() {
		String nom, ape, clave, fecha;
		int tipo, estado;
		
		nom = leerNombre();
		ape = leerApellido();
		clave = leerClave();
		fecha = txtFecha.getText();
		tipo = Integer.parseInt(txtTipo.getText());
		estado = Integer.parseInt(txtEstado.getText());
		
		//Validación
		if(nom == null || ape == null || clave == null || fecha == null || tipo == 0 || estado == 0){
			JOptionPane.showMessageDialog(this, "Complete el o los campos faltantes");
				} else{
					Usuario u = new Usuario();
					u.setNombre(nom);
					u.setApellido(ape);
					u.setClave(clave);
					u.setFnacim(fecha);
					u.setTipo(tipo);
					u.setEstado(estado);
					
					// grabar el objeto
					// 1. fabricar el acceso a los datos
					EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
					// 2. crear el manejador de entidades
					EntityManager em = fabrica.createEntityManager();
					
					// 3. empezar mi transacci�n
					em.getTransaction().begin();
					// proceso a realizar (persistencia)
					em.persist(u);
					//em.merge(u);
					// 4. confirmar la transacci�n
					em.getTransaction().commit();
					System.out.println("Registro agregado");
					JOptionPane.showConfirmDialog(null, "Registro completado");
					em.clear();
	    }
	}
	
	private String leerNombre() {
		String masc = null;
		if(txtNombre.getText().matches("^[a-zA-Z]{1,30}$")){
			masc = txtNombre.getText();
		}
		else {
			JOptionPane.showMessageDialog(this, "Solo se permiten letras");
		}
		return masc;
	}
	
	private String leerApellido() {
		String masc = null;
		if(txtApellido.getText().matches("^[a-zA-Z]{1,30}$")){
			masc = txtApellido.getText();
		}
		else {
			JOptionPane.showMessageDialog(this, "Solo se permiten letras");
		}
		return masc;
	}
	
	private String leerClave() {
		String clave = null;
		
		if(txtClave.getText().matches("^[a-zA-Z]{1,10}[0-9]{1,5}$")){
			clave =  txtClave.getText();
		}
		else {
			JOptionPane.showMessageDialog(this, "No se permiten símbolos. Solo letras y números");
		}
		return clave;
	}
	
	void buscar() {
		int codigo = leerCodigo();
		
		//buscar en la tabla, para obtener un Usuario
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();

		Usuario u = em.find(Usuario.class, codigo);
		em.close();
		if(u == null) {
			aviso("Usuario" + codigo + "No existe!");
		} else {
			txtNombre.setText(u.getNombre());
			txtApellido.setText(u.getApellido());
		}
	}

	private void aviso(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Aviso del sistema", 2);
	}

	private int leerCodigo() {
		int cod = 0;
		cod=Integer.parseInt(txtCodigo.getText());
		return cod;
	}
}