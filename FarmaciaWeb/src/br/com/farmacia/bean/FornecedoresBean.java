package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.farmacia.dao.FornecedoresDao;
import br.com.farmacia.entidades.Fornecedores;

@ManagedBean
@ViewScoped
public class FornecedoresBean {
private ListDataModel <Fornecedores> itens;
public ListDataModel<Fornecedores> getItens() {
	return itens;
}
public void setItens(ListDataModel<Fornecedores> itens) {
	this.itens = itens;
}

@PostConstruct
public void prepararPesquisa()
{
	FornecedoresDao fdao=new FornecedoresDao();
	try {
		ArrayList<Fornecedores>lista=fdao.listar();
		itens=new ListDataModel<Fornecedores>(lista);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
