package edu.washington.echee.accelerometerexample;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends Activity {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER) == null) {
            // There is no accelerometer
            Log.i(TAG, "There is no accelerometer :(");

        } else {
            // Found accelerometer
            Log.i(TAG, "There is an accelerometer!");
            mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);



        }
    }
}
