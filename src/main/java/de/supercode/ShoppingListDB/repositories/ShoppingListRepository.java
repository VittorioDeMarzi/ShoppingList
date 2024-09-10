package de.supercode.ShoppingListDB.repositories;

import de.supercode.ShoppingListDB.entities.ShoppingListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingListRepository extends JpaRepository<ShoppingListItem, Long> {
    List<ShoppingListItem> findByBought(Boolean bought);
}
