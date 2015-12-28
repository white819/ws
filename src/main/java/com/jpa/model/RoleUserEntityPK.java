package com.jpa.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by machaox on 12/28/2015.
 */
public class RoleUserEntityPK implements Serializable {
    private int roleid;
    private int userid;

    @Column(name = "roleid")
    @Id
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Column(name = "userid")
    @Id
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

        RoleUserEntityPK that = (RoleUserEntityPK) o;

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
