package hu.nje.townsapp.controller;

import hu.nje.townsapp.model.Town;
import hu.nje.townsapp.model.County;
import hu.nje.townsapp.model.Population;
import hu.nje.townsapp.repository.TownsRepository;
import hu.nje.townsapp.repository.CountiesRepository;
import hu.nje.townsapp.repository.PopulationsRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final TownsRepository townsRepository;
    private final CountiesRepository countiesRepository;
    private final PopulationsRepository populationsRepository;

    public ApiController(TownsRepository townsRepository,
                         CountiesRepository countiesRepository,
                         PopulationsRepository populationsRepository) {
        this.townsRepository = townsRepository;
        this.countiesRepository = countiesRepository;
        this.populationsRepository = populationsRepository;
    }

    // ---- TOWNS ----
    @GetMapping("/towns")
    public List<Town> getTowns() {
        return townsRepository.findAll();
    }

    @GetMapping("/towns/{id}")
    public Town getTownById(@PathVariable Long id) {
        return townsRepository.findById(id).orElse(null);
    }

    // ---- COUNTIES ----
    @GetMapping("/counties")
    public List<County> getCounties() {
        return countiesRepository.findAll();
    }

    @GetMapping("/counties/{id}")
    public County getCountyById(@PathVariable Long id) {
        return countiesRepository.findById(id).orElse(null);
    }

    // ---- POPULATIONS ----
    @GetMapping("/populations")
    public List<Population> getAllPopulations() {
        return populationsRepository.findAll();
    }

    @GetMapping("/populations/{townId}")
    public List<Population> getTownPopulations(@PathVariable Long townId) {
        return populationsRepository.findByTownId(townId);
    }
}
