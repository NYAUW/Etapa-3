package br.com.contmatic.repository;

import java.util.List;

import br.com.contmatic.cliente.Cadastro;

public interface ICadastroRepository {
	
	public void save(Cadastro cadastro) throws IllegalAccessException;

    public void update(Cadastro cadastro);

    public void deleteById(String id) throws IllegalAccessException;

    public Cadastro findById(String id);

    public List<Cadastro> findAll();
}
