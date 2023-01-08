package org.shemenev.shaverma_cloud.web;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.shemenev.shaverma_cloud.data.IngredientRepository;
import org.shemenev.shaverma_cloud.shaverma.Ingredient;
import org.shemenev.shaverma_cloud.shaverma.Shava;
import org.shemenev.shaverma_cloud.shaverma.ShavaOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.shemenev.shaverma_cloud.shaverma.Ingredient.Type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j         // (Simple Logging Facade for Java – простой интерфейс журналирования для Java
@Controller    // отмечает класс как доступный для механизма сканирования компонентов
@RequestMapping("/design")   // будет обрабатывать запросы, пути в которых начинаются с /design.
@SessionAttributes("shavaOrder")
// указывает, что объект ShavaOrder, объявленный в классе, должен поддерживаться на уровне сеанса.
public class DesignShavermaController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignShavermaController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            // !!! ingredients casted to List<Ingredient>
            model.addAttribute(type.toString().toLowerCase(), filterByType((List<Ingredient>) ingredients, type));
        }
    }

    /*@ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("WRLA", "Лаваш", Type.WRAP),
                new Ingredient("WRPI", "Пита", Type.WRAP),
                new Ingredient("MEKU", "Курица", Type.MEET),
                new Ingredient("MEGO", "Говядина", Type.MEET),
                new Ingredient("VETO", "Томаты", Type.VEGGIES),
                new Ingredient("VESA", "Салат", Type.VEGGIES),
                new Ingredient("CHCD", "Сыр Чеддер", Type.CHEESE),
                new Ingredient("CHFO", "Четыре Сыра", Type.CHEESE),
                new Ingredient("SASP", "Пряный", Type.SAUCE),
                new Ingredient("SAHO", "Острый", Type.SAUCE)
        );
        Type[] types = Ingredient.Type.values();

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }*/

    @ModelAttribute(name = "shavaOrder")
    public ShavaOrder order() {
        return new ShavaOrder();
    }

    @ModelAttribute(name = "shava")
    public Shava shava() {
        return new Shava();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }


    /**
     * Аннотация @Valid требует выполнить проверку отправленного
     * объекта Taco после его привязки к данным в отправленной форме, но
     * до начала выполнения тела метода processTaco().
     */
    @PostMapping
    // сообщает аннотации @RequestMapping на уровне класса, что метод будет обрабатывать запросы POST с путем /design.
    public String processTaco(@Valid Shava shava, Errors errors, @ModelAttribute ShavaOrder shavaOrder) {
        if (errors.hasErrors()) {
            return "design";
        }
        shavaOrder.addShava(shava);
        log.info("Приготовление шавермы: {}", shava);

        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}

//page 98


