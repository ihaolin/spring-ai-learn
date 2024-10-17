package spring.ai.learn.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.ai.learn.entity.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Resource
    private ChatClient chatClient;

    @GetMapping("/recommend")
    public List<Book> recommend(@RequestParam String input){
        return chatClient
                .prompt()
                .user(input)
                .call()
                .entity(new ParameterizedTypeReference<>() {});
    }
}
