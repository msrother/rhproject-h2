package br.com.rhprojecth2.repository;

import br.com.rhprojecth2.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Long> {

    public List<EmployeeDTO> findByNameContaining (String name);

}
