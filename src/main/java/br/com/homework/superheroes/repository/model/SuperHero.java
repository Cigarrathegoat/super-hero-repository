package br.com.homework.superheroes.repository.model;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SuperHero extends SuperPerson {

    private SuperVillain archNemesis;

}
