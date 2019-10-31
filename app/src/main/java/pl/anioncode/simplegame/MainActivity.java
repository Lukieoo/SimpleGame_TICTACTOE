package pl.anioncode.simplegame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonRst;
    TextView[] pole = new TextView[9];
    TextView pole_0;
    static String XO = "X";
    static int COLOR = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pole_0 = findViewById(R.id.p0);
        pole_0.setTextColor(Color.rgb(0, 0, COLOR));
        pole[0] = findViewById(R.id.p1);
        pole[1] = findViewById(R.id.p2);
        pole[2] = findViewById(R.id.p3);
        pole[3] = findViewById(R.id.p4);
        pole[4] = findViewById(R.id.p5);
        pole[5] = findViewById(R.id.p6);
        pole[6] = findViewById(R.id.p7);
        pole[7] = findViewById(R.id.p8);
        pole[8] = findViewById(R.id.p9);

        buttonRst = findViewById(R.id.Reset);
        buttonRst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 9; i++) {
                    pole[i].setText(".");
                    pole[i].setEnabled(true);
                    XO = "X";
                    pole_0.setText(XO);
                    pole[i].setTextColor(Color.rgb(0, 0, 0));
                    pole_0.setTextColor(Color.rgb(0, 0, 200));
                }
            }
        });

        for (int i = 0; i < 9; i++) {
            final int finalI = i;
            pole[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pole[finalI].setEnabled(false);
                    pole[finalI].setText(XO);
                    COLOR = ("X" == XO) ? 200 : 0;
                    XO = ("X" == XO) ? "O" : "X";
                    pole_0.setText(XO);
                    pole[finalI].setTextColor(Color.rgb(0, 0, COLOR));
                    if(COLOR==200) pole_0.setTextColor(Color.rgb(0, 0, 0));
                    if(COLOR==0) pole_0.setTextColor(Color.rgb(0, 0, 200));
                }
            });
        }

    }
}
