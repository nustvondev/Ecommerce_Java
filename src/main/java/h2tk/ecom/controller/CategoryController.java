package h2tk.ecom.controller;

import h2tk.ecom.model.Categories;
import h2tk.ecom.repository.CategoryRepository;
import h2tk.ecom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryRepository CateRepo;

    @GetMapping("/ListCategory")
    public List<Categories> listAll() {
        return CateRepo.findAll();
    }

    @PostMapping("/saveCategory")
    public Categories Addcategory(@RequestBody Categories category){
        return CateRepo.save(category);
    }
}
