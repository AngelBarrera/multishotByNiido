package org.apache.cordova.multishot;

import android.app.Activity;
import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by mind on 6/6/16.
 */
public class CameraPlugin extends CordovaPlugin {


    private static CallbackContext callbackContextMain;

    public static CallbackContext getCallBack()
    {
        return callbackContextMain;
    }


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        Activity activity = cordova.getActivity();

        callbackContextMain = callbackContext;

        if (args==null){
          callbackContext.error("No arguments");
          return true;
        }
        else if(args.length()!=3){
          System.out.println("Args: "+args.length());
          callbackContext.error("Num of arguments != 3");
          return true;
        }
        else if ("camera".equalsIgnoreCase(action)){
            System.out.println("START MULTI SHOT  action"+action+" \nrawArgs="+args+"\n count->"+args.getString(1)+" second->"+args.getString(2)+" cameratype->"+args.getString(0));


            String cameraType = args.getString(0);
            int count = Validation.getIntFromString(args.getString(1));
            int seconds = Validation.getIntFromString(args.getString(2));

            if (seconds != 0 && seconds>=count) {
                Intent intent = new Intent(activity, CameraActivity.class);
//                Intent intent = new Intent(activity, CameraActivityNew.class);

                intent.putExtra("COUNT", count);
                intent.putExtra("SECOND", seconds);
                intent.putExtra("cameratype", cameraType);
                activity.startActivity(intent);

                return true;
            }
            else {
                callbackContext.error("Number of seconsd can't be = 0 and must be >= to num of photos");
                return true;
            }

        }
        else {
            callbackContext.error("Error, '"+action+"' isn not a valid action");
        }


        return super.execute(action, args, callbackContext);
    }

}