package com.zt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Article)实体类
 *
 * @author makejava
 * @since 2019-12-03 17:33:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    private static final long serialVersionUID = 789584932076736244L;

    private Integer id;

    private String title;

    private String content;

    private Object date;


}