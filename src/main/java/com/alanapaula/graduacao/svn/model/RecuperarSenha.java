package com.alanapaula.graduacao.svn.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe de dominio responsável pela recuperação de senha e composto por:
 * atributos, hashcode e equals, tostring. Além do getter e setter gerados
 * automaticamente pelo lombok
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recuperarSenha")
public class RecuperarSenha implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Anotação para indicar que o campo id é identificados da entidade e será
	 * gerado pelo banco de dados
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no maximo 11 caracteres, não pode ser nulo e é unico.
	 */
	@Column(name = "cpf", length = 20, nullable = false, unique = true)
	@NotBlank(message = " não pode estar em branco")
	private String cpf;

	/**
	 * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no maximo 60 caracteres, não pode ser nulo e é unico.
	 */
	@JsonIgnore
	@NotBlank
	@Column(length = 60)
	private String senha;

	/**
	 * 
	 */
	@Size(min = 5, max = 254)
	@Column(length = 254, unique = true, nullable = false)
	private String email;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RecuperarSenha)) {
			return false;
		}
		RecuperarSenha other = (RecuperarSenha) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(senha, other.senha);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, id, senha);
	}

	@Override
	public String toString() {
		return String.format("RecuperarSenha [cpf=%s, senha=%s]", cpf, senha);
	}
	// GERANDO GETTERS E SETTER COM LOMBOK
}