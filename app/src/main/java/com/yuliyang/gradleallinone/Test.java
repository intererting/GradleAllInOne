package com.yuliyang.gradleallinone;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonQualifier;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.ToJson;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

public final class Test {
    public void run() throws Exception {
        String json = ""
                + "{\n"
                + "  \"color\": \"#ff0000\",\n"
                + "  \"height\": 768,\n"
                + "  \"width\": 1024\n"
                + "}\n";

        Moshi moshi = new Moshi.Builder()
                .add(new ColorAdapter())
                .build();
        JsonAdapter<Rectangle> jsonAdapter = moshi.adapter(Rectangle.class);

        Rectangle rectangle = jsonAdapter.fromJson(json);
        System.out.println(rectangle);
    }

    public static void main(String[] args) throws Exception {
        new Test().run();
    }

    static class Rectangle {
        int width;
        int height;
        @HexColor
        int color;

        @Override
        public String toString() {
            return String.format("%dx%d #%06x", width, height, color);
        }
    }

    @Retention(RUNTIME)
    @JsonQualifier
    public @interface HexColor {
    }

    static class ColorAdapter {
        @ToJson
        String toJson(@HexColor int rgb) {
            return String.format("#%06x", rgb);
        }

        @FromJson
        @HexColor
        int fromJson(String rgb) {
            return Integer.parseInt(rgb.substring(1), 16);
        }
    }
}
