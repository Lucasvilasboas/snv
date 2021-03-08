package com.alanapaula.graduacao.svn.service;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.alanapaula.graduacao.svn.model.Login;

/**
 * Classe serviço de @Login
 */
public interface LoginService {

	/**
	 * metodo que retona uma lista de Usuarios Logados
	 * 
	 * @return
	 */
	List<Login> findAll();

	/**
	 * metodo que retorna um unico CadastroUser Logado, buscando pelo parametro id
	 * do tipo de dado long
	 * 
	 * @param id O id
	 * @return
	 */
	Login findById(@NotBlank long id);

	/**
	 * metodo save recebe um usuario logado e salva no banco de dados
	 * 
	 * @param login O login
	 * @return
	 */
	Login save(Login login);

}