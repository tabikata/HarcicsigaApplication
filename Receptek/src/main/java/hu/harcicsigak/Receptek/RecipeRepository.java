package hu.harcicsigak.Receptek;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    // CREATE or UPDATE a Recipe
    Recipe save(Recipe recipe);

    // READ a Recipe by ID
    Optional<Recipe> findById(Long id);

    // READ all Recipes
    List<Recipe> findAll();

    // READ all Recipes by IDs
    List<Recipe> findAllById(Iterable<Long> ids);

    // DELETE a Recipe by ID
    void deleteById(Long id);

    // DELETE a Recipe
    void delete(Recipe recipe);


    // DELETE all Recipes
    void deleteAll();

}
