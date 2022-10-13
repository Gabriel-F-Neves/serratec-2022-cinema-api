package br.com.residencia.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.cinema.entity.Filme;
import br.com.residencia.cinema.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	FilmeRepository filmeRepository;
	
	public List<Filme> getAllFilmes(){
		return filmeRepository.findAll();
	}
	
	public Filme getFilmeById(Integer id) {
		return filmeRepository.findById(id).orElse(null);
	}
	
	public Filme saveFilme(Filme filme) {
		return filmeRepository.save(filme);
	}
	
	public Filme updateFilme(Filme filme, Integer id) {
		
		Filme filmeExisteNoBanco = getFilmeById(id);
		
		filmeExisteNoBanco.setNomeBr(filme.getNomeBr());
		filmeExisteNoBanco.setNomeEn(filme.getNomeEn());
		filmeExisteNoBanco.setAnoLancamento(filme.getAnoLancamento());
		filmeExisteNoBanco.setSinopse(filme.getSinopse());
		filmeExisteNoBanco.setDiretor(filme.getDiretor());
		filmeExisteNoBanco.setGenero(filme.getGenero());
		
		return filmeRepository.save(filmeExisteNoBanco);
	}
	
	public Filme deleteFilme(Integer id) {
		filmeRepository.deleteById(id);
		return getFilmeById(id);
	}
}
