package com.alanapaula.graduacao.svn.service;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.alanapaula.graduacao.svn.model.User;

/**
 * Classe serviço de @CadastroUser
 */
public interface UserService {

	/**
	 * Metodo que retona uma lista de Usuarios cadastrados
	 * 
	 * @return
	 */
	List<User> findAll();

	/**
	 * Metodo que retorna um unico CadastroUser cadastrado, buscando pelo parametro
	 * id do tipo de dado long
	 * 
	 * @param id
	 * 
	 */
	User findById(@NotBlank long id);

	User findByCPF(@NotBlank String cpf);

	/**
	 * metodo save recebe um usuario cadastrado e salva no banco de dados
	 * 
	 * @param cadastroUser
	 * @return
	 */
	User save(User cadastroUser);

}