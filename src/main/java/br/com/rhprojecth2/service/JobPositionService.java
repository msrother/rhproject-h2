package br.com.rhprojecth2.service;

import br.com.rhprojecth2.dto.JobPositionDTO;
import br.com.rhprojecth2.repository.JobPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPositionService{

    @Autowired
    private JobPositionRepository jobPositionRepository;

    public JobPositionDTO save(JobPositionDTO dto) {
        return jobPositionRepository.save(dto);
    }

    public List<JobPositionDTO> listAll() {
        return jobPositionRepository.findAll();
    }

    public Optional<JobPositionDTO> searchById(Long id) {
        return jobPositionRepository.findById(id);
    }

    public List<JobPositionDTO> searchByName(String name) {
        return jobPositionRepository.findByNameContaining(name);
    }

    public void removeById(Long id) {
        jobPositionRepository.deleteById(id);
    }

}
