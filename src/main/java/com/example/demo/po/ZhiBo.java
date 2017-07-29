package com.example.demo.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhubuqing on 2017/7/26.
 */
@Data
@Entity
@Table(name = "t_zhibo")
public class ZhiBo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //ID

    @Temporal(value = TemporalType.DATE)
    private Date createTime; //创建时间

    @Version
    private int version; //版本号

    private int pdId; //频道ID

    private String pic; //封面

    private String title; //频道名

    private int status; //状态

    private int gzNum; //关注人数

    private int zxNum; //在线人数

    private int userId; //用户ID
}
