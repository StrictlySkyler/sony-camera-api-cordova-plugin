package com.skyler.plugin;

import org.apache.cordova.*;

import java.net.*;
import java.io.*;
import org.json.*;
import android.util.Log;

public class SonyCameraAPI extends CordovaPlugin {

  private static final String TAG = "skyler.plugin.SonyCameraAPI";

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

    try {

      final JSONObject foo = new JSONObject();

      foo.put("foo", "foo");

      if (action.equals("foo")) {

        cordova.getThreadPool().execute(new Runnable() {
          @Override
          public void run() {
            Log.v(TAG, "foo");
            this.getCallbackContext().success(foo);
          }
        });

        return true;
      }

      Log.v(TAG, "bar");
      callbackContext.error(foo);

    } catch (JSONException e) {
      e.printStackTrace();

    }

    return false;
    //String url;
    //HttpURLConnection connection;
    //String body = "";
    //String json_string = args.toString();

    //Log.d("MyOutput", json_string);

    //if (action.equals("post")) {

      //Log.d("MyOutput", "post");

      //url = "http://10.0.0.1:10000/sony/camera";
      //connection = (HttpURLConnection) new URL(url)
        //.openConnection();
      //connection.setDoOutput(true);
      //connection.setRequestProperty("Content-Type", "application/json");

      //String json = "{\"method\":\"setSelfTimer\",\"params\":[10],\"id\":1,\"version\":\"1.0\"}";
      //String json = "{\"method\":\"actTakePicture\",\"params\":[],\"id\":1,\"version\":\"1.0\"}";
      //String json = "{\"method\":\"setShootMode\",\"params\":[\"still\"],\"id\":1,\"version\":\"1.0\"}";
      //String json = "{\"method\":\"startContShooting\",\"params\":[],\"id\":1,\"version\":\"1.0\"}";

      //OutputStream output = connection.getOutputStream();
      //output.write(json.getBytes());

    //} else {

      //Log.d("MyOutput", "get");

      //url = "http://10.0.0.1:64321/scalarwebapi_dd.xml";
      //connection = (HttpURLConnection) new URL(url)
        //.openConnection();
    //}

      //BufferedReader reader = new BufferedReader(
        //new InputStreamReader(connection.getInputStream())
      //);

      //for (String line; (line = reader.readLine()) != null;) {
        //body = body + line;
      //}

      //System.out.println(body);
    //Log.d("MyOutput", "finally");

    //return true; // Returning false results in no method found error.
  }
}
