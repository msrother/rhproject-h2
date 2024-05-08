package br.com.rhprojecth2.controller;


import br.com.rhprojecth2.dto.DepartmentDTO;
import br.com.rhprojecth2.service.DepartmentService;
import br.com.rhprojecth2.utils.TokenJWT;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/rhprojecth2/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO department,
                                          @RequestHeader(value = "token") String token) {
        TokenJWT.validateToken(token);
        return departmentService.save(department);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public List<DepartmentDTO> listAll(@RequestHeader(value = "token") String token) {
        TokenJWT.validateToken(token);
        return departmentService.listAll();
    }

    @GetMapping(value = "/searchById")
    @ResponseStatus(HttpStatus.OK)
    public DepartmentDTO searchById(@RequestHeader(value = "id") Long id,
                                    @RequestHeader(value = "token") String token) {
        TokenJWT.validateToken(token);
        return departmentService.searchById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Department not found."));
    }

    @GetMapping(value = "/searchByName")
    @ResponseStatus(HttpStatus.OK)
    public List<DepartmentDTO> searchByName(@RequestHeader(value = "name") String name,
                                            @RequestHeader(value = "token") String token) {
        TokenJWT.validateToken(token);
        return departmentService.searchByName(name);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDepartment(@RequestBody DepartmentDTO department,
                                 @RequestHeader(value = "token") String token) {
        TokenJWT.validateToken(token);
        departmentService.searchById(department.getId())
                .map(foundDepartment -> {
                    modelMapper.map(department, foundDepartment);
                    departmentService.save(foundDepartment);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Department not found."));
    }

    @DeleteMapping(value = "/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeDepartment(@RequestHeader(value = "id") Long id,
                                 @RequestHeader(value = "token") String token) {
        TokenJWT.validateToken(token);
        departmentService.searchById(id)
                .map(departmentFound -> {
                    departmentService.removeById(departmentFound.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Department not found."));
    }

}
