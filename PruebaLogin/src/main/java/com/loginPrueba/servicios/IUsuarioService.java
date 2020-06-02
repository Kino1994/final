package com.loginPrueba.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.loginPrueba.modelo.Edificio;
import com.loginPrueba.modelo.Producto;
import com.loginPrueba.modelo.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	public Usuario findById(String id);
	public Usuario save(Usuario usuario);
	public Usuario delete(Usuario usuario);
	public int numeroUsuariosEdificio(Edificio edificio);
	public List<Usuario> findAllByEdificio(Edificio edificio);
	public List<Usuario> findAllByEdificio(Long edificioId);
	public List<Usuario> findAllByProducto(String productoId);
	public List<Usuario> buscador(String cadena);
	public Page<Usuario> findAllPaginated(Pageable pageable);
	public int numeroUsuarioProducto(Producto producto);
}
