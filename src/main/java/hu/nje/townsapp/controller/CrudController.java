package hu.nje.townsapp.controller;

import hu.nje.townsapp.model.Town;
import hu.nje.townsapp.model.County;
import hu.nje.townsapp.repository.TownsRepository;
import hu.nje.townsapp.repository.CountyRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CrudController {

    private final TownsRepository townsRepo;
    private final CountyRepository countyRepo;

    public CrudController(TownsRepository townsRepo, CountyRepository countyRepo) {
        this.townsRepo = townsRepo;
        this.countyRepo = countyRepo;
    }

    // LIST PAGE
    @GetMapping("/crud")
    public String listTowns(Model model) {
        model.addAttribute("towns", townsRepo.findAll());
        return "crud";
    }

    // ADD PAGE FORM
    @GetMapping("/crud/add")
    public String addForm(Model model) {
        model.addAttribute("town", new Town());
        model.addAttribute("counties", countyRepo.findAll());
        return "crud-form";
    }

    @PostMapping("/crud/add")
    public String saveTown(@ModelAttribute Town town) {
        townsRepo.save(town);
        return "redirect:/crud";
    }

    // EDIT PAGE FORM
    @GetMapping("/crud/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("town", townsRepo.findById(id).orElseThrow());
        model.addAttribute("counties", countyRepo.findAll());
        return "crud-form";
    }

    @PostMapping("/crud/edit/{id}")
    public String updateTown(@PathVariable Long id, @ModelAttribute Town town) {
        town.setId(id);
        townsRepo.save(town);
        return "redirect:/crud";
    }

    // DELETE
    @GetMapping("/crud/delete/{id}")
    public String deleteTown(@PathVariable Long id) {
        townsRepo.deleteById(id);
        return "redirect:/crud";
    }
}
