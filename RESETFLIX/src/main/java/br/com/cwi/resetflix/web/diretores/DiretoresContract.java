package br.com.cwi.resetflix.web.diretores;

import java.util.List;

import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.diretor.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.diretor.DiretoresResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

public interface DiretoresContract {

    @ApiOperation(value = "Obter todos os diretores.", notes = "Obtém todos os diretores cadastrados no sistema.")
    List<DiretoresResponse> getDiretores();

    @ApiOperation(value = "Obter diretor por ID.", notes = "Obtém detalhes do diretor baseado no seu identificador.")
    public ConsultarDetalhesDiretorResponse getDiretorById(@ApiParam("id") final Long id);

    @ApiOperation(value = "Cria um novo diretor.", notes = "Cria um novo diretor com as informações especificadas.")
    public Long criarDiretor(@ApiParam final CriarDiretorRequest request);
}
