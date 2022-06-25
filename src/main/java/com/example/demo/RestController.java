package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    Userrepo userrepo;

    @GetMapping("/")
    public  String welcome(){

        return "Welcome";

    }

    @PostMapping(value = "/save")
    public String saveuser(@RequestBody  UserEntity userEntity){

        userrepo.save(userEntity);

        return "saved";
    }

    @GetMapping(value = "/fetchall")
    public List<UserEntity> getuser(){

        return userrepo.findAll();
    }

    @PutMapping(value = "/updateuser/{id}")
     public  String updateuser(@PathVariable long id,@RequestBody UserEntity userEntity){

        UserEntity updateuser = userrepo.findById(id).get();
        updateuser.setUsername(userEntity.getUsername());
        updateuser.setEmail(userEntity.getEmail());
        updateuser.setPassword(userEntity.getPassword());

        userrepo.save(updateuser);

        return "Updated";

     }

     @DeleteMapping(value = "/delete/{id}")
     public  String deleteuser(@PathVariable long id){
        userrepo.deleteById(id);
        return "Deleted user with id"+id;
     }


}
