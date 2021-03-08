package com.alanapaula.graduacao.svn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Classe responsável pela execução da aplicação.
 */
@SpringBootApplication
@EnableTransactionManagement
public class SvnApplication {

	/**
	 * Método principal da aplicação responsável por executá-la.
	 * 
	 * @param args Refere-se aos argumentos que serão passados para esse método.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SvnApplication.class, args);
	}

}
