package com.atguigu.cloud.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 表名：t_account
 */
@Table(name = "t_account")
@Getter
@Setter
public class Account implements Serializable
{
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 总额度
     */
    private Long total;

    /**
     * 已用余额
     */
    private Long used;

    /**
     * 剩余可用额度
     */
    private Long residue;

    @Override
    public String toString()
    {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", total=" + total +
                ", used=" + used +
                ", residue=" + residue +
                '}';
    }
}