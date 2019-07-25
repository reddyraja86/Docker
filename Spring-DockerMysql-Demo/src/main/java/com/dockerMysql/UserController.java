package com.dockerMysql;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/users")
    public User create(@RequestBody User user)
    {
        return userRepository.save(user);
    }


    @GetMapping("/users")
    public List<User> findAll()
    {
        return userRepository.findAll();
    }


    @PutMapping("/users/{user_id}")
    public User update(@PathVariable("user_id") Long userId, @RequestBody User userObject)
    {
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.get();
        user.setName(userObject.getName());
        user.setCountry(userObject.getCountry());
        return userRepository.save(user);
    }



    @DeleteMapping("/users/{user_id}")
    public List<User> delete(@PathVariable("user_id") Long userId)
    {
    	User user= new User();
    	user.setId(userId);
        userRepository.delete(user);
        return userRepository.findAll();
    }



    @GetMapping("/users/{user_id}")
    public Optional<User> findByUserId(@PathVariable("user_id") Long userId)
    {
   
        return userRepository.findById(userId);
    }
}