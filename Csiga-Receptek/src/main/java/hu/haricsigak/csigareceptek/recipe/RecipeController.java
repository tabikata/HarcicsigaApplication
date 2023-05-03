package hu.haricsigak.csigareceptek.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping(path = "api/v1/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getRecipes() {
        return this.recipeService.getRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable(value = "id") Long id) {
        return this.recipeService.getRecipe(id).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "Unable to find recipe"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecipe(@PathVariable(value = "id") Long id) {
        if (!this.recipeService.deleteRecipe(id)) throw new ResponseStatusException(NOT_FOUND, "Unable to find recipe");
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRecipe(@RequestBody Recipe recipe) {
        this.recipeService.addRecipe(recipe.getName(), recipe.getIngredients(), recipe.getSteps(), recipe.getAuthor_id());
    }

    @PutMapping("/{id}")
    public void updateRecipe(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String ingredients,
            @RequestParam(required = false) String steps
    ) {
        this.recipeService.updateRecipe(id, name, ingredients, steps);
    }
}
