package com.alanapaula.graduacao.svn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alanapaula.graduacao.svn.model.Login;
import com.alanapaula.graduacao.svn.service.LoginService;

/**
 * Classe controller de @Login
 *
 */
@Controller
public class LoginController {

//	/**
//	 * Ponto de injeção para conseguir usar os metodos implementados no LoginService
//	 */
//	@Autowired
//	LoginService servico;
//
//	/**
//	 * Model é um auxiliar que ajuda a adicionar atributos a nossa view, o ModelMap
//	 * é uma extensao do Model com capacidade de armazenar atributos em um mapa e em
//	 * chamadas de método em cadeia.
//	 * 
//	 * @param model a Model
//	 * @return Retorna a view Login
//	 */
//	@RequestMapping(value = "/Login", method = RequestMethod.GET) // anotação responsável pelo processamento da URL
//																	// mapeada -> transforma em action
//
//	public String showLoginPage(ModelMap model) {
//		model.addAttribute("Login", new Login()); // adicionando atributos a view
//		return "Login";
//	}
	
	

}