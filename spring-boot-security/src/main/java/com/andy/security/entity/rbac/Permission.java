package com.andy.security.entity.rbac;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * 权限信息
 *
 * @author: Mr.ruoLin
 * @createBy: 2018-04-19
 **/
@Data
@ApiModel("权限实体")
@Table(name = "t_permission")
public class Permission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long permissionId;

    @Column(columnDefinition = "varchar(128) NOT NULL COMMENT '权限名称'")
    private String permissionName;

    @Column(columnDefinition = "varchar(128) NOT NULL COMMENT '资源路径'")
    private String url;

    @Column(columnDefinition = "integer NOT NULL COMMENT '父编号'")
    private Long parentId;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "integer NOT NULL COMMENT '资源类型，[menu|button]'")
    private ResourceType type;

    @CreatedDate
    @Column(columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private Date createTime;

    @LastModifiedDate
    @Column(columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'")
    private Date updateTime;

    @Column(columnDefinition = "bit NOT NULL COMMENT '是否可用'")
    private Boolean disable;

    @Column(columnDefinition = "bit NOT NULL COMMENT '是否删除'")
    private Boolean deleted;

    private enum ResourceType {
        MENU, BUTTON
    }

}