package com.example.cuocduakithu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtdiem;
    Button btnbatdau;
    CheckBox ckhong, ckvang, ckmeo;
    SeekBar seehong, seevang, seemeo;
    int diemso = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        seebardisbale();

        txtdiem.setText(diemso + " ");
        //set điều kiện kiểm tra checkbox chỉ cho nhập 1 check box
        ckhong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ckmeo.setChecked(false);
                    ckvang.setChecked(false);
                }
            }
        });
        ckvang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ckhong.setChecked(false);
                    ckmeo.setChecked(false);
                }


            }
        });
        ckmeo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ckhong.setChecked(false);
                    ckvang.setChecked(false);
                }
            }
        });

        final CountDownTimer countDownTimer = new CountDownTimer(30000, 100) {

            @Override
            public void onTick(long l) {
                Random random = new Random();
                int one = random.nextInt(3);
                int two = random.nextInt(3);
                int three = random.nextInt(3);
                //kiểm tra điều kiện về nhất
                if (seehong.getProgress() >= seehong.getMax()) {
                    //điều kiện dừng lại của coudowtimer
                    this.cancel();
                    //bật lại nút bắt đầu
                    btnbatdau.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "pokemon hồng về nhất ", Toast.LENGTH_SHORT).show();
                    if (ckhong.isChecked() == true) {
                        diemso += 10;
                        txtdiem.setText(diemso + " ");
                    } else {
                        diemso -= 10;
                        txtdiem.setText(diemso + " ");
                    }
                    ckenable();


                }
                if (seevang.getProgress() >= seevang.getMax()) {

                    this.cancel();
                    btnbatdau.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Pikachu về nhất ", Toast.LENGTH_SHORT).show();
                    if (ckvang.isChecked() == true) {
                        diemso += 10;
                        txtdiem.setText(diemso + " ");
                    } else {
                        diemso -= 10;
                        txtdiem.setText(diemso + " ");
                    }
                    ckenable();

                }
                if (seemeo.getProgress() >= seemeo.getMax()) {
                    this.cancel();
                    btnbatdau.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Mèo  về nhất ", Toast.LENGTH_SHORT).show();
                    if (ckmeo.isChecked() == true) {
                        diemso += 10;
                        txtdiem.setText(diemso + " ");
                    } else {
                        diemso -= 10;
                        txtdiem.setText(diemso + " ");
                    }
                    ckenable();

                }

                seehong.setProgress(seehong.getProgress() + one);
                seevang.setProgress(seevang.getProgress() + two);
                seemeo.setProgress(seemeo.getProgress() + three);


            }

            @Override
            public void onFinish() {

            }
        };
        btnbatdau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //kiểm tra điều kiện nếu check box chọn mới cho bắt đầu
                if (ckhong.isChecked() == true || ckmeo.isChecked() == true || ckvang.isChecked() == true) {
                    seehong.setProgress(0);
                    seemeo.setProgress(0);
                    seevang.setProgress(0);

                    countDownTimer.start();
                    btnbatdau.setVisibility(View.INVISIBLE);
                    //an di text box ko cho nguoi dung lua chon
                    ckdisable();
                } else
                    Toast.makeText(MainActivity.this, "bạn vui lòng chọn đặt cược", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void anhxa() {
        txtdiem = (TextView) findViewById(R.id.txtdiemso);
        btnbatdau = (Button) findViewById(R.id.btnbatdau);
        ckhong = (CheckBox) findViewById(R.id.cb1);
        ckvang = (CheckBox) findViewById(R.id.cb2);
        ckmeo = (CheckBox) findViewById(R.id.cb3);
        seehong = (SeekBar) findViewById(R.id.sb1);
        seevang = (SeekBar) findViewById(R.id.sb2);
        seemeo = (SeekBar) findViewById(R.id.sb3);
    }

    // ham hien thi check box
    public void ckenable() {
        ckhong.setEnabled(true);
        ckvang.setEnabled(true);
        ckmeo.setEnabled(true);
    }

    //ham an di
    public void ckdisable() {
        ckhong.setEnabled(false);
        ckvang.setEnabled(false);
        ckmeo.setEnabled(false);
    }

    //ham an di seebar
    public void seebardisbale() {
        seemeo.setEnabled(false);
        seevang.setEnabled(false);
        seehong.setEnabled(false);
    }
}