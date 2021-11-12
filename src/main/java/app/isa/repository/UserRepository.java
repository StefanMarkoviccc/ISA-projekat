package app.isa.repository;

import app.isa.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOne(Long id);
    List<User> getAll();
    Optional<User> findOneByEmail(String email);
}
