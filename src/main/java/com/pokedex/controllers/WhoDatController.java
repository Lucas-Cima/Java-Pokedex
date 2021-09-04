package com.pokedex.controllers;

import com.pokedex.data.PokemonRepository;
import com.pokedex.models.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pokemon")
public class WhoDatController {

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

    @RequestMapping("random")
    public String displayRandomPokemon(Model model) {
        Pokemon randPoke = randomPokemon();
        String name = randPoke.getPokemon_name();
        model.addAttribute("pokedex", randPoke);
        System.out.println("Random Pokemon Endpoint. Pokemon: " + name);

        return "pokedex/pokemon";
    }

}
