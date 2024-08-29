package practice.semo.shop;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ShopContoller {

    private final ShopRepository shopRepository;
    private final ShopService shopService;

    @GetMapping("/shop")
    String shop(){
        return "/shopping/main.html";
    }

    @GetMapping("/list123")
    String list(Model model){
        List<Shop_Dbase> result = shopRepository.findAll();
        model.addAttribute("item",result);
        return "shopping/list.html";
    }

    @GetMapping("/shop/write")
    String write() {
        return "/manage/listwrite.html";
    }

    @PostMapping("/shop/add")
    String add(String title,Integer price,String color,String shape,Integer age){
        shopService.addList( title, price, color, shape, age);
        return "redirect:/shopping/main";
    }



    @GetMapping("/rocket123")
    String listrocket(){
        return "/shopping/rocket.html";
    }
    @GetMapping("/chance123")
    String chance(){
        return "/shopping/chance.html";
    }
    @GetMapping("/forigner123")
    String forigner(){
        return "/shopping/forigner.html";
    }

}
