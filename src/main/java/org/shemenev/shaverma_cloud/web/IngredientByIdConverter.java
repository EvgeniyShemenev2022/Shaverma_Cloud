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
        ingredientMap.put("FLTO",
                new Ingredient("WRLA", "Лаваш", Type.WRAP));
        ingredientMap.put("COTO",
                new Ingredient("WRPI", "Пита", Type.WRAP));
        ingredientMap.put("GRBF",
                new Ingredient("MEKU", "Курица", Type.MEET));
        ingredientMap.put("CARN",
                new Ingredient("MEGO", "Говядина", Type.MEET));
        ingredientMap.put("TMTO",
                new Ingredient("VETO", "Томаты", Type.VEGGIES));
        ingredientMap.put("LETC",
                new Ingredient("VESA", "Салат", Type.VEGGIES));
        ingredientMap.put("CHED",
                new Ingredient("CHCD", "Сыр Чеддер", Type.CHEESE));
        ingredientMap.put("JACK",
                new Ingredient("CHFO", "Четыре Сыра", Type.CHEESE));
        ingredientMap.put("SLSA",
                new Ingredient("SASP", "Пряный", Type.SAUCE));
        ingredientMap.put("SRCR",
                new Ingredient("SAHO", "Острый", Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {

        return ingredientMap.get(id);
    }


}
