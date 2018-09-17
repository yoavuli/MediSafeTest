package com.example.yoavuli.medisafetest.network;

@SuppressWarnings("unused")
public interface NetworkConsumer {

    void onDownloadFinished(String result);
    void onError(String error);
}
