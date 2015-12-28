package com.jpa.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by machaox on 12/28/2015.
 */
@Entity
@Table(name = "mo", schema = "", catalog = "bim")
public class MoEntity {
    private int id;
    private String name;
    private String description;
    private Integer available;
    private Integer totalAmount;
    private int catalog;
    private Integer version;
    private Timestamp timestamp;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "available")
    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    @Basic
    @Column(name = "total_amount")
    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Basic
    @Column(name = "catalog")
    public int getCatalog() {
        return catalog;
    }

    public void setCatalog(int catalog) {
        this.catalog = catalog;
    }

    @Basic
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "timestamp")
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

        MoEntity moEntity = (MoEntity) o;

        if (id != moEntity.id) return false;
        if (catalog != moEntity.catalog) return false;
        if (name != null ? !name.equals(moEntity.name) : moEntity.name != null) return false;
        if (description != null ? !description.equals(moEntity.description) : moEntity.description != null)
            return false;
        if (available != null ? !available.equals(moEntity.available) : moEntity.available != null) return false;
        if (totalAmount != null ? !totalAmount.equals(moEntity.totalAmount) : moEntity.totalAmount != null)
            return false;
        if (version != null ? !version.equals(moEntity.version) : moEntity.version != null) return false;
        if (timestamp != null ? !timestamp.equals(moEntity.timestamp) : moEntity.timestamp != null) return false;

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
