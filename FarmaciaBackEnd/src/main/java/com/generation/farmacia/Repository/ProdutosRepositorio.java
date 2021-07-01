package com.generation.farmacia.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.Produtos;



	@Repository
	public interface ProdutosRepositorio extends JpaRepository <Produtos , Long>{
		public List<Produtos>findAllByDescricaoContainingIgnoreCase(String descricao);

		/*public Object findAllByDescricaoContainingIgnoreCase(double preco);

		public Object findAllByDescricaoContainingIgnoreCase(int quantidade_ml);*/
		
}

