package hu.nje.townsapp.controller;

import hu.nje.townsapp.repository.MessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessagesController {

    private final MessageRepository messageRepository;

    public MessagesController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/messages")
    public String viewMessages(Model model) {
        model.addAttribute("messages", messageRepository.findAll());
        return "messages";
    }
}
