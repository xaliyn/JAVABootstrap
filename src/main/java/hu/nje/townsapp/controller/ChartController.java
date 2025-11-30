package hu.nje.townsapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChartController {

    @GetMapping("/charts")
    public String charts(Model model) {

        // Example static data — replace with DB query later if needed
        model.addAttribute("labels", new String[] { "Békés", "Heves", "Vas", "Pest" });
        model.addAttribute("values", new int[] { 120000, 95000, 45000, 180000 });

        return "charts";
    }
}
