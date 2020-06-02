package com.loginPrueba.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginPrueba.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	

}
