package com.renovatemate.renovatemate.controllers;

import com.renovatemate.renovatemate.entities.Tool;
import com.renovatemate.renovatemate.entities.User;
import com.renovatemate.renovatemate.services.ToolService;
import com.renovatemate.renovatemate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tools")
public class ToolController {

    // widok - 'modyfikuj swoje narzędzia w bazie danych'

    @Autowired
    private ToolService toolService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String getTools(Authentication authentication, Model model) {
        User user = userService.findByUsername(authentication.getName());
        model.addAttribute("tools", toolService.findAllByUser(user));
        model.addAttribute("tool", new Tool());
        return "tools";
    }

    @PostMapping
    public String addTool(Authentication authentication, Tool tool) {
        User user = userService.findByUsername(authentication.getName());
        toolService.save(tool, user);
        return "redirect:/tools";
    }
}
