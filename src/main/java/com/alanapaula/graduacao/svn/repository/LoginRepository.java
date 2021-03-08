package com.alanapaula.graduacao.svn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alanapaula.graduacao.svn.model.Login;

/**
 * Classe de repositório de @Login
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

	/**
	 * Optional que busca pelo CPF
	 * 
	 * @param cpf O cpf
	 * @return Retorna CPF ou lista vazia caso o cpf seja inválido.
	 */
	Optional<Login> findByCpf(String cpf); // busca por cpf na lista de Usuarios Logados

}
