package com.baomidou.springmvc.model.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("sys_file")
@Data
public class SysFile implements Serializable {

    @TableId(value ="id",type = IdType.UUID)
    private  String id;

    private  String fileName;

    private  String fileType;

    private  String filePath;

    private  Long fileSize;

    private  int fileStatus;

    private  String fileFid;

    private Date fileCreatedate;

    private  String fileFormat;

}
