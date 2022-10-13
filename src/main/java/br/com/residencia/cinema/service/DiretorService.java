package br.com.residencia.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.cinema.entity.Diretor;
import br.com.residencia.cinema.repository.DiretorRepository;

@Service
public class DiretorService {
	@Autowired
	DiretorRepository diretorRepository;
	
	public List<Diretor> getAllDiretores(){
		return diretorRepository.findAll();
	}
	
	public Diretor getDiretorById(Integer id) {
		return diretorRepository.findById(id).orElse(null);
	}
	
	public Diretor saveDiretor(Diretor diretor) {
		return diretorRepository.save(diretor);
	}
	
	public Diretor updateDiretor(Diretor diretor, Integer id) {
		
		Diretor diretorExisteNoBanco = getDiretorById(id);
		
		diretorExisteNoBanco.setNome(diretor.getNome());
		
		return diretorRepository.save(diretorExisteNoBanco);
	}
	
	public Diretor deleteDiretor(Integer id) {
		diretorRepository.deleteById(id);
		return getDiretorById(id);
	}
}
