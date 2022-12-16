package br.com.homework.superheroes.api.api;


import br.com.homework.superheroes.api.dto.SuperHeroListResponseDTO;
import br.com.homework.superheroes.api.dto.SuperHeroResponseDTO;
import br.com.homework.superheroes.repository.model.SuperHero;
import br.com.homework.superheroes.service.ISuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/V1/superhero")
public class SuperHeroAPI {

    @Autowired
    private ISuperHeroService superHeroService;

    @PostMapping("/new")
    public SuperHeroResponseDTO addWithBody(@RequestBody SuperHero superHero){
        return SuperHeroResponseDTO.builder()
                .data(superHeroService.save(superHero))
                .build();
    }

    @GetMapping("/find/{name}")
    public SuperHeroResponseDTO find(@PathVariable("name") String name){
        return SuperHeroResponseDTO.builder()
                .data(superHeroService.findSuperHeroByName(name))
                .build();
    }

    @GetMapping("/list")
    public SuperHeroListResponseDTO listAllSuperheroes(){
        return SuperHeroListResponseDTO.builder()
                .data(superHeroService.listAll())
                .build();
    }

    @PutMapping("/change/{name}")
    public SuperHeroResponseDTO changeWithBody(@RequestBody SuperHero superHero){
        return SuperHeroResponseDTO.builder()
                .data(superHeroService.update(superHero))
                .build();

    }
}
