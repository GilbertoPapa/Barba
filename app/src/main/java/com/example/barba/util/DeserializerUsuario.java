package com.example.barba.util;

import com.example.barba.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Gilbertopapa013 on 08/04/2017.
 */

public class DeserializerUsuario implements JsonDeserializer <Object> {

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonElement usuario = json.getAsJsonObject();

        if (json.getAsJsonObject().get("usu") != null){
            usuario = json.getAsJsonObject().get("usu");
        }


        return (new Gson().fromJson(usuario, Usuario.class));
    }
}
