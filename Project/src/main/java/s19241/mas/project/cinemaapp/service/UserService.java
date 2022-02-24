package s19241.mas.project.cinemaapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s19241.mas.project.cinemaapp.model.User;
import s19241.mas.project.cinemaapp.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }
}
