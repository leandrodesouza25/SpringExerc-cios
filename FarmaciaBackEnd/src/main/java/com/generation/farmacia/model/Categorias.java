package com.generation.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "categorias")
public class Categorias {
	
	
	 @Id
	 @GeneratedValue
	 (strategy = GenerationType.IDENTITY)
		private long id;
	 
	    @NotNull /*Função do medicamento */
		@Size(min = 3 , max = 600)
		private String descricao;
	    
	    @Size(min = 3 , max = 600)
		private String faixaetaria;
	    

		@OneToMany(mappedBy = "categorias" , cascade = CascadeType.ALL)
		@JsonIgnoreProperties("categorias")
		private List<Produtos> produto;


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getDescricao() {
			return descricao;
		}


		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}


		public List<Produtos> getProduto() {
			return produto;
		}


		public void setProduto(List<Produtos> produto) {
			this.produto = produto;
		}


		public String getFaixaetaria() {
			return faixaetaria;
		}


		public void setFaixaetaria(String faixaetaria) {
			this.faixaetaria = faixaetaria;
		}
		
		
		

}
