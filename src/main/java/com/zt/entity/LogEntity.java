package com.zt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class LogEntity {
    private String id;
    private String thing;
    private String name;
    private Date date;
    private Boolean flag;
}
