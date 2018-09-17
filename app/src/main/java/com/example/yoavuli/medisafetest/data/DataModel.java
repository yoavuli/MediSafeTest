package com.example.yoavuli.medisafetest.data;

public class DataModel <D> {

    private final D mData;

    public DataModel(D data) {
        mData = data;
    }

    public D getData() {
        return mData;
    }
}
