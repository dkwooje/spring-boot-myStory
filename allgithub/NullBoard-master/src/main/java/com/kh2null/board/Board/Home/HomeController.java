package com.kh2null.board.Board.Home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToBoard() {
        return "redirect:/board";
    }

}
