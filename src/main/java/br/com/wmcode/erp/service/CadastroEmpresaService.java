package br.com.wmcode.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.wmcode.erp.model.Empresa;
import br.com.wmcode.erp.repository.Empresas;
import br.com.wmcode.erp.util.Transacional;

public class CadastroEmpresaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresas.guardar(empresa);
	}
	
	@Transacional
	public void excluir(Empresa empresa) {
		empresas.remover(empresa);
	}

}
