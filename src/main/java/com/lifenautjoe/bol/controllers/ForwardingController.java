package com.lifenautjoe.bol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// For self-containment sake.
// This forwarding shouldn't be done on application level but server level.

@Controller
public class ForwardingController {
    @RequestMapping("/auth")
    public String auth() {
        return forwardToRoot();
    }

    @RequestMapping("/games")
    public String games() {
        return forwardToRoot();
    }

    @RequestMapping("/game")
    public String game() {
        return forwardToRoot();
    }

    public String forwardToRoot() {
        return "forward:/";
    }

}