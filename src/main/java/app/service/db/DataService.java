package app.service.db;

import app.constant.MovieTypeEnum;
import app.dao.FilmRepository;
import app.entity.Film;
import app.mapper.FilmMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhihao zhang
 * @since 2019-08-21
 */

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DataService {
    private FilmRepository filmRepository;
    private FilmMapper filmMapper;

    public Film findByMovieId(long movieId) {
        return filmRepository.findFirstByMovieId(movieId);
    }

    public List<Film> findByMovieIds(List<Long> movieIdList) {
        return filmRepository.findByMovieIdIsIn(movieIdList);
    }

    public List<Film> findByMovieTypeEnum(MovieTypeEnum movieTypeEnum) {
        return filmRepository.findByMovieTypeEnumOrderByRatingDesc(movieTypeEnum);
    }

    public List<Film> listFilmsByMovieTypeEnum(MovieTypeEnum movieTypeEnum) {
        return filmMapper.selectList(Wrappers.<Film>lambdaQuery()
                .eq(Film::getMovieTypeEnum, movieTypeEnum)
                .orderByDesc(Film::getRating)
        );
    }

    public List<Film> listAllFilms() {
        return filmMapper.selectList(Wrappers.<Film>lambdaQuery()
                .orderByDesc(Film::getMovieYear)
                .orderByDesc(Film::getRating)
        );
    }

    public void saveAll(List<Film> filmList) {
        filmRepository.saveAll(filmList);
    }

    public void save(Film film) {
        filmRepository.save(film);
    }
}
