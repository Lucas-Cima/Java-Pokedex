package com.pokedex.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pokemon {

    @Id
    private int pokemon_id;
    private int national_dex_number;
    private String pokemon_name;
    private String form;
    private String primary_type;
    private String secondary_type;
    private String species;
    private String region;
    private String height;
    private String weight;
    private String dex_entry;
    private int hp;
    private int attack;
    private int defense;
    private int special_attack;
    private int special_defense;
    private int speed;

    public Pokemon() {}

    public int getId() {
        return pokemon_id;
    }

    public int getNational_dex_number() {
        return national_dex_number;
    }

    public String getPokemon_name() {
        return pokemon_name;
    }

    public String getForm() {
        return form;
    }

    public String getPrimary_type() {
        return primary_type;
    }

    public String getSecondary_type() {
        return secondary_type;
    }

    public String getSpecies() {
        return species;
    }

    public String getRegion() {
        return region;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getDex_entry() {
        return dex_entry;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpecial_attack() {
        return special_attack;
    }

    public int getSpecial_defense() {
        return special_defense;
    }

    public int getSpeed() {
        return speed;
    }
}
