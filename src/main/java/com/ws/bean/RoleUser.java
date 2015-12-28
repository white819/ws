package com.ws.bean;

import javax.persistence.*;

/**
 * Created by machaox on 12/28/2015.
 */
@Entity
@Table(name = "role_user", schema = "", catalog = "bim")
@IdClass(RoleUserPK.class)
public class RoleUser {
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

        RoleUser roleUser = (RoleUser) o;

        if (roleid != roleUser.roleid) return false;
        if (userid != roleUser.userid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleid;
        result = 31 * result + userid;
        return result;
    }
}
