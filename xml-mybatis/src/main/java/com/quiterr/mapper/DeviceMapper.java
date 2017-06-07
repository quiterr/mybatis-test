package com.quiterr.mapper;

import com.quiterr.model.Device;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Huangchen on 2017/5/4.
 */
public interface DeviceMapper {
    Device findByPosition(@Param("position") String position);
    void insertOne(@Param("device") Device device);
    void insertMany(@Param("deviceList") List<Device> deviceList);
}