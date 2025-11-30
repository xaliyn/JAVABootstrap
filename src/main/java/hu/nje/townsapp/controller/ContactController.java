package hu.nje.townsapp.controller;

import hu.nje.townsapp.model.Message;
import hu.nje.townsapp.repository.MessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    private final MessageRepository messageRepository;

    public ContactController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message,
            Model model
    ) {
        Message msg = new Message();
        msg.setName(name);
        msg.setEmail(email);
        msg.setMessage(message);

        messageRepository.save(msg);

        model.addAttribute("success", "Your message has been sent!");
        return "contact";
    }
}
