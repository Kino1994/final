package com.loginPrueba.servicios;

import java.util.List;

import com.loginPrueba.modelo.Categoria;
import com.loginPrueba.modelo.Edificio;
import com.loginPrueba.modelo.Producto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductoService {

	public List<Producto> findAll();
	public List<Producto> findAllByCategoria(Categoria categoria);
	public List<Producto> findAllByCategoria(Long categoriaId);
	public Producto findById(String id);
	public Producto save(Producto producto);
	public Producto delete(Producto producto);
	public int numeroProductosCategoria(Categoria categoria);
	public int numeroProductosEdificio(Edificio edificio);
	public List<Producto> findAllByEdificio(Edificio edificio);
	public List<Producto> findAllByEdificio(Long edificioId);
	public Page<Producto> findAllPaginated(Pageable pageable);
}
