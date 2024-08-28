package practice.semo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;

@Controller   // public static void main(String[] args) 없이 실행 가능
public class Index {
    @GetMapping("/")
    @ResponseBody  // return의 값을 그대로 가져온다.
    String hello() {
        return "<h4>반갑습니다.</h4>";
    }
}