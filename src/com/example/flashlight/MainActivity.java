package com.example.flashlight;

import com.example.flashlight.R;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

public static Camera cam = null;// has to be static, otherwise onDestroy() destroys it

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    Button btnAan = (Button) findViewById(R.id.button1);
    btnAan.setOnClickListener(new OnClickListener() {
    	public void onClick(View view) {

    	    try {
    	        if (getPackageManager().hasSystemFeature(
    	                PackageManager.FEATURE_CAMERA_FLASH)) {
    	            cam = Camera.open();
    	            Parameters p = cam.getParameters();
    	            p.setFlashMode(Parameters.FLASH_MODE_TORCH);
    	            cam.setParameters(p);
    	            cam.startPreview();
    	        }
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	        Toast.makeText(getBaseContext(), "Exception flashLightOn()",
    	                Toast.LENGTH_SHORT).show();
    	    }
    	}
    });
    
    Button btnUit = (Button) findViewById(R.id.button2);
    btnUit.setOnClickListener(new OnClickListener() {
    	public void onClick(View view) {

    	    //try {
    	            cam.stopPreview();
    	            cam.release();
    	    //    }
    	    //} catch (Exception e) {
    	    //    e.printStackTrace();
    	    //    Toast.makeText(getBaseContext(), "Exception flashLightOn()",
    	    //            Toast.LENGTH_SHORT).show();
    	    //}
    	}
    });
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    //getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
}
}
