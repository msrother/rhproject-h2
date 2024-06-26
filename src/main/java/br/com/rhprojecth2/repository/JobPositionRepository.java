package br.com.rhprojecth2.repository;

import br.com.rhprojecth2.dto.JobPositionDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPositionRepository extends JpaRepository<JobPositionDTO, Long> {

    public List<JobPositionDTO> findByNameContaining (String name);

}
