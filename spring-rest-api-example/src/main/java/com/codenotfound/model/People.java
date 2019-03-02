package com.codenotfound.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * People
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class People {

    private String id;
    private String name;
    private int height;
    private int mass;
}
