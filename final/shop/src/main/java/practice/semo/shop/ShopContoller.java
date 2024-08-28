package practice.semo.shop;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ShopContoller {

    private final ShopRepository shopRepository;
 //   private final ShopService shopService;

    @GetMapping("/shop")
    String shop(){
        return "/shopping/main.html";
    }

    @GetMapping("/list123")
    List<ShopDbase> list(Model model){
        List<ShopDbase> result = shopRepository.findAll();
        model.addAttribute("ITEM",result);
        return result;
    }

    @GetMapping("/write")
    String write() {
        return "/manage/listwrite.html";
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
