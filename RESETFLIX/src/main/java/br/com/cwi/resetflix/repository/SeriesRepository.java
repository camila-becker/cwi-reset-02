package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SeriesRepository {
    static List<SerieEntity> series = new ArrayList<>();
    static Long nextId = 1l;

    public List<SerieEntity> getSeries(){
        return series;
    }

    public Long criarSerie(final SerieEntity salvarSerie){
        for(SerieEntity serie : series){
            if(salvarSerie.getNome().equals(serie.getNome())){
                throw new BadRequestException("Série já cadastrada!");
            }
        }
        if(salvarSerie.getId() == null){
            salvarSerie.setId(nextId);
            nextId++;
        }
        series.add(salvarSerie);
        return salvarSerie.getId();
    }

    public SerieEntity buscarSeriePorId(Long id) {
        for(SerieEntity serie : series){
            if(serie.getId().equals(id)){
                return serie;
            }
        }
        return null;
    }

    public List<SerieEntity> buscarSeriePorGenero(final Genero genero){
        List<SerieEntity> serieSalvo = new ArrayList<>();
        for(SerieEntity serie : series){
            if(serie.getGenero().equals(genero)){
                serieSalvo.add(serie);
            }
        }

        if(genero == null){
            return series;
        }

        return serieSalvo;
    }
}
