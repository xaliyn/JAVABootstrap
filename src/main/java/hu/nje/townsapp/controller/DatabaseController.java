package hu.nje.townsapp.controller;

import hu.nje.townsapp.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DatabaseController {

    private final DatabaseService databaseService;

    @GetMapping("/database")
    public String databasePage(Model model) {

        model.addAttribute("counties", databaseService.getCounties());
        model.addAttribute("towns", databaseService.getTowns());
        model.addAttribute("populations", databaseService.getPopulations());

        return "database";
    }
}
