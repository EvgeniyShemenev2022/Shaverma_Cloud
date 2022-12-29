package org.shemenev.shaverma_cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Контроллеры занимаются извлечением и обработкой данных в веб-приложениях
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }


}
