package jp.eightbit.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import jp.eightbit.exam.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
