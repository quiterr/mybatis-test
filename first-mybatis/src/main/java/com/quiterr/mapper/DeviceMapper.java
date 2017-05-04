package com.quiterr.mapper;

import com.quiterr.model.Device;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Huangchen on 2017/5/4.
 */
public interface DeviceMapper {
    Device findByPosition(@Param("position") String position);
}