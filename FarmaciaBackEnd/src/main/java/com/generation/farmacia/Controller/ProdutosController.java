package com.generation.farmacia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmacia.Repository.ProdutosRepositorio;
import com.generation.farmacia.model.Produtos;




@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RequestMapping("/produtos")
public class ProdutosController {


	@Autowired
	private ProdutosRepositorio produtosrepository;
	
	@GetMapping
	public ResponseEntity<List<Produtos>> getAll(){
		return ResponseEntity.ok(produtosrepository.findAll());
		
}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Produtos>> getByName(@PathVariable String titulo){
     
		return ResponseEntity.ok(produtosrepository.findAllByDescricaoContainingIgnoreCase(titulo));
		
		
	}

	
	
/*	
	
	

@GetMapping("/efeitocolateral/{EfeitoColateral}")
	public ResponseEntity<List<Produtos>> getByEfeito(@PathVariable String EfeitoColateral){
     
		return ResponseEntity.ok(produtosrepository.findAllByDescricaoContainingIgnoreCase(EfeitoColateral));
		
		
	}




	@GetMapping ("/preco{preco}")
	  public ResponseEntity<Object> GetByPreco(@PathVariable double preco){
		  return ResponseEntity.ok(produtosrepository.findAllByDescricaoContainingIgnoreCase(preco));
				  
		  
		}

	@GetMapping ("/quantidademl{quantidade_ml}")
	  public ResponseEntity<Object> GetByQuantidade(@PathVariable int quantidade_ml){
		  return ResponseEntity.ok(produtosrepository.findAllByDescricaoContainingIgnoreCase(quantidade_ml));
				  
	} 
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping
	public ResponseEntity<Produtos> post (@RequestBody Produtos produtos){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtosrepository.save(produtos));
		
	}

	@PutMapping
	public ResponseEntity<Produtos> put (@RequestBody Produtos produtos){
		return ResponseEntity.ok(produtosrepository.save(produtos));
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		produtosrepository.deleteById(id);
		
	}
	
	
	
}
