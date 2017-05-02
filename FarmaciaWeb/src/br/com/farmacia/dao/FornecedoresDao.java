package br.com.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.entidades.Fornecedores;
import br.com.farmacia.factory.ConexaoFactory;

public class FornecedoresDao {
	PreparedStatement pstm;
	ResultSet res;
	Connection con;
	StringBuilder stb=new StringBuilder();
	public void cadastrar(Fornecedores f) throws SQLException
	{
		//definindo a conexão com o banco de dados
		 con=ConexaoFactory.conectar();
		//definindo o comamdo sql
		 stb=new StringBuilder();
		stb.append(" insert into fornecedores ");
		stb.append(" (descricao)" );
		stb.append(" values(?) " );
		//preparando o comando sql
		 pstm=con.prepareStatement(stb.toString());
		 //definindo os valores para o comando sql
		 pstm.setString(1,f.getDescricao());
		//executando o comando sql 
		 pstm.executeUpdate();
		
	}
	public void editar(Fornecedores f)throws SQLException
	{
		//definindo a conexao com o banco de dados
		con=ConexaoFactory.conectar();
		//definindo o comando sql
		stb.append(" update from fornecedores ");
		stb.append(" set descricao = ?");
		stb.append(" where codigo = ? ");
		//preparando o comando sql
		pstm=con.prepareStatement(stb.toString());
		//definindo valores para o comando sql
		pstm.setString(1, f.getDescricao());
		pstm.setInt(2,f.getCodigo());
		//executando o comando sql
		pstm.executeUpdate();
		
	}
	public Fornecedores buscarporcodigo(Fornecedores f) throws SQLException
	{
		//definindo a conexao com o banco de dados
				con=ConexaoFactory.conectar();
				//definindo o comando sql
				stb.append(" select * from fornecedores  ");
				
				stb.append(" where codigo = ? ");
				//preparando o comando sql
				pstm=con.prepareStatement(stb.toString());
				//definindo valores para o comando sql
				
				pstm.setInt(1,f.getCodigo());
				//executando o comando sql
				 res=pstm.executeQuery();
				 Fornecedores forn=null;
				 if(res.next())
				 {
					 forn=new Fornecedores();
					 forn.setCodigo(res.getInt("codigo"));
					 forn.setDescricao(res.getString("descricao"));
				 }
				 return forn;
	}
	public ArrayList<Fornecedores>listar() throws SQLException
	{
		//definindo a conexao com o banco de dados
		con=ConexaoFactory.conectar();
		//definindo o comando sql
		stb.append(" select * from fornecedores ");
		res=pstm.executeQuery();
		ArrayList<Fornecedores>lista=new ArrayList<Fornecedores>();
		while(res.next())
		{
			Fornecedores forn=new Fornecedores();
			forn.setCodigo(res.getInt("codigo"));
			forn.setDescricao(res.getString("descricao"));
			lista.add(forn);
		}
		return lista;
	}

}

