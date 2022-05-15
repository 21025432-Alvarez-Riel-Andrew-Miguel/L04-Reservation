package sg.edu.rp.c346.id21025432.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputName,inputNumber,inputSize;
    DatePicker d;
    TimePicker t;
    CheckBox check;
    Button confirm, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputName = findViewById(R.id.inputName);
        inputNumber = findViewById(R.id.inputNumber);
        inputSize = findViewById(R.id.inputSize);
        d = findViewById(R.id.datePicker);
        t = findViewById(R.id.timePicker);
        check = findViewById(R.id.checkBox);
        confirm = findViewById(R.id.confirm_button);
        clear = findViewById(R.id.clear_button);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputName.getText().toString().matches("")){
                    Toast missingName = Toast.makeText(getApplicationContext(),"Name field is mandatory!",Toast.LENGTH_LONG);
                    missingName.show();
                    return;
                }
                if (inputNumber.getText().toString().matches("")){
                    Toast missingNumber = Toast.makeText(getApplicationContext(),"Phone Number field is mandatory!",Toast.LENGTH_LONG);
                    missingNumber.show();
                    return;
                }
                if (inputSize.getText().toString().matches("")) {
                    inputSize.setText("0");
                }

                String name = inputName.getText().toString();
                String number = inputNumber.getText().toString();
                String size = inputSize.getText().toString();
                String date = d.getDayOfMonth() + "/" + (d.getMonth()+1) + "/" + d.getYear();
                String time = t.getCurrentHour() + ":" + t.getCurrentMinute();
                boolean checked = check.isChecked();
                String msg = String.format("Name: %s\n\nPhone Number: %s\n\nNumber of people accompanying: %s\n\nDate: %s\n\nTime: %s\n\nSmoking area: %b",name,number,size,date,time,checked);
                Toast reservationInfo = Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG);
                reservationInfo.show();

            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputName.setText("");
                inputNumber.setText("");
                inputSize.setText("");
                d.updateDate(2020,6,1);
                t.setCurrentHour(19);
                t.setCurrentMinute(30);
                check.setChecked(false);

            }
        });


    }
}