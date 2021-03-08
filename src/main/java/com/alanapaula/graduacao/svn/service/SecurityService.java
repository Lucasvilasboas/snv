package com.alanapaula.graduacao.svn.service;

public interface SecurityService {
	String findLoggedInUsername();

	void autoLogin(String cpf, String senha);
}
