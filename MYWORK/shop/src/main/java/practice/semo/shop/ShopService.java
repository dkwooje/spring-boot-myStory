package practice.semo.shop;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;


    public void addList(String title,
                         Integer price,
                         String color,
                         String shape,
                            Integer age)
    {
                Shop_Dbase mamber = new Shop_Dbase();
                      mamber.setTitle(title);
                        mamber.setPrice(price);
                        mamber.setColor(color);
                          mamber.setShape(shape);
                            mamber.setAge(age);
                  shopRepository.save(mamber);
    }


}
