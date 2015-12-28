package com.jpa.model;

import javax.persistence.*;

/**
 * Created by machaox on 12/28/2015.
 */
@Entity
@Table(name = "role_user", schema = "", catalog = "bim")
@IdClass(RoleUserEntityPK.class)
public class RoleUserEntity {
    private int roleid;
    private int userid;

    @Id
    @Column(name = "roleid")
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Id
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleUserEntity that = (RoleUserEntity) o;

        if (roleid != that.roleid) return false;
        if (userid != that.userid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleid;
        result = 31 * result + userid;
        return result;
    }
}
