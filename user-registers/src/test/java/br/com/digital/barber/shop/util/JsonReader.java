package br.com.digital.barber.shop.util;

import br.com.digital.barber.shop.domain.usercases.ClientUsercaseTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonReader {

    public static String getJson(){
        String json;
        try {
            Path resourceDirectory = Paths.get("src","test", "java","resources", "jsons","teste.json");
            json = Files.readString(resourceDirectory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    public static String getJsonError(){
        String json;
        try {
            Path resourceDirectory = Paths.get("src","test", "java","resources", "jsons","teste_error.json");
            json = Files.readString(resourceDirectory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}
