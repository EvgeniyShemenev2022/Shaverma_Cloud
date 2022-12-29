package org.shemenev.shaverma_cloud.web;


import lombok.extern.slf4j.Slf4j;
import org.shemenev.shaverma_cloud.shaverma.Ingredient;
import org.shemenev.shaverma_cloud.shaverma.Shava;
import org.shemenev.shaverma_cloud.shaverma.ShavaOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.shemenev.shaverma_cloud.shaverma.Ingredient.Type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j         // (Simple Logging Facade for Java – простой интерфейс журналирования для Java
@Controller    // отмечает класс как доступный для механизма сканирования компонентов
@RequestMapping("/design")   // будет обрабатывать запросы, пути в которых начинаются с /design.
@SessionAttributes("shavaOrder")  // указывает, что объект ShavaOrder, объявленный в классе, должен поддерживаться на уровне сеанса.
public class DesignShavermaController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("ONPL", "На Тарелке", Type.PLATE),
                new Ingredient("ROSK", "Роскошная", Type.PLATE),
                new Ingredient("KURI", "Мясная Куриная", Type.MEET),
                new Ingredient("GOVY", "Мясная с Говядиной", Type.MEET),
                new Ingredient("TOMA", "Томатная", Type.NO_MEET),
                new Ingredient("SALA", "Салатная", Type.NO_MEET),
                new Ingredient("SIRN", "Сырная", Type.CHEESE),
                new Ingredient("FOUR", "Четыре Сыра", Type.CHEESE),
                new Ingredient("CHES", "Чесночная", Type.SAUCE),
                new Ingredient("MEXC", "Мексиканская", Type.SAUCE)
        );
        Type[] types = Ingredient.Type.values();

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

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


}
