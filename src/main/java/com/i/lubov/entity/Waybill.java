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

/**
 * Waybill
 *
 * @author ilubov
 * @date 2020/08/26
 */
@Data
@TableName("i_waybill")
public class Waybill extends Model<Waybill> implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("order_no")
    private String orderNo;

    @TableField("waybill_no")
    private String waybillNo;

    @TableField("user_id")
    private Long userId;

    @TableField("deleted")
    private String deleted;
}
