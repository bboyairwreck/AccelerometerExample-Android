package edu.washington.echee.accelerometerexample;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity implements SensorEventListener {
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

    @Override
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float xvalue = sensorEvent.values[0];
        float yvalue = sensorEvent.values[1];
        float zvalue = sensorEvent.values[2];

        TextView tvXAxis = (TextView) findViewById(R.id.tvXAxis);
        TextView tvYAxis = (TextView) findViewById(R.id.tvYAxis);
        TextView tvZAxis = (TextView) findViewById(R.id.tvZAxis);

        tvXAxis.setText(getString(R.string.x_axis, xvalue));
        tvYAxis.setText(getString(R.string.y_axis, yvalue));
        tvZAxis.setText(getString(R.string.z_axis, zvalue));



    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this,mAccelerometer, SensorManager.SENSOR_DELAY_UI);
        // For diff update intervals, use
        //      SENSOR_DELAY_NORMAL     200,000ms
        //      SENSOR_DELAY_UI          60,000ms
        //      SENSOR_DELAY_GAME        20,000ms
        //      SENSOR_DELAY_FASTEST          0ms
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
