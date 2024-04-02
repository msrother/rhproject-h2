package br.com.rhprojecth2.service;

import br.com.rhprojecth2.dto.JobPositionDTO;
import br.com.rhprojecth2.repository.JobPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class JobPositionService{

    @Autowired
    private JobPositionRepository jobPositionRepository;

    public JobPositionDTO save(JobPositionDTO dto) {
        return jobPositionRepository.save(dto);
    }

    public List<JobPositionDTO> lisAll() {
        return jobPositionRepository.findAll();
    }

    public Optional<JobPositionDTO> searchById(Long id) {
        return jobPositionRepository.findById(id);
    }

    public void removeById(Long id) {
        jobPositionRepository.deleteById(id);
    }

    public List<JobPositionDTO> searchByName(String name) {
        return jobPositionRepository.findByNameContaining(name);
    }


}
