package org.shemenev.shaverma_cloud.shaverma;

import lombok.Data;

@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;


    public enum Type {
        PLATE, MEET, NO_MEET, CHEESE, SAUCE
    }

}
