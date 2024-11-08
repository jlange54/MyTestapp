package de.bbs_technik_koblenz.jl.mytestapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class buttonScreen extends AppCompatActivity {

    private Button btn11;
    private Button btn12;
    private Button btn13;
    private Button btn21;
    private Button btn22;
    private Button btn23;
    private Button btn31;
    private Button btn32;
    private Button btn33;

    private TextView btnNameDisplay;
    private TextView btnNameDisplay_bottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_button_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn11 = findViewById(R.id.btn_11);
        btn12 = findViewById(R.id.btn_12);
        btn13 = findViewById(R.id.btn_13);
        btn21 = findViewById(R.id.btn_21);
        btn22 = findViewById(R.id.btn_22);
        btn23 = findViewById(R.id.btn_23);
        btn31 = findViewById(R.id.btn_31);
        btn32 = findViewById(R.id.btn_32);
        btn33 = findViewById(R.id.btn_33);

        Button[] btnList = {btn11, btn12, btn13, btn21, btn22, btn23, btn31, btn32, btn33};

        btnNameDisplay = findViewById(R.id.txt_btnNameDisplay);
        btnNameDisplay_bottom = findViewById(R.id.txt_btnNameDisplay_bottom);

//        watchMultipleBtns(btnList);

    }

//    public void watchMultipleBtns (Button[] btnlist){
//        for (Button button : btnlist) {
//            watchBtn(button);
//        }
//    }
//
//    public void watchBtn (Button btn) {
//        btn.setOnClickListener(view -> btnNameDisplay.setText(btn.getText() + " wurde geclickt"));
//    }
    public void updateText (Button btn) {
        btnNameDisplay_bottom.setText(btn.getText() + " wurde geclickt");
    }

    public void onButtonClick(View view) {
        updateText((Button) view);
    }
}