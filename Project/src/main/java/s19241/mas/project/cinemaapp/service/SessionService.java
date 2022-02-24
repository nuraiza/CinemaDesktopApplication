package s19241.mas.project.cinemaapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s19241.mas.project.cinemaapp.model.Session;
import s19241.mas.project.cinemaapp.repository.SessionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;

    public List<Session> getSessionsByFilmId(Long film_id) {
        return sessionRepository.findSessionsByFilmId(film_id);

    }
}
