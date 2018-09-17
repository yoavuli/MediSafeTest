package com.example.yoavuli.medisafetest.network;

public class NetworkFactory {


    public static  NetworkProvider getNetworkProvider (){

        return NetworkManager.getIntance();
    }
}
