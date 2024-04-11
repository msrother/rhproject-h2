package br.com.rhprojecth2.controller;


import br.com.rhprojecth2.dto.JobPositionDTO;
import br.com.rhprojecth2.service.JobPositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/rhprojecth2/jobPosition")
public class JobPositionController {
    
    @Autowired
    private JobPositionService jobPositionService;
    
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public JobPositionDTO createJobPosition(@RequestBody JobPositionDTO jobPosition) {
        return jobPositionService.save(jobPosition);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public List<JobPositionDTO> listAll() {
        return jobPositionService.listAll();
    }

    @GetMapping(value = "/searchById")
    @ResponseStatus(HttpStatus.OK)
    public JobPositionDTO searchById(@RequestHeader(value = "id") Long id) {
        return jobPositionService.searchById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Job position not found."));
    }

    @GetMapping(value = "/searchByName")
    @ResponseStatus(HttpStatus.OK)
    public List<JobPositionDTO> searchByName(@RequestHeader(value = "name") String name) {
        return jobPositionService.searchByName(name);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateJobPosition(@RequestBody JobPositionDTO jobPosition) {
        jobPositionService.searchById(jobPosition.getId())
                .map(foundJobPosition -> {
                    modelMapper.map(jobPosition, foundJobPosition);
                    jobPositionService.save(foundJobPosition);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Job position not found."));
    }

    @DeleteMapping(value = "/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeJobPosition(@RequestHeader(value = "id") Long id) {
        jobPositionService.searchById(id)
                .map(jobPositionFound -> {
                    jobPositionService.removeById(jobPositionFound.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Job position not found."));
    }
}
