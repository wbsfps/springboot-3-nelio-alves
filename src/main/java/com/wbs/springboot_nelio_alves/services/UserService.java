package com.wbs.springboot_nelio_alves.services;

import com.wbs.springboot_nelio_alves.entities.User;
import com.wbs.springboot_nelio_alves.repository.UserRepository;
import com.wbs.springboot_nelio_alves.resources.exceptions.ResourceExceptionHandler;
import com.wbs.springboot_nelio_alves.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User newUser) {
        User entity = repository.getReferenceById(id);
        updateData(entity, newUser);
        return repository.save(entity);
    }

    private void updateData(User entity, User newUser) {
        entity.setName(newUser.getName());
        entity.setEmail(newUser.getEmail());
        entity.setPhone(newUser.getPhone());
    }
}