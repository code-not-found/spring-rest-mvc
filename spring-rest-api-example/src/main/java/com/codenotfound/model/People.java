package com.codenotfound.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * People
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonPropertyOrder({"id", "name", "height", "mass", "hair_color", "skin_color", "eye_color",
        "birth_year", "gender", "created", "edited"})
public class People {

    private String id;
    private String name;
    private int height;
    private int mass;
    private @JsonProperty("hair_color") String hairColor;
    private @JsonProperty("skin_color") String skinColor;
    private @JsonProperty("eye_color") String eyeColor;
    private @JsonProperty("birth_year") String birthYear;
    private String gender;
    private Date created;
    private Date edited;
}
