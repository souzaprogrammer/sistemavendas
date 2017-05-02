package br.com.farmacia.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.farmacia.dao.FornecedoresDao;
import br.com.farmacia.entidades.Fornecedores;

public class ConexaoFactory {
private static final String USUARIO="root";
private static final String SENHA="usbw";
private static final String URL="jdbc:mysql://localhost:3306/sistemavendas";
static Fornecedores f=new Fornecedores();
static FornecedoresDao fdao=new FornecedoresDao();
public static Connection conectar() throws SQLException
{
	Connection con=DriverManager.getConnection(URL, USUARIO, SENHA);
	return con;
}
public static void main(String[] args)
{
	//cadastrarFornecedores();
	JOptionPane.showMessageDialog(null, "ola mundo" );
	
}
public static void testarConexao()
{
	try {
		Connection c=ConexaoFactory.conectar();
		JOptionPane.showMessageDialog(null, "conectado com sucesso");
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"erro de conexaoe\n "+e.getErrorCode());
		e.printStackTrace();
	}
}
public static void cadastrarFornecedores()
{
	
	
	try {
		
			f.setDescricao("João Ribeiro");
		fdao.cadastrar(f);
		JOptionPane.showMessageDialog(null, "conectado com sucesso");
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "erro ao cadastrar "+e.getMessage());
		e.printStackTrace();
	}
	
}
}
