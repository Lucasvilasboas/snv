package com.alanapaula.graduacao.svn.model;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Classe de dominio responsável pelo cadastro e composto por: atributos,
 * hashcode e equals, tostring. Além do getter e setter gerados automaticamente
 * pelo lombok
 *
 */
@Entity // Anotação que indica que a classe é uma entidade do banco de dados
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cadastro") // Anotação indica nome da tabela a ser criada no banco de dados
public class User implements UserDetails {
//	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
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
	 * pode ter no no maximo 255 caracteres, não pode ser nulo e é unico.
	 */
	@Column(name = "nome", length = 255, nullable = false)
	@Size(max = 255)
	@NotBlank(message = " não pode estar em branco")
	private String nome;

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
	 * pode ter no no maximo 255 caracteres, não pode ser nulo e é unico.
	 */
	@Column(name = "data", length = 10, nullable = false)
	@Size(max = 10)
	@NotBlank(message = " não pode estar em branco")
	private String data;

	/**
	 * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no maximo 11 caracteres, não pode ser nulo e é unico.
	 */
	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	@NotBlank(message = " não pode estar em branco")
	private String cpf;

	/**
	 * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no maximo 8 caracteres, não pode ser nulo e é unico.
	 */
	@Column(name = "RG", length = 8, nullable = false, unique = true)
	@NotBlank(message = " não pode estar em branco")
	private String RG;

	/**
	 * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no no maximo 255 caracteres, não pode ser nulo e é unico.
	 */
	@Column(name = "endereco", length = 255, nullable = false)
	@Size(max = 255)
	@NotBlank(message = " não pode estar em branco")
	private String endereco;

	/**
	 * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no no maximo 255 caracteres, não pode ser nulo e é unico.
	 */
	@Column(name = "complemento", length = 255, nullable = false)
	@Size(max = 255)
	@NotBlank(message = " não pode estar em branco")
	private String complemento;

	/**
	 * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no maximo 11 caracteres, não pode ser nulo e é unico.
	 */
	@Column(name = "cep", length = 11, nullable = false, unique = true)
	@NotBlank(message = " não pode estar em branco")
	private String cep;

	/**
	 * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no maximo 3 caracteres, não pode ser nulo e é unico.
	 */
	@Column(name = "sexo", length = 3, nullable = false, unique = true)
	@NotBlank(message = " não pode estar em branco")
	private String sexo;

	/**
	 * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no maximo 3 caracteres, não pode ser nulo e é unico.
	 */
	@Column(name = "nomeMae", length = 255, nullable = false, unique = true)
	@NotBlank(message = " não pode estar em branco")
	private String nomeMae;

	/**
	 * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no maximo 3 caracteres, não pode ser nulo e é unico.
	 */
	@Column(name = "nomePai", length = 255, nullable = false, unique = true)
	@NotBlank(message = " não pode estar em branco")
	private String nomePai;

	/**
	 * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no maximo 11 caracteres, não pode ser nulo e é unico.
	 */
	@Column(name = "cartaoSus", length = 11, nullable = false, unique = true)
	private String cartaoSus;

	/**
	 * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no maximo 60 caracteres, não pode ser nulo e é unico.
	 */
	@NotBlank(message = " não pode estar em branco")
	@Column(length = 60, nullable = false)
	private String senha;

	/**
	 * * Anotação que define uma coluna no banco de dados cujo o valor do atributo
	 * pode ter no maximo 60 caracteres, não pode ser nulo e é unico.
	 */
	@Transient
	@NotBlank(message = " não pode estar em branco")
	@Column(length = 60, nullable = false)
	private String confirmaSenha;


    @ManyToMany
    private Set<Role> roles;
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(RG, other.RG) && Objects.equals(cartaoSus, other.cartaoSus)
				&& Objects.equals(cep, other.cep) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(confirmaSenha, other.confirmaSenha) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(data, other.data) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(nomeMae, other.nomeMae)
				&& Objects.equals(nomePai, other.nomePai) && Objects.equals(senha, other.senha)
				&& Objects.equals(sexo, other.sexo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(RG, cartaoSus, cep, complemento, confirmaSenha, cpf, data, email, endereco, id, nome,
				nomeMae, nomePai, senha, sexo);
	}
	

  

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	public String getPasswordConfirm() {
		return confirmaSenha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return cpf;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
