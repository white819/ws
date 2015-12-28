package com.jpa.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by machaox on 12/28/2015.
 */
public class PermissionRoleEntityPK implements Serializable {
    private int roleid;
    private int permissionid;

    @Column(name = "roleid")
    @Id
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Column(name = "permissionid")
    @Id
    public int getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(int permissionid) {
        this.permissionid = permissionid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermissionRoleEntityPK that = (PermissionRoleEntityPK) o;

        if (roleid != that.roleid) return false;
        if (permissionid != that.permissionid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleid;
        result = 31 * result + permissionid;
        return result;
    }
}
