package br.com.rhprojecth2.repository;

import br.com.rhprojecth2.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDTO, Long> {

    public UserDTO findByEmail(String email);

}
