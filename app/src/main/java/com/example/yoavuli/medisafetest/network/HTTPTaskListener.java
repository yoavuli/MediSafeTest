package com.example.yoavuli.medisafetest.network;

interface HTTPTaskListener {

    void onTaskFinished(String message);
    void onError(String error);
}
