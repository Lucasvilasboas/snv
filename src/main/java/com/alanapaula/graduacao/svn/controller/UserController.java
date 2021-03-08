package com.alanapaula.graduacao.svn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alanapaula.graduacao.svn.model.User;
import com.alanapaula.graduacao.svn.service.SecurityService;
import com.alanapaula.graduacao.svn.service.UserService;
import com.alanapaula.graduacao.svn.validator.UserValidator;

/**
 * Classe controller de @CadastroUser
 */
@Controller
public class UserController {

	/**
	 * Ponto de injeção para conseguir usar os metodos implementados no
	 * CadastroService
	 */
//	@Autowired
//	UserService servico;

	/**
	 * Model é um auxiliar que ajuda a adicionar atributos a nossa view, ModelMap é
	 * uma extensao do Model com capacidade de armazenar atributos em um mapa e em
	 * chamadas de método em cadeia.
	 * 
	 * @param model A model
	 * @return Retorna a view Cadastro
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET) // anotação responsável pelo processamento da URL
//																// mapeada,requisição GET -> transforma em action
//
//	public String showUsuarioPage(ModelMap model) {
//		model.addAttribute("Cadastro", new User());
//		return "/Cadastro";
//	}

	/**
	 * mapeamento da URL, requisição POST. OBS:BindingResult auxilia na validação
	 * durante o processo de binding, caso haja algum erro,é redirecionado pra
	 * pagina indicada
	 * 
	 * @param model        A model
	 * @param cadastroUser O cadastro de usuarios
	 * @param result       o binding result
	 * @return Redireciona para tela de login ou Retorna a view de cadastro em caso
	 *         de erro
	 */
//	@RequestMapping(value = "/saveUsuario", method = RequestMethod.POST) // mapeamento da URL, requisição POST
//	public String save(ModelMap model, User cadastroUser, BindingResult result) {
//		if (result.hasErrors()) {
//			return "/Cadastro";
//		}
//
//		servico.save(cadastroUser);
//
//		return "redirect:/Login";
//	}

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/Cadastro")
	public String cadastro(Model model) {
		model.addAttribute("userForm", new User());

		return "Cadastro";
	}

	@PostMapping("/Cadastro")
	public String cadastro(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "Cadastro";
		}

		userService.save(userForm);

		securityService.autoLogin(userForm.getUsername(), userForm.getConfirmaSenha());

		return "redirect:/home";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "CPF e senha inválidas!.");

		if (logout != null)
			model.addAttribute("message", "Login Bem-Sucedido!.");

		return "login";
	}

	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		return "home";
	}
}
