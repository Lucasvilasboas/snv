package com.alanapaula.graduacao.svn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alanapaula.graduacao.svn.model.User;

/**
 * Classe de repositório de @CadastroUser
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Optional que busca pelo CPF
	 * 
	 * @param cpf O cpf
	 * @return Retorna CPF ou lista vazia caso o cpf seja inválido.
	 */
	User findByUsername(String cpf);

}
