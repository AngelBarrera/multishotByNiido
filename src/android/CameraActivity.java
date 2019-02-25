/*
 * Copyright 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.cordova.multishot;

import android.app.Activity;
import android.os.Bundle;

//import com.ionicframework.niido232869.R;


public class CameraActivity extends Activity {


//    private static final int RUNTIME_REQUEST_PERMISSION = 1;
//
//    public static final String permissionCamera = Manifest.permission.CAMERA;
//    public static final String permissionVibrate = Manifest.permission.VIBRATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //(original code ->) setContentView(R.layout.activity_camera);
        setContentView(this.getResources().getIdentifier("activity_camera", "layout", this.getPackageName()));

        launch();

//        requestForCameraPermission();
    }



   /* public void requestForCameraPermission() {


        String[] permission = { permissionCamera , permissionVibrate };

        if (ContextCompat.checkSelfPermission(CameraActivity.this, permissionCamera)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(CameraActivity.this, permissionVibrate)
                != PackageManager.PERMISSION_GRANTED) {
//            requestForPermission(permission);

            ActivityCompat.requestPermissions(CameraActivity.this, permission , RUNTIME_REQUEST_PERMISSION);

//            if (ActivityCompat.shouldShowRequestPermissionRationale(CameraActivity.this, permission)) {
////                showPermissionRationaleDialog("Test", permission);
//                ActivityCompat.requestPermissions(CameraActivity.this, permission , RUNTIME_REQUEST_PERMISSION);
//            } else {
//                ActivityCompat.requestPermissions(CameraActivity.this, permission , RUNTIME_REQUEST_PERMISSION);
//            }
        } else {
            launch();
        }
    }*/
/*
    private void showPermissionRationaleDialog(final String message, final String permission) {
        new AlertDialog.Builder(CameraActivity.this)
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        CameraActivity.this.requestForPermission(permission);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }*/


    private void launch() {

        if (getIntent()!=null && getIntent().getExtras()!=null) {
            getFragmentManager().beginTransaction()
                    //(original code -> ) .replace(R.id.container, CameraFragment.newInstance(getIntent().getExtras()))
                    .replace(this.getResources().getIdentifier("container", "id", this.getPackageName()), CameraFragment.newInstance(getIntent().getExtras()))
//                    .replace(R.id.container, Camera2BasicFragment.newInstance(getIntent().getExtras()))
//                        .replace(R.id.container, Camera2BasicFragmentNew.newInstance(getIntent().getExtras()))
                    .commit();
        }

//        Intent startCustomCameraIntent = new Intent(this, org.apache.cordova.mutishot.square.CameraActivity.class);
//        startActivityForResult(startCustomCameraIntent, REQUEST_CAMERA);
//        finish();
    }

 /*   @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case RUNTIME_REQUEST_PERMISSION:
                final int numOfRequest = grantResults.length;

                boolean cameraAccepted = grantResults[0]==PackageManager.PERMISSION_GRANTED;
                boolean vibratAccepted = grantResults[1]==PackageManager.PERMISSION_GRANTED;

              *//*  final boolean isGranted = numOfRequest == 1
                        && PackageManager.PERMISSION_GRANTED == grantResults[numOfRequest - 1];
                if (isGranted) {
                    launch();
                }*//*

                if (cameraAccepted)
                {
                    launch();
                }

                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }*/

}