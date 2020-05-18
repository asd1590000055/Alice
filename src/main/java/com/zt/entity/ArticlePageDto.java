package com.zt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticlePageDto implements Serializable {
    private Integer page;
    private Integer total;
    private Integer records;
    private List<Article> rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        this.records = records;
    }

    public List<Article> getRows() {
        return rows;
    }

    public void setRows(List<Article> rows) {
        this.rows = rows;
    }
}
