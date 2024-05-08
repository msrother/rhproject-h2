package br.com.rhprojecth2.controller;

import br.com.rhprojecth2.dto.EmployeeDTO;
import br.com.rhprojecth2.service.EmployeeService;
import br.com.rhprojecth2.utils.TokenJWT;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/rhprojecth2/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employee,
                                      @RequestHeader(value = "token") String token) {
        TokenJWT.validateToken(token);
        return employeeService.save(employee);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> listAll(@RequestHeader(value = "token") String token) {
        TokenJWT.validateToken(token);
        return employeeService.listAll();
    }

    @GetMapping(value = "/searchById")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO searchById(@RequestHeader(value = "id") Long id,
                                  @RequestHeader(value = "token") String token) {
        TokenJWT.validateToken(token);
        return employeeService.searchById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee not found."));
    }

    @GetMapping(value = "/searchByName")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> searchByName(@RequestHeader(value = "name") String name,
                                          @RequestHeader(value = "token") String token) {
        TokenJWT.validateToken(token);
        return employeeService.searchByName(name);
    }

    @GetMapping(value = "/searchByDepartmentId")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> searchByDepartmentId(@RequestHeader(value = "departmentId") Long departmentId,
                                                  @RequestHeader(value = "token") String token) {
        TokenJWT.validateToken(token);
        return employeeService.searchByDepartmentId(departmentId);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployee(@RequestBody EmployeeDTO employee,
                               @RequestHeader(value = "token") String token) {
        TokenJWT.validateToken(token);
        employeeService.searchById(employee.getId())
                .map(foundEmployee -> {
                    modelMapper.map(employee, foundEmployee);
                    employeeService.save(foundEmployee);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee not found."));
    }

    @DeleteMapping(value = "/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployee(@RequestHeader(value = "id") Long id,
                               @RequestHeader(value = "token") String token) {
        TokenJWT.validateToken(token);
        employeeService.searchById(id)
                .map(employeeFound -> {
                    employeeService.removeById(employeeFound.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee not found."));
    }

}
