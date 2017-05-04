package com.quiterr.model;

/**
 * Created by Huangchen on 2017/5/4.
 */
public class Device {
    private Integer deviceId;
    private Integer type;
    private String position;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", type=" + type +
                ", position='" + position + '\'' +
                '}';
    }
}
