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

import com.generation.farmacia.Repository.CategoriasRepositorio;
import com.generation.farmacia.model.Categorias;



@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriasController {
	
	@Autowired
	private CategoriasRepositorio repository;
	
	
	@GetMapping
	 public ResponseEntity<List<Categorias>> GetAll(){
 	  
 	  return ResponseEntity.ok(repository.findAll());
 	  
 	  
   }
	
	@GetMapping("/{id}")
	public ResponseEntity<Categorias> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		  	
	}
	
	 @GetMapping ("/descricao{descricao}")
	  public ResponseEntity<List<Categorias>> GetByDescricao(@PathVariable String descricao){
		  return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao)); 
				  
		  
	 }

	 
	 @PostMapping
	 public ResponseEntity<Categorias> post (@RequestBody Categorias categorias){
		 return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categorias));
		 
	 }
	 
	 @PutMapping
	  public ResponseEntity<Categorias> put (@RequestBody Categorias categorias){
		  
		  return ResponseEntity.status(HttpStatus.OK).body(repository.save(categorias));
		  
	  }
	  
	  @DeleteMapping("/{id}")
	  public void Delete(@PathVariable long id ) {
		  repository.deleteById(id);
	  }
	  
	 }




