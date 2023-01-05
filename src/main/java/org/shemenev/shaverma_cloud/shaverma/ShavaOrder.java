package org.shemenev.shaverma_cloud.shaverma;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShavaOrder {

    @NotBlank(message="обязательное поле")
    private String deliveryName;

    @NotBlank(message="обязательное поле")
    private String deliveryStreet;

    @NotBlank(message="обязательное поле")
    private String deliveryCity;

    @NotBlank(message="обязательное поле")
    private String deliveryRegion;

    @NotBlank(message="обязательное поле")
    private String deliveryZip;

    @CreditCardNumber(message="неверный номер карты")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="формат MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="некорректный CVV")
    private String ccCVV;

    private List<Shava> shavaList = new ArrayList<>();


    public void addShava(Shava shava) {
        this.shavaList.add(shava);
    }

}

