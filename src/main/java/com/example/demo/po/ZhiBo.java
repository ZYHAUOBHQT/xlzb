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

    private String pic; //封面

    private String title; //标题

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;
}
