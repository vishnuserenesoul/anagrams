package com.anagram.app.web;

import com.anagram.app.services.AnagramHelper;
import com.anagram.app.services.Dictionary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@RequestMapping("/v1/anagrams")
@RestController
public class AnagramController {

    @RequestMapping(value = {"/health"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String checkHealth() {
        return "{\"status\" : \"green\"}";
    }

    @RequestMapping(value = "/word/{_input}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getAnagrams(@NotNull @PathVariable("_input") String input) {

        try {
            if (invalidInputWord(input)) {
                return getNotFoundResponseEntity(input, "{ No Anagrams for input %s }");
            } else {

                Set<String> output = AnagramHelper.getAnagramsFromDictionary(input);
                if (output.isEmpty()) {
                    return getNotFoundResponseEntity(input, "{ No Anagrams for input %s }");
                }

                return new ResponseEntity<>(output, generateHeaders(),HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, generateHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    private ResponseEntity<?> getNotFoundResponseEntity(String input, String s) {
        return new ResponseEntity<>(String.format(s, input),generateHeaders(), HttpStatus.NOT_FOUND);
    }

    private boolean invalidInputWord(String word) {
        return word == null || word.isEmpty() || !Dictionary.getInstance().contains(word);
    }

    private static HttpHeaders generateHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}