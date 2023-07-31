package com.example.bmicalculators003;

import androidx.appcompat.app.AppCompatActivity;

/*import android.icu.util.BuddhistCalendar;*/
import android.os.Bundle;
/*import android.icu.util.Output;*/

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btKeisan = findViewById(R.id.btKeisan);
        Button btClear = findViewById(R.id.btClear);

        btKeisan.setOnClickListener(new KeiButtonClickListener());
        btClear.setOnClickListener(new ClearButtonClickListener());
    }
    private class KeiButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            EditText height = findViewById(R.id.etHeight);
            EditText weight = findViewById(R.id.etWeight);
            TextView output = findViewById(R.id.tvOutput);
            EditText age = findViewById(R.id.etAge);

            String Height = height.getText().toString();
            String Weight = weight.getText().toString();
            String Age = age.getText().toString();
            int iAge = Integer.parseInt(Age);
            if (iAge < 16) {

                Dialog dialog = new Dialog();
                dialog.show(getSupportFragmentManager(), "Dialog");
            } else {

                float fWeight = Float.parseFloat(Weight);
                float fHeight = Float.parseFloat(Height);
                float mHeight = fHeight / 100;
                float BMI = fWeight / (mHeight * mHeight);
                String Appropriate = String.format("%.1f", mHeight * mHeight * 22);

                String obesity;
                if (BMI < 18.5) {
                    obesity = "低体重";
                    output.setText("あなたの肥満度は\n" + obesity + "\nあなたの標準体重は\n" + Appropriate + "kg");
                } else if (BMI < 25) {
                    obesity = "普通体重";
                    output.setText("あなたの肥満度は\n" + obesity + "\nあなたの標準体重は\n" + Appropriate + "kg");
                } else if (BMI < 30) {
                    obesity = "肥満（1度）";
                    output.setText("あなたの肥満度は\n" + obesity + "\nあなたの標準体重は\n" + Appropriate + "kg");
                } else if (BMI < 35) {
                    obesity = "肥満（2度）";
                    output.setText("あなたの肥満度は\n" + obesity + "\nあなたの標準体重は\n" + Appropriate + "kg");
                } else if (BMI < 40) {
                    obesity = "肥満（3度）";
                    output.setText("あなたの肥満度は\n" + obesity + "\nあなたの標準体重は\n" + Appropriate + "kg");
                } else if (BMI >= 40) {
                    obesity = "肥満（4度）";
                    output.setText("あなたの肥満度は\n" + obesity + "\nあなたの標準体重は\n" + Appropriate + "kg");
                }
            }
        }
    }

    private class ClearButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            EditText sin = findViewById(R.id.etHeight);
            EditText tai = findViewById(R.id.etWeight);
            EditText age = findViewById(R.id.etAge);
            TextView output = findViewById(R.id.tvOutput);


            sin.setText("");
            tai.setText("");
            age.setText("");
            output.setText("");
        }
    }

}