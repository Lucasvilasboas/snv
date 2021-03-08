package com.alanapaula.graduacao.svn.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.alanapaula.graduacao.svn.model.User;
import com.alanapaula.graduacao.svn.service.UserService;

@Component
public class UserValidator implements Validator {
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpf", "NotEmpty");
		if (user.getUsername().length() < 11 || user.getUsername().length() > 12) {
			errors.rejectValue("cpf", "Size.userForm.cpf");
		}
		if (userService.findById(user.getId()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senha", "NotEmpty");
		if (user.getSenha().length() < 8 || user.getSenha().length() > 32) {
			errors.rejectValue("senha", "Size.userForm.senha");
		}

		if (!user.getConfirmaSenha().equals(user.getPassword())) {
			errors.rejectValue("confirmaSenha", "Diff.userForm.confirmaSenha");
		}
	}
}
