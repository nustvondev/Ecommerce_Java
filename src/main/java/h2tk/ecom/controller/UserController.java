package h2tk.ecom.controller;

import h2tk.ecom.model.*;
import h2tk.ecom.repository.GendersRepository;
import h2tk.ecom.repository.StatusRepository;
import h2tk.ecom.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/apiUser")
public class UserController {


    @Autowired
    private UserRepository UserRepo;

    @Autowired
    private GendersRepository GenderRepo;



    @Autowired
    private StatusRepository StatusRepo;

//    private final EmailService emailService;
//    @Autowired
//    public UserController(EmailService emailService) {
//        this.emailService = emailService;
//    }

    @GetMapping("/ListUser")
    public List<Users> GetAllUser(){
        return UserRepo.findAll();
    }

    @GetMapping("/ListGender")
    public List<Genders> GetAllGender(){
        return GenderRepo.findAll();
    }

    @GetMapping("/ListStatus")
    public List<Status> GetAllStatus(){
        return StatusRepo.findAll();
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
//                UUID uuid = UUID.randomUUID();
//                String token = uuid.toString();
//                user.setToken(token);
//                String subject = "Notification";
//                String text = "This is a notification email.";
//                emailService.sendEmail(user.getEmail(), subject, text);
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
                exitUser.setGenders(user.getGenders());
                exitUser.setBirthday(user.getBirthday());
                exitUser.setStatus(user.getStatus());
                exitUser.setPhoneNumber(user.getPhoneNumber());
                exitUser.setRole(user.getRole());
                UserRepo.save(exitUser);
                return ResponseEntity.ok("Update User Successfully");
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ID doesn't exit");
            }
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update User Failed");
        }
    }

    @PostMapping("/userLogin")
    public ResponseEntity<String> login(@RequestParam String userName,
                                        @RequestParam String password,
                                        HttpSession session
                                        ){
        try{
            Users exitUser = UserRepo.findByUsername(userName);
            if(exitUser != null  && exitUser.getPassword().equals(password)){
                if(  exitUser.getStatus().getId() == 1){
                    session.setAttribute("user", exitUser);
                    return ResponseEntity.ok("Login Success");
                }else{
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("This account wasn't Activated");
                }

            }else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Wrong user name or password");
            }
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login Failed");
        }
    }
    @GetMapping("/GetSessionUser")
    public Users getSessionUser(HttpSession session){
        Users user = (Users) session.getAttribute("user");
        return user;
    }
}
