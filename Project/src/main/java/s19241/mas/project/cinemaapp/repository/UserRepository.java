package s19241.mas.project.cinemaapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import s19241.mas.project.cinemaapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    @Query("from user as u where u.id=:id")
    User findUserById(@Param("id") Long id);
}
