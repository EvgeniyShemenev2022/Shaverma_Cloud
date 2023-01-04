package org.shemenev.shaverma_cloud.web;


import lombok.extern.slf4j.Slf4j;
import org.shemenev.shaverma_cloud.shaverma.ShavaOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("shavaOrder")
public class OrderController {

    @GetMapping("/current")
    public String orderForm() {

        return "orderForm";
    }

    @PostMapping
    public String processOrder(ShavaOrder order, SessionStatus sessionStatus) {
        log.info("Заказ подтвержден: {}", order);
        sessionStatus.setComplete();

        return "redirect:/";
    }

}
