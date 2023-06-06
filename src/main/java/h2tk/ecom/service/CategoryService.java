package h2tk.ecom.service;

import h2tk.ecom.model.Categories;

import java.util.List;

public interface CategoryService {

    public List<Categories> listAll();

    public void save(Categories category);

    public Categories get(int id);

    public void delete(int id);
}
