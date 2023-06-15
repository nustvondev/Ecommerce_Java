package h2tk.ecom.controller;

import h2tk.ecom.model.Cart;
import h2tk.ecom.model.Products;
import h2tk.ecom.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add/{productId}")
    public ResponseEntity<String> addToCart(@PathVariable("productId") int productId, HttpSession session) {
        List<Cart> cartItems = getOrCreateCart(session);

        Products product = productService.get(productId);
        if (product != null && product.getId() == productId) {
            boolean productExists = false;
            for (Cart item : cartItems) {
                if (item.getProductId() == productId) {
                    item.setQuantity(item.getQuantity() + 1);
                    productExists = true;
                    break;
                }
            }

            if (!productExists) {
                Cart item = new Cart();
                item.setProductId(product.getId());
                item.setName(product.getName());
                item.setPrice(product.getPrice());
                item.setImage(product.getImage());
                item.setQuantity(1);
                cartItems.add(item);
            }
            session.setAttribute("cart", cartItems);
            return ResponseEntity.status(HttpStatus.CREATED).body("Product added to cart successfully!");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Product added to cart failed!");
    }

    @GetMapping("/view")
    public ResponseEntity<List<Cart>> viewCart(HttpSession session) {
        List<Cart> cartItems = getOrCreateCart(session);
        return ResponseEntity.ok(cartItems);
    }

    @SuppressWarnings("unchecked")
    private List<Cart> getOrCreateCart(HttpSession session) {
        List<Cart> cartItems = (List<Cart>) session.getAttribute("cart");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            session.setAttribute("cart", cartItems);
        }
        return cartItems;
    }
    
}
