package com.pokedex.controllers;
import com.pokedex.data.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("")
public class PokedexController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @RequestMapping(value = "")
    public String homePage() {
        return "home_page";
    }

    @RequestMapping("pokedex")
    public String displayFullPokedex(Model model) {
        model.addAttribute("pokedex", pokemonRepository.findAll());
        return "pokedex/pokedex";
    }
}
