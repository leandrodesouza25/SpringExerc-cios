package com.generation.LojaGames.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.generation.LojaGames.Repository.UsuarioRepository;
import com.generation.LojaGames.model.Usuario;



public class UserDetailsServiceImpl  implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetailsImpl loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<Usuario> usuario = userRepository.findByUsuario(userName);
		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

		return usuario.map(UserDetailsImpl::new).get();
	}
}


	
	

