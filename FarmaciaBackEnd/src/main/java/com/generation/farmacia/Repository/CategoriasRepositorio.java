package com.generation.farmacia.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.Categorias;

@Repository
public interface CategoriasRepositorio extends JpaRepository<Categorias , Long>{
	public List<Categorias> findAllByDescricaoContainingIgnoreCase(String descricao);

}
