package com.zt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2019-12-03 17:24:25
 */
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    private static final long serialVersionUID = -69934157441703154L;

    private Integer id;

    private String name;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}