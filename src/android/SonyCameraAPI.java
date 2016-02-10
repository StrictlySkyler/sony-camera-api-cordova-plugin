package com.skyler.camera.sony;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import java.net.*;
import java.io.*;
import org.json.*;
import android.util.Log;

public class SonyCameraAPI extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

    String url;
    HttpURLConnection connection;
    String body = "";
    String json_string = args.toString();

    Log.d("MyOutput", json_string);

    if (action.equals("post")) {

      url = "http://10.0.0.1:10000/sony/camera";
      connection = (HttpURLConnection) new URL(url)
        .openConnection();
      connection.setDoOutput(true);
      connection.setRequestProperty("Content-Type", "application/json");

      //String json = "{\"method\":\"setSelfTimer\",\"params\":[10],\"id\":1,\"version\":\"1.0\"}";
      //String json = "{\"method\":\"actTakePicture\",\"params\":[],\"id\":1,\"version\":\"1.0\"}";
      //String json = "{\"method\":\"setShootMode\",\"params\":[\"still\"],\"id\":1,\"version\":\"1.0\"}";
      //String json = "{\"method\":\"startContShooting\",\"params\":[],\"id\":1,\"version\":\"1.0\"}";

      try (OutputStream output = connection.getOutputStream()) {
        output.write(json.getBytes());
      }

    } else {

      url = "http://10.0.0.1:64321/scalarwebapi_dd.xml";
      connection = (HttpURLConnection) new URL(url)
        .openConnection();
    }

      try (
        BufferedReader reader = new BufferedReader(
          new InputStreamReader(connection.getInputStream())
        )
      ) {
        for (String line; (line = reader.readLine()) != null;) {
          body = body + line;
        }
      }

      System.out.println(body);
  }
}
