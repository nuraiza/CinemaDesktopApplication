package s19241.mas.project.cinemaapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s19241.mas.project.cinemaapp.model.Seat;
import s19241.mas.project.cinemaapp.repository.SeatRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;


    public List<Seat> getAvailableSeatBySessionId(Long session_id, Long hall_id) {
        return seatRepository.findAvailableSeatsBySessionId(session_id, hall_id);

    }

}
