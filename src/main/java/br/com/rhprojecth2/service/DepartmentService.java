package br.com.rhprojecth2.service;

import br.com.rhprojecth2.dto.DepartmentDTO;
import br.com.rhprojecth2.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDTO save(DepartmentDTO dto) {
        return departmentRepository.save(dto);
    }

    public List<DepartmentDTO> listAll() {
        return departmentRepository.findAll();
    }

    public Optional<DepartmentDTO> searchById(Long id) {
        return departmentRepository.findById(id);
    }

    public void removeById(Long id) {
        departmentRepository.deleteById(id);
    }

    public List<DepartmentDTO> searchByName(String name) {
        return departmentRepository.findByNameContaining(name);
    }

}
