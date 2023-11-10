package jp.eightbit.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.eightbit.exam.entity.Item;
import jp.eightbit.exam.repository.ItemRepository;

@Service
public class ItemService {
	 @Autowired
	  private ItemRepository itemRepo;

	  @Transactional
	  public List<Item> findAll() {
	    return itemRepo.findAll();
	  }

	  @Transactional
	  public Item findOne(Long id) {
	    return itemRepo.findById(id).get();
	  }

	  @Transactional
	  public void save(Item item) {
		  itemRepo.save(item);
	  }

	  @Transactional
	  public void update(Item item) {
		  itemRepo.save(item);
	  }

	  @Transactional
	  public void delete(Long id) {
		  itemRepo.deleteById(id);
	  }
}
