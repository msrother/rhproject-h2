package br.com.rhprojecth2.repository;

import br.com.rhprojecth2.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserDTO, Long> {

    public UserDTO findByEmail(String email);

    @Query("SELECT u FROM UserDTO u WHERE u.password = :password ORDER BY u.id DESC")
    public List<UserDTO> findByPassword(@Param("password") String password);

}
