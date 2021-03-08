package com.alanapaula.graduacao.svn.serviceImpl;

import java.util.HashSet;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.alanapaula.graduacao.svn.model.User;
import com.alanapaula.graduacao.svn.repository.RoleRepository;
import com.alanapaula.graduacao.svn.repository.UserRepository;
import com.alanapaula.graduacao.svn.service.UserService;

/**
 * Classe implementação de serviço de @CadastroUser
 */
@Validated
@Service
public class UserServiceImpl implements UserService {

	/**
	 * Ponto de injeção para conseguir usar as instãncias do repositório
	 * CadastroRepository
	 */

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Metodos implementados da interface CadastroService
	 */
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/**
	 * get() serve para o obter o CadastroUser, e não um Optional (repositorio)de
	 * CadastroUser
	 */
	@Override
	public User findById(long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User save(User user) {
		user.setSenha(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		return userRepository.save(user);
	}

	@Override
	public User findByCPF(@NotBlank String cpf) {
		return userRepository.findByUsername(cpf);
	}

}
