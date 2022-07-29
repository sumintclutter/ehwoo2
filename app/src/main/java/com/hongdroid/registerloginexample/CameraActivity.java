package com.hongdroid.registerloginexample;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCamera;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 디자인 정의
        btnCamera = (Button) findViewById(R.id.btn_Photo);
        imageView = (ImageView) findViewById(R.id.imageView);
        btnCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)    {
        switch (view.getId()) {
            // 카메라촬영 클릭 이벤트
            case R.id.btn_Photo:
                // 카메라 기능을 Intent
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, 0);
                btnCamera.setText("인증 완료");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)    {
        super.onActivityResult(requestCode, resultCode, data);

        // 카메라 촬영을 하면 이미지뷰에 사진 삽입
        if(requestCode == 0 && resultCode == RESULT_OK) {
            // Bundle로 데이터를 입력
            Bundle extras = data.getExtras();

            // Bitmap으로 컨버전
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            // 이미지뷰에 Bitmap으로 이미지를 입력
            imageView.setImageBitmap(imageBitmap);
        }
    }
}