package com.loginPrueba.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.loginPrueba.modelo.Categoria;
import com.loginPrueba.modelo.Edificio;
import com.loginPrueba.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String>{
	
	public List<Producto> findByCategoria(Categoria categoria);
	
	public List<Producto> findByEdificio(Edificio edificio);
	
	@Query("select p.id from Producto p")
	public List<String> obtenerIds();
	
	@Query("select p from Producto p where p.categoria.id = ?1")
	public List<Producto> findByCategoriaId(Long categoriaId);
	
	@Query("select count(p) from Producto p where p.categoria = ?1")
	public int findNumProductosByCategoria(Categoria categoria);
	
	@Query("select p from Producto p where p.edificio.id = ?1")
	public List<Producto> findByEdificioId(Long edificioId);
	
	@Query("select count(p) from Producto p where p.edificio = ?1")
	public int findNumProductosByEdificio(Edificio edificio);
	
}
