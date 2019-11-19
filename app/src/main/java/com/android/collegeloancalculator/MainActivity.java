package com.android.collegeloancalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar simpleSeekBar;
    private Button calcBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleSeekBar = findViewById(R.id.get_percent);

        calcBtn = findViewById(R.id.calculate);
        calcButton();
        // perform seek bar change listener event used for getting the progress value
        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Tip is: " + progressChangedValue + "%",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void calcButton() {
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get values of Tip and Bill Total
                TextView text = findViewById(R.id.get_total);
                String total = text.getText().toString();
                String tip = String.valueOf(simpleSeekBar.getProgress());
                //Call Calc function
                calculateTotal(tip, total);
            }
        });
    }
    private double calculateTotal(String tip, String total){
        double mTip = Double.parseDouble(tip);
        double mTotal = Double.parseDouble(total);
        double result;

        mTip = mTip/100;
        result = mTotal*mTip;
        mTotal = (mTotal + result);
        //Call Toast displaying result!
        Toast.makeText(MainActivity.this, "The Tip is: $" + String.format("%.2f", result) +
                        "\nThe Total bill is: $" + String.format("%.2f", mTotal), Toast.LENGTH_LONG).show();
        return 0;
    }

}
