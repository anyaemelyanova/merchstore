package ru.java.merchStore.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
@CrossOrigin(origins = "*", maxAge=3600)
public class MainController {
}
