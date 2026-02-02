package fi.haagahelia.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

    @GetMapping("/index")
    @ResponseBody
    public String showIndex() {
        return "Welcome to the Bookstore!";
    }
}