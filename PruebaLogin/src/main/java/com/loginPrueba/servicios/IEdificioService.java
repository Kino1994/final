package com.loginPrueba.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.loginPrueba.modelo.Edificio;

public interface IEdificioService {

	public List<Edificio> findAll();
	public Edificio save(Edificio edificio);
	public Edificio findById(Long id);
	public Edificio delete(Edificio edificio);
	public Page<Edificio> findAllPaginated(Pageable pageable);
}
