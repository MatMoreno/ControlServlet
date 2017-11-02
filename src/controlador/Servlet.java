package controlador;

import modelo.Usuario;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conexion;
	private final String usuario = "root";
	private final String password = "root";
	private final String url_bd = "jdbc:mysql://localhost:3306/controlservlet";
	private final String driver = "com.mysql.jdbc.Driver";

	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String error = "false";
		String baseJsp = "/ControlServlet/Servlet";
		request.setAttribute("baseJsp", baseJsp);
		String base = "/jsp/";
		String url = base + "index.jsp";
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "irEjercicio1":
            ArrayList<String> arrayL=arrayListUrls();
            System.out.println(arrayL);
            sesion.setAttribute("arrayL", arrayL);
				url = base + "ejercicio1.jsp";
				break;
			case "cerrarSesion":
				sesion.invalidate();
				break;
			case "irEjercicio2":
				url = base + "ejercicio2.jsp";
				break;
			case "botonLogin":
				if(login(request)==true) {
					System.out.println("exito");
					sesion.setAttribute("logExito", true);
				url = base + "ejercicio2.jsp";
				}else {
					System.out.println("fail");
					url = base + "ejercicio2.jsp";
				}
				break;

			default:
				break;
			}
		}
		request.getRequestDispatcher(url).forward(request, response);

	}
	public ArrayList<String> arrayListUrls(){
		ArrayList<String> lista=new ArrayList<>();
		lista.add("https://www.google.es/");
		lista.add("https://www.youtube.com");
		lista.add("https://www.facebook.com");
		lista.add("https://www.twitter.com");
		lista.add("https://www.marca.com");
		System.out.println(lista);
		return lista;
		
	}

	public boolean login(HttpServletRequest request) {
		Connection con = getConexion();
		String usuario = request.getParameter("usuario");
		String contra=request.getParameter("contra");
	System.out.println(usuario+" "+contra);
		Boolean bool = false;
		try {
			PreparedStatement miStatement = con.prepareStatement("Select * from usuarios where usuario='"+usuario+"' and clave='"+contra+"'");
			ResultSet miResultSet = miStatement.executeQuery();
			System.out.println(miResultSet.getRow());
			if (miResultSet.next()) {
				System.out.println(miResultSet.getString("usuario"));
				bool = true;
			} else {

				bool = false;
			}
		} catch (SQLException e) {

		}
		return bool;

	}

	public Connection getConexion() {
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url_bd, usuario, password);
			System.out.println("¡Estás conectado a la BBDD !");
		} catch (SQLException e) {
			System.out.println("ERROR de conexión: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
}
