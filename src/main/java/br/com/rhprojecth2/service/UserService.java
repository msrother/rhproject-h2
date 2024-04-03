package br.com.rhprojecth2.service;

import br.com.rhprojecth2.dto.UserDTO;
import br.com.rhprojecth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO save(UserDTO dto) {
        return userRepository.save(dto);
    }

    public List<UserDTO> listAll() {
        return userRepository.findAll();
    }

    public Optional<UserDTO> searchById(Long id) {
        return userRepository.findById(id);
    }

    public UserDTO searchByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserDTO> searchByPassword(String password) {
        return userRepository.findByPassword(password);
    }

    public void removeById(Long id) {
        userRepository.deleteById(id);
    }

}
