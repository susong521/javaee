package edu.whu.demo.controller;

import edu.whu.demo.dao.UserDao;
import edu.whu.demo.domain.User;
import edu.whu.demo.domain.UserDto;
import edu.whu.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping("")
    @PreAuthorize("hasAuthority('user/query')")
    public ResponseEntity<List<User>> findAllUser(){
        List<User> userList = userService.list();
        return ResponseEntity.ok(userList);
    }


    @PostMapping
    @PreAuthorize("hasAuthority('user/update')")
    public ResponseEntity<Void> addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{userName}")
    @PreAuthorize("hasAuthority('user/update')")
    public ResponseEntity<Void> deleteUser(@PathVariable String userName){
        userService.deleteUser(userName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{userName}")
    @PreAuthorize("hasAuthority('user/query') or #userName == authentication.name")
    public ResponseEntity<UserDto> getUser(@PathVariable String userName){
       UserDto userDto = userService.getUser(userName);
       return ResponseEntity.ok(userDto);
    }


    @PutMapping("")
    @PreAuthorize("hasAuthority('user/update') or #user.id == authentication.name")
    public ResponseEntity<Void> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return ResponseEntity.ok().build();
    }



}
