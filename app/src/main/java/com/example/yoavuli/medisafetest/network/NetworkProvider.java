package com.example.yoavuli.medisafetest.network;

public interface NetworkProvider {

    void getURL(NetworkConsumer consumer , String url);
}
