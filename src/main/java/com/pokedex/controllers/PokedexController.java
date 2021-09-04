package com.pokedex.controllers;
import com.pokedex.data.PokemonRepository;
import com.pokedex.models.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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



    public Pokemon randomPokemon() {
        Long qty = pokemonRepository.count();
        int idx = (int)(Math.random() * qty);
        Page<Pokemon> pokemonPage = pokemonRepository.findAll(PageRequest.of(idx, 1));
        Pokemon p = null;
        if (pokemonPage.hasContent()) {
            p = pokemonPage.getContent().get(0);
        }
        return p;
    }


    @RequestMapping(value = "")
    public String homePage() {
        return "home_page";
    }

    @RequestMapping("pokedex")
    public String displayFullPokedex(Model model) {
        model.addAttribute("pokedex", pokemonRepository.findAll());
        return "pokedex/pokedex";
    }

    @RequestMapping("random")
    public String displayRandomPokemon(Model model) {
        model.addAttribute("pokedex", randomPokemon());
        return "pokedex/pokemon";
    }




}
