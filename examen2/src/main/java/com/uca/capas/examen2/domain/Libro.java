package com.uca.capas.examen2.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(schema="public", name="cat_libro")
public class Libro {
	
	@Id
	@Column(name="c_libro")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer c_libro;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "c_categoria")
	private Categoria categoria;
	
	@Transient
	private Integer c_categoria;
	
	@Size(max=500,message="El nombre no debe tener mas de 500 caracteres")
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column(name="s_titulo")
	private String s_titulo;
	
	@Size(max=150,message="El nombre no debe tener mas de 150 caracteres")
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column(name="s_autor")
	private String s_autor;
	
	@Column(name="f_ingreso")
	private Date f_ingreso;
	
	
	
	@Column(name="b_estado")
	@NotNull
	private Boolean b_estado;

	@Size(max=10,message="El nombre no debe tener mas de 10 caracteres")
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column(name="s_isbn")
	private String s_isbn;
	
	
	public String getS_isbn() {
		return s_isbn;
	}

	public void setS_isbn(String s_isbn) {
		this.s_isbn = s_isbn;
	}

	public Libro() {
		super();
	}

	public Integer getC_libro() {
		return c_libro;
	}

	public void setC_libro(Integer c_libro) {
		this.c_libro = c_libro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}

	public String getS_titulo() {
		return s_titulo;
	}

	public void setS_titulo(String s_titulo) {
		this.s_titulo = s_titulo;
	}

	public String getS_autor() {
		return s_autor;
	}

	public void setS_autor(String s_autor) {
		this.s_autor = s_autor;
	}

	public String getF_ingreso()throws ParseException  {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy hh.mm aa");
        Date date2 = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(String.valueOf(f_ingreso));
        String nwdate = format.format(date2);
        return nwdate;
	}

	public void setF_ingreso(Date f_ingreso) {
		this.f_ingreso = f_ingreso;
	}

	public Boolean getB_estado() {
		return b_estado;
	}

	public void setB_estado(Boolean b_estado) {
		this.b_estado = b_estado;
	}
	
}
