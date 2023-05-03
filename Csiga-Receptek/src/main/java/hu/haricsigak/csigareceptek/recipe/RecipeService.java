package hu.haricsigak.csigareceptek.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipes() {
        return this.recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipe(Long id) {
        return this.recipeRepository.findById(id);
    }

    public boolean deleteRecipe(Long id) {
        if (this.recipeRepository.findById(id).isEmpty()) return false;
        this.recipeRepository.deleteById(id);
        return true;
    }

    public void addRecipe(String name, String ingredients, String steps, Long author_id) {
        recipeRepository.save(new Recipe(name, ingredients, steps, author_id));
    }

    @Transactional
    public void updateRecipe(Long id, String name, String ingredients, String steps) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find recipe"));
        if (name != null && name.length() > 0) recipe.setName(name);
        if (ingredients != null && ingredients.length() > 0) recipe.setIngredients(ingredients);
        if (steps != null && steps.length() > 0) recipe.setSteps(steps);
    }

}
