package com.ws.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by machaox on 12/28/2015.
 */
public class Mo {
    private int id;
    private String name;
    private String description;
    private Integer available;
    private Integer totalAmount;
    private int catalog;
    private Integer version;
    private Timestamp timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCatalog() {
        return catalog;
    }

    public void setCatalog(int catalog) {
        this.catalog = catalog;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mo mo = (Mo) o;

        if (id != mo.id) return false;
        if (catalog != mo.catalog) return false;
        if (name != null ? !name.equals(mo.name) : mo.name != null) return false;
        if (description != null ? !description.equals(mo.description) : mo.description != null) return false;
        if (available != null ? !available.equals(mo.available) : mo.available != null) return false;
        if (totalAmount != null ? !totalAmount.equals(mo.totalAmount) : mo.totalAmount != null) return false;
        if (version != null ? !version.equals(mo.version) : mo.version != null) return false;
        if (timestamp != null ? !timestamp.equals(mo.timestamp) : mo.timestamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (available != null ? available.hashCode() : 0);
        result = 31 * result + (totalAmount != null ? totalAmount.hashCode() : 0);
        result = 31 * result + catalog;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }
}
