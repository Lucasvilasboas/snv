package com.alanapaula.graduacao.svn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.alanapaula.graduacao.svn.model.Login;
import com.alanapaula.graduacao.svn.repository.LoginRepository;
import com.alanapaula.graduacao.svn.service.LoginService;

/**
 * Classe implementação de serviço de @Login
 */
@Validated
@Service
public class LoginServiceImpl implements LoginService {

	/**
	 * Ponto de injeção para conseguir usar as instãncias do repositório
	 * LoginRepository
	 */
	@Autowired
	LoginRepository repositorio;

	/**
	 * Metodos implementados da interface CadastroService
	 */
	@Override
	public List<Login> findAll() {
		return repositorio.findAll();
	}

	/**
	 *
	 */
	@Override
	public Login findById(long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Login save(Login login) {
		return repositorio.save(login);
	}

}
