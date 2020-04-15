package com.oida.framework.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 序号
    */
    private Integer roleid;

    /**
    * 角色名称
    */
    private String name;

    /**
    * 用户权限
    */
    private String permission;

    /**
    * 提示
    */
    private String tips;

    /**
    * 保留字段
    */
    private Integer version;

    /**
    * 逻辑删除
    */
    private Integer deleted;

}