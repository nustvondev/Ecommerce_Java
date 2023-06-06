package h2tk.ecom.service;

import h2tk.ecom.model.Categories;
import h2tk.ecom.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository CateRepo;
    @Override
    public List<Categories> listAll() {
       return CateRepo.findAll();
    }

    @Override
    public void save(Categories category) {
        
    }

    @Override
    public Categories get(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
