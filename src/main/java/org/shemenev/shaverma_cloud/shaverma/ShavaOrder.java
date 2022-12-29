package org.shemenev.shaverma_cloud.shaverma;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShavaOrder {

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryRegion;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private List<Shava> shavaList = new ArrayList<>();


    public void addShava(Shava shava) {
        this.shavaList.add(shava);
    }

}
