package com.alanapaula.graduacao.svn.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe de dominio responsável pelo login e composto por: atributos, hashcode
 * e equals, tostring. Além do getter e setter gerados automaticamente pelo
 * lombok
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // Anotação que indica que a classe é uma entidade do banco de dados
@Table(name = "login") // Anotação indica nome da tabela a ser criada no banco de dados
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Anotação para indicar que o campo id é identificados da entidade e será
	 * gerado pelo banco de dados
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	/**
	 * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no minimo 5 e no maximo 254 caracteres, não pode ser nulo e é unico.
	 */
	@Size(min = 5, max = 254)
	@NotBlank(message = " não pode estar em branco")
	@Column(length = 254, unique = true, nullable = false)
	private String email;

	/**
	 * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no maximo 11 caracteres, não pode ser nulo e é unico.
	 */
	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	@NotBlank(message = " não pode estar em branco")
	private String cpf;

	/**
	 * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no maximo 60 caracteres, não pode ser nulo e é unico.
	 */
	@NotBlank(message = " não pode estar em branco")
	@Column(length = 60, nullable = false)
	private String senha;

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, id, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Login)) {
			return false;
		}
		Login other = (Login) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(senha, other.senha);
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", email=" + email + ", cpf=" + cpf + ", senha=" + senha + "]";
	}

}
