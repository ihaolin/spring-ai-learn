package spring.ai.learn.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.ai.learn.entity.Book;

import java.util.List;

@RestController
@RequestMapping("/translators")
public class TranslatorController {

    @Resource
    private ChatClient chatClient;

    @GetMapping("/jp-zh")
    public List<Book> recommend(@RequestParam String input){
        return chatClient
                .prompt()
                .system("你是一个翻译器，需要翻译日文到中文")
                .user(input)
                .call()
                .entity(new ParameterizedTypeReference<>() {});
    }
}
