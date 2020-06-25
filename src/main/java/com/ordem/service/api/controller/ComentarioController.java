package com.ordem.service.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ordem.service.api.model.ComentarioInput;
import com.ordem.service.api.model.ComentarioModel;
import com.ordem.service.domain.exception.EntidadeNaoEncontradaException;
import com.ordem.service.domain.model.Comentario;
import com.ordem.service.domain.model.OrdemServico;
import com.ordem.service.domain.repository.OrdemServicoRepository;
import com.ordem.service.domain.service.GestaoOrdemServicoService;

@RestController
@RequestMapping("ordens-servico/{ordemServicoId}/comentarios")
public class ComentarioController {
	
	@Autowired
	private GestaoOrdemServicoService gestaoOrdemServicoService;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<ComentarioModel> listar(@PathVariable Long ordemServicoId) {
		
		OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de Seriço não Encontrada"));
		
		return toCollectionModel(ordemServico.getComentarios());
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ComentarioModel adicionar(@PathVariable Long ordemServicoId,
									 @Valid @RequestBody ComentarioInput comentarioInput) {
		
		Comentario comentario = gestaoOrdemServicoService.adicionarComentario(ordemServicoId, 
							comentarioInput.getDescricao());
		
		return toModel(comentario);
	}
	
	//Representação para o Model
	private ComentarioModel toModel(Comentario comentario) {
		
		return modelMapper.map(comentario, ComentarioModel.class);
		
	}
	
	private List<ComentarioModel> toCollectionModel(List<Comentario> comentarios) {
		return comentarios.stream()
				.map(comentario -> toModel(comentario))
				.collect(Collectors.toList());
	}
	
}
