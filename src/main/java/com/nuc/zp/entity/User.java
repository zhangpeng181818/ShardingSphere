package com.nuc.zp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "t_user")
@Data
public class User {

    private Long userId;

    private String userName;

    private String userStatus;
}
