package de.supercode.ShoppingListDB.servicies;

import de.supercode.ShoppingListDB.entities.ShoppingListItem;
import de.supercode.ShoppingListDB.repositories.ShoppingListRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;

@Service
public class ShoppingListService {
    ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public void addProductToShoppingList(ShoppingListItem shoppingListItem) {
        shoppingListRepository.save(shoppingListItem);
    }

    public List<ShoppingListItem> getShoppingList() {
        return shoppingListRepository.findAll();
    }

    public List<ShoppingListItem> findProductByStatus(boolean bought) {
        return shoppingListRepository.findByBought(bought);
    }

    public void updateProduct(long productId) {
        ShoppingListItem item = shoppingListRepository.findById(productId).orElseThrow();
        item.setBought(!item.getBought());
        shoppingListRepository.save(item);

    }

    public void deleteProduct(long listItemId) {
        shoppingListRepository.deleteById(listItemId);
    }
}
