package com.tgreenidge.songr.SongApplication;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello";
    }

    @GetMapping("/capitalize/{text}")
    public String capitalizeWords(@PathVariable String text){

        return text.toUpperCase();
    }

    @GetMapping("/reverse")
    @ResponseBody
    public String reverseWords(@RequestParam String sentence){
        System.out.println(sentence);
        StringBuilder reversed = new StringBuilder();
        String[] words = sentence.split(" ");

        for(int i = words.length - 1; i >= 0; i--){
            reversed.append(words[i]);
            if(i != 0)
                reversed.append(" ");
        }


        return reversed.toString();
    }
}
