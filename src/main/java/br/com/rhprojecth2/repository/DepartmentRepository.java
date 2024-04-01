package br.com.rhprojecth2.repository;

import br.com.rhprojecth2.dto.DepartmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentDTO, Long> {

}
