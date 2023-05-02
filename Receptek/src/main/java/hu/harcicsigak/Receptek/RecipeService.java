package hu.harcicsigak.Receptek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    // CREATE or UPDATE a Recipe
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    // READ a Recipe by ID
    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    // READ all Recipes
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    // DELETE a Recipe by ID
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

}

