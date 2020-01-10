package cn.zanezz.demo.entity;

import java.io.Serializable;

public class RolesUser implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer rid;

    /**
     * 
     */
    private Integer uid;

    /**
     * roles_user
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return rid 
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * 
     * @param rid 
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * 
     * @return uid 
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 
     * @param uid 
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", rid=").append(rid);
        sb.append(", uid=").append(uid);
        sb.append("]");
        return sb.toString();
    }
}