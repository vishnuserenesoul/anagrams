package com.anagram.app;

import com.anagram.app.services.Dictionary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnagramDictApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnagramDictApplication.class, args);
		Dictionary d = Dictionary.getInstance().withInitializedData(args.length>0&&args[0]!=null?args[0]:"https://users.cs.duke.edu/~ola/ap/linuxwords");
	}
}
