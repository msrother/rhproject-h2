package br.com.rhprojecth2.service;

import br.com.rhprojecth2.dto.EmployeeDTO;
import br.com.rhprojecth2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDTO save(EmployeeDTO dto) {
        return employeeRepository.save(dto);
    }

    public List<EmployeeDTO> listAll() {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeDTO> searchById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<EmployeeDTO> searchByName(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    public List<EmployeeDTO> searchByDepartmentId(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    public void removeById(Long id) {
        employeeRepository.deleteById(id);
    }

}
