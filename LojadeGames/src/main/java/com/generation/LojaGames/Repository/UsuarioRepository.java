package com.generation.LojaGames.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.LojaGames.model.Usuario;

	public interface UsuarioRepository extends JpaRepository<Usuario , Long> {

		public Optional<Usuario> findByUsuario(String usuario);
		
		
	}


