package io.saud.vendingmachine.repo;

import io.saud.vendingmachine.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item,Long> {

    @Query("select i from Item i where i.code = ?1")
    Item findItemByCodeEquals(String code);
}
