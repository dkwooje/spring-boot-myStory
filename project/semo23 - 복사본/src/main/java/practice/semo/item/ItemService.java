package practice.semo.item;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ItemService {


    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price){
            Item item = new Item();
            item.setTitle(title);
            item.setPrice(price);
            itemRepository.save(item);
        }


    public void editItem(String title, Integer price, Long post_id){

        Item item = new Item();
        item.setPost_id(post_id);
        item.setPrice(price);
        item.setTitle(title);
        itemRepository.save(item);

       }

    public void deleteItem(Long id){
        itemRepository.deleteById(id);

    }


    }

