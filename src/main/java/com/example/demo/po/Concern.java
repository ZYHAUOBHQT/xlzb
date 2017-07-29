package com.example.demo.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhubuqing on 2017/7/29.
 */
@Data
@Entity
@Table(name = "t_concern")
public class Concern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //ID

    @Temporal(value = TemporalType.DATE)
    private Date createTime; //创建时间

    @Version
    private int version; //版本号

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user; //用户

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "zhiBo_id")
    private ZhiBo zhiBo; //直播
}
