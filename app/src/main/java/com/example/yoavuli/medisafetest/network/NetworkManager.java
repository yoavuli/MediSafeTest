package com.example.yoavuli.medisafetest.network;

public class NetworkManager implements NetworkProvider {

    private static NetworkManager mManager;

    public  static synchronized NetworkManager getIntance() {
        if (mManager == null)
            mManager = new NetworkManager();
        return mManager;
    }


    @Override
    public void getURL(final NetworkConsumer consumer , String url) {
         new HttpTask(new HTTPTaskListener() {
             @Override
             public void onTaskFinished(String message) {
                 consumer.onDownloadFinished(message);
             }

             @Override
             public void onError(String error) {
                 consumer.onError(error);
             }
         }).execute(url);
    }
}
