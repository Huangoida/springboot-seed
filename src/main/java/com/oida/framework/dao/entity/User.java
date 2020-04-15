package com.oida.framework.dao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键id
    */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 账号
    */
    @NotNull
    @Size(min=6, max=15, message = "名字长度必须在6和15之间")
    private String account;

    /**
    * 密码
    */
    @JsonIgnore
    private String password;

    /**
    * 用户昵称
    */
    private String name;

    /**
    * 性别（1：男 2：女）
    */
    @Range(min = 0, max = 1)
    @Min(value=0)
    private Integer sex;

    /**
    * 电子邮件
    */
    @Email
    private String email;

    /**
    * 电话
    */
    private String phone;

    /**
    * 角色id
    */
    private Integer roleid;

    /**
    * 状态(1：启用  2：冻结）
    */
    private Integer status;

    /**
    * 是否被删除
    */
    private Integer deleted;

    /**
    * 创建时间
    */
    private Date createtime;

    /**
    * 保留字段
    */
    private Integer version;

    @TableField(exist = false)//表示该属性不为数据库表字段，但又是必须使用的。
    private List<UserRole> roles;
}