package com.generation.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_produtos")
public class Produtos {

	
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	
	  

	    @NotNull
		@Size(min = 5 , max = 100)
		private String titulo; /*nome*/
	    
	  
	  private String descricao;
	
	  
	    @NotNull
		private double preco;
	    
	    @NotNull
	    private int quantidade_ml;
	    
	    private String EfeitoColateral;
	    

		@ManyToOne
	    @JsonIgnoreProperties("produtos")
		private Categorias categorias;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public double getPreco() {
			return preco;
		}

		public void setPreco(double preco) {
			this.preco = preco;
		}

		public int getQuantidade_ml() {
			return quantidade_ml;
		}

		public void setQuantidade_ml(int quantidade_ml) {
			this.quantidade_ml = quantidade_ml;
		}

		public String getEfeitoColateral() {
			return EfeitoColateral;
		}

		public void setEfeitoColateral(String efeitoColateral) {
			EfeitoColateral = efeitoColateral;
		}
	    
	    
	    
	    
	    
	    
	    
		
}
