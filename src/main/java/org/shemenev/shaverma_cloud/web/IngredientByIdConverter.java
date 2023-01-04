package org.shemenev.shaverma_cloud.web;


import org.shemenev.shaverma_cloud.shaverma.Ingredient;
import org.shemenev.shaverma_cloud.shaverma.Ingredient.Type;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    // временное решение, пока отсутствует подключение к БД
    public IngredientByIdConverter() {
        ingredientMap.put("WRLA",
                new Ingredient("WRLA", "Лаваш", Type.WRAP));
        ingredientMap.put("WRPI",
                new Ingredient("WRPI", "Пита", Type.WRAP));
        ingredientMap.put("MEKU",
                new Ingredient("MEKU", "Курица", Type.MEET));
        ingredientMap.put("MEGO",
                new Ingredient("MEGO", "Говядина", Type.MEET));
        ingredientMap.put("VETO",
                new Ingredient("VETO", "Томаты", Type.VEGGIES));
        ingredientMap.put("VESA",
                new Ingredient("VESA", "Салат", Type.VEGGIES));
        ingredientMap.put("CHCD",
                new Ingredient("CHCD", "Сыр Чеддер", Type.CHEESE));
        ingredientMap.put("CHFO",
                new Ingredient("CHFO", "Четыре Сыра", Type.CHEESE));
        ingredientMap.put("SASP",
                new Ingredient("SASP", "Пряный", Type.SAUCE));
        ingredientMap.put("SAHO",
                new Ingredient("SAHO", "Острый", Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {

        return ingredientMap.get(id);
    }


}
