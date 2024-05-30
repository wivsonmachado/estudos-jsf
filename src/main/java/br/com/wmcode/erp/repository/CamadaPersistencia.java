package br.com.wmcode.erp.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wmcode.erp.model.Empresa;
import br.com.wmcode.erp.model.RamoAtividade;
import br.com.wmcode.erp.model.TipoEmpresa;

public class CamadaPersistencia {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudoJsfPU");
		
		EntityManager em = emf.createEntityManager();

		//Iniciando tansação no banco		
		em.getTransaction().begin();

		
		//Declarando Reposistórios
		RamoAtividades ramoAtividades = new RamoAtividades(em);
		Empresas empresas = new Empresas(em);
		
		//Buscando Informações
		List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar("");
		List<Empresa> listaEmpresas = empresas.pesquisar("");
		System.out.println(listaEmpresas);
		
		
		//Criando uma empresa
		Empresa empresa = new Empresa();
		empresa.setNomeFantasia("João da Silva");
		empresa.setCnpj("41.952.519/0001-57");
		empresa.setRazaoSocial("João da Silva 41952519000157");
		empresa.setTipo(TipoEmpresa.MEI);
		empresa.setDataFundacao(new Date());
		empresa.setRamoAtividade(listaRamoAtividades.get(0));
		
		
		//Salvando Empresa
		empresas.guardar(empresa);
		
		em.getTransaction().commit();
		
		//Verificando se a inserção funcionou
		List<Empresa> listaEmpresas2 = empresas.pesquisar("");
		System.out.println(listaEmpresas2);
		
		em.close();
		emf.close();
		
	}

}
