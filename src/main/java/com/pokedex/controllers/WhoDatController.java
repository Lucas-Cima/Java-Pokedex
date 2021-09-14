package com.pokedex.controllers;

import com.pokedex.data.PokemonRepository;
import com.pokedex.models.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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

    @RequestMapping("whoisthat")
    public String whoIsThatPokemon() {
        System.out.println("Who is That Endpoint");
        return "whoisthat/home";
    }

    @RequestMapping(value = "whoisthateasy", method = RequestMethod.GET)
    public String displayWhoIsThatPokemonEasy(Model model) {
        Pokemon correctPoke = randomPokemon();
        Pokemon optA = randomPokemon();
        Pokemon optB = randomPokemon();
        Pokemon optC = randomPokemon();
        model.addAttribute("correctPoke", correctPoke);
        model.addAttribute("optA", optA);
        model.addAttribute("optB", optB);
        model.addAttribute("optC", optC);
        String correctPokeName = correctPoke.getPokemon_name();
        System.out.println("Who is That Easy: " + correctPokeName);

        return"whoisthat/easy";
    }

    @RequestMapping(value = "whoisthateasy", method = RequestMethod.POST)
    public String processWhoIsThatPokemonEasy(@RequestParam(value="sub") String sub,
                                              @RequestParam(value="correctpoke") String correctpoke) {
        if(sub.equalsIgnoreCase(correctpoke)){
            return "correct";
        }
        else {
            return "wrong";
        }
    }
}




























