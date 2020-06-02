package com.loginPrueba.servicios;

import java.util.List;

import com.loginPrueba.modelo.Edificio;
import com.loginPrueba.modelo.Producto;
import com.loginPrueba.modelo.Tecnico;
import com.loginPrueba.modelo.Usuario;

public interface ITecnicoService {

	public List<Tecnico> findAll();
	public Tecnico findById(String id);
	public Tecnico save(Tecnico tecnico);
	public Tecnico delete(Tecnico tecnico);
	public int numeroTecnicosEdificio(Edificio edificio);
	public List<Tecnico> findAllByEdificio(Edificio edificio);
	public List<Tecnico> findAllByEdificio(Long edificioId);
	public List<Tecnico> findAllByProducto(String productoId);
	public List<Tecnico> buscador(String cadena);
	public int numeroTecnicoProducto(Producto producto);
}
