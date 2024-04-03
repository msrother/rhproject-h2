package br.com.rhprojecth2.controller;

import br.com.rhprojecth2.dto.UserDTO;
import br.com.rhprojecth2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/rhprojecth2/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserDTO user) {
        return userService.save(user);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> listAll() {
        return userService.listAll();
    }

    @GetMapping(value = "/searchById")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO searchById(@RequestHeader(value = "id") Long id) {
        return userService.searchById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found."));
    }

    @GetMapping(value = "/searchByEmail")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO searchByEmail(@RequestHeader(value = "email") String email) {
        return userService.searchByEmail(email);
    }

    @GetMapping(value = "/searchByPassword")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> searchByPassword(@RequestHeader(value = "password") String password) {
        return userService.searchByPassword(password);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody UserDTO user) {
        userService.searchById(user.getId())
                .map(foundUser -> {
                    modelMapper.map(user, foundUser);
                    userService.save(foundUser);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found."));
    }

    @DeleteMapping(value = "/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@RequestHeader(value = "id") Long id) {
        userService.searchById(id)
                .map(userFound -> {
                    userService.removeById(userFound.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found."));
    }

}
