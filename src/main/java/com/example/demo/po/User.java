package com.example.demo.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhubuqing on 2017/7/26.
 */
@Data
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //ID

    @Temporal(value = TemporalType.DATE)
    private Date createTime; //创建时间

    @Version
    private int version; //版本号

    @Column(nullable = false, length = 40)
    private String username; //用户名

    @Column(nullable = false, length = 32)
    private String password; //密码

    private int userId;

    private String nickname;

    private String headPic; //头像
}
