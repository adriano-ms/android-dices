package com.edu.fateczl.dices;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adriano M Sanchez
 */
public class MainActivity extends AppCompatActivity {

    private TextView txtName;
    private TextView txtRa;

    private Spinner spD1;
    private Spinner spD2;
    private Spinner spD3;

    private TextView txtResult;

    private Button btRoll;

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

        txtName = findViewById(R.id.txtName);
        txtRa = findViewById(R.id.txtRa);

        spD1 = findViewById(R.id.spD1);
        spD2 = findViewById(R.id.spD2);
        spD3 = findViewById(R.id.spD3);

        txtResult = findViewById(R.id.txtResult);

        btRoll = findViewById(R.id.btRoll);
        btRoll.setOnClickListener(e -> rollDices());

        initializeSpinners();
    }

    private void rollDices(){
        StringBuilder sb = new StringBuilder();
        if(!spD1.getSelectedItem().equals(getString(R.string.sp_none_option)))
            sb.append(((Dice) spD1.getSelectedItem()).toString()).append(": ").append(((Dice) spD1.getSelectedItem()).roll()).append("\n");
        if(!spD2.getSelectedItem().equals(getString(R.string.sp_none_option)))
            sb.append(((Dice) spD2.getSelectedItem()).toString()).append(": ").append(((Dice) spD2.getSelectedItem()).roll()).append("\n");
        if(!spD3.getSelectedItem().equals(getString(R.string.sp_none_option)))
            sb.append(((Dice) spD3.getSelectedItem()).toString()).append(": ").append(((Dice) spD3.getSelectedItem()).roll());

        txtResult.setText(sb.toString());
    }

    private void initializeSpinners(){
        List<Object> list = new ArrayList<>();
        list.add(getString(R.string.sp_none_option));
        list.add(new Dice(4));
        list.add(new Dice(6));
        list.add(new Dice(8));
        list.add(new Dice(10));
        list.add(new Dice(12));
        list.add(new Dice(20));
        list.add(new Dice(100));

        ArrayAdapter<Object> a = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spD1.setAdapter(a);
        spD2.setAdapter(a);
        spD3.setAdapter(a);
    }
}