package br.com.rhprojecth2.repository;

import br.com.rhprojecth2.dto.DepartmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentDTO, Long> {

    public List<DepartmentDTO> findByNameContaining (String name);

}
