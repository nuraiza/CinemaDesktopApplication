package s19241.mas.project.cinemaapp.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s19241.mas.project.cinemaapp.model.Film;
import s19241.mas.project.cinemaapp.repository.FilmRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmRepository filmRepository;


    public List<Film> getAllFilms() {
        Iterable<Film> all = filmRepository.findAll();
        List<Film> films = new ArrayList<>();
        all.forEach(films::add);
        return films;
    }
}
