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
 * Dict
 *
 * @author ilubov
 * @date 2020/08/26
 */
@Data
@TableName("dict")
public class Dict extends Model<Dict> implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("label")
    private String label;

    @TableField("value")
    private String value;
}
