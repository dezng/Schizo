package io.jween.schizo.converter.gson;

import com.google.gson.Gson;
import io.jween.schizo.converter.StringConverter;

import java.lang.reflect.Type;

/**
 * Created by Jwn on 2018/1/8.
 */

public class GsonConverterFactory extends StringConverter.Factory {

    private final Gson gson;

    public static GsonConverterFactory create() {
        return create(new Gson());
    }

    public static GsonConverterFactory create(Gson gson) {
        if(gson == null) {
            throw new NullPointerException("gson == null");
        } else {
            return new GsonConverterFactory(gson);
        }
    }

    private GsonConverterFactory(Gson gson) {
        this.gson = gson;
    }

    @Override
    public StringConverter<?> stringConverter(Type type) {
        return new GsonStringConverter<>(gson, type);
    }
}