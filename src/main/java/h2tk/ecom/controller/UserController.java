package h2tk.ecom.controller;

import h2tk.ecom.model.Users;
import h2tk.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiUser")
public class UserController {
    @Autowired
    private UserRepository UserRepo;

    @GetMapping("/ListUser")
    public List<Users> GetAllUser(){
        return UserRepo.findAll();
    }

    @GetMapping("/GetUserById/{id}")
    public Optional<Users> GetOneUser(@PathVariable int id){
        return UserRepo.findById(id);
    }

//    @GetMapping("/GetUserByRole/{role}")
//    public List<Users> GetUserByRole(@PathVariable String role){
//        return UserRepo.getUsersByRole(role);
//    }

    @PostMapping("/saveUser")
    public ResponseEntity<String> addUser(@ModelAttribute Users user){
        try {
            if(UserRepo.findByUsername(user.getUsername()) != null){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("UserName already exit");
            }else{
                UserRepo.save(user);
                return ResponseEntity.ok("Add A User Successfully");
            }
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Add A User Failed");
        }
    }

    @GetMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        try {
            UserRepo.deleteById(id);
            return ResponseEntity.ok("Delete User Successfully");
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete User Failed");
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @ModelAttribute Users user){
        try {
            Users exitUser = UserRepo.findById(id).orElse(null);
            if(exitUser != null){
                exitUser.setName(user.getName());
                exitUser.setAddress(user.getAddress());
                exitUser.setPassword(user.getPassword());
                exitUser.setGender(user.isGender());
                exitUser.setBirthday(user.getBirthday());
                exitUser.setActive(user.getActive());
                exitUser.setPhoneNumber(user.getPhoneNumber());
                UserRepo.save(exitUser);
                return ResponseEntity.ok("Update User Successfully");
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ID doesn't exit");
            }
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update User Failed");
        }
    }

}
