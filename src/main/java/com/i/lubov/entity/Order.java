/*
 * Copyright (c) 2020 ilubov
 * https://www.ilubov.cn
 * All rights reserved.
 */
package com.i.lubov.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Order
 *
 * @author ilubov
 * @date 2020/08/26
 */
@Data
@TableName("i_order")
public class Order extends Model<Order> implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("order_no")
    private String orderNo;

    @TableField("waybill_no")
    private String waybillNo;

    @TableField("input_time")
    private Date inputTime;

    @TableField("deleted")
    private String deleted;
}
