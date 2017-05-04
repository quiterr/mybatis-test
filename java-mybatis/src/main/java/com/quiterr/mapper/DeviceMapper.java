package com.quiterr.mapper;

import com.quiterr.model.Device;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Huangchen on 2017/5/4.
 */
public interface DeviceMapper {
    @Select("SELECT * FROM devices WHERE position = #{position}")
    Device findByPosition(@Param("position") String position);
}
