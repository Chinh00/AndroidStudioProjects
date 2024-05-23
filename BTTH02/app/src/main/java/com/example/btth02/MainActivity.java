package com.example.btth02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Optional;


public class MainActivity extends AppCompatActivity {
    private EditText editFa, editCe;
    private Button btnToCe, btnFa, btnClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        try {
            editFa = (EditText) findViewById(R.id.editFahrenheit);
            editCe = (EditText) findViewById(R.id.editCelsius);
            btnToCe = (Button) findViewById(R.id.btnToCe);
            btnFa = (Button) findViewById(R.id.btnToFa);
            btnClear = (Button) findViewById(R.id.btnClear);
        } catch (Exception e) {

        }





    }

    void Clear() {
        editCe.setText("");
        editFa.setText("");
    }

    float ConvertToC(float doF) {
        return (float) (doF - 32) * 5 / 9;
    }

    private void ConvertData( float doC0, float doF, boolean isClear) {
        if (isClear) Clear();
        if (doC0 == -1) {
            float c = this.ConvertToC(doF);
            editCe.setText(String.valueOf(c));
        }

    }


}