package com.loginPrueba.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.loginPrueba.modelo.Incidencia;
import com.loginPrueba.modelo.Producto;
import com.loginPrueba.modelo.Usuario;
import com.loginPrueba.repositorios.IncidenciaRepository;


@Service
public class IncidenciaService implements IIncidenciaService {

	@Autowired IncidenciaRepository incidenciaRepositorio;
	
	@Override
	public List<Incidencia> findAll() {
		return (List<Incidencia>) incidenciaRepositorio.findAll();
	}
	
	public Page<Incidencia> findAllPaginated(Pageable pageable) {
		return incidenciaRepositorio.findAll(pageable);
	}

	@Override
	public Incidencia findById(String id) {
		return incidenciaRepositorio.findById(id).orElse(null);
	}

	@Override
	public Incidencia save(Incidencia incidencia) {
		return incidenciaRepositorio.save(incidencia);
	}

	@Override
	public Incidencia delete(Incidencia incidencia) {
		Incidencia result = findById(incidencia.getId());
		incidenciaRepositorio.delete(result);
		return result;
	}
	
	@Override
	public List<Incidencia> findAllByUsuario(String usuarioId) {
		return incidenciaRepositorio.findByUsuarioId(usuarioId);
	}
	
	@Override
	public List<Incidencia> findAllByTecnico(String tecnicoId) {
		return incidenciaRepositorio.findByTecnicoId(tecnicoId);
	}
	

}
