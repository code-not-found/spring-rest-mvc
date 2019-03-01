package com.codenotfound.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * People
 */
@NoArgsConstructor
@Data
public class People {

    private String id;
    private String name;
    private int height;
    private int mass;
}
