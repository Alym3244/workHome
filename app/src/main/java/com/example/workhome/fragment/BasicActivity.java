package com.example.workhome.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.workhome.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class BasicActivity extends AppCompatActivity {
    private ImageView imageView;
    private final int Pick_image = 1;
    Button btndals;
    Button BtnAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        btndals = (Button)findViewById(R.id.btn_Hats);
        BtnAnimation = (Button)findViewById(R.id.btn_animation);
        BtnAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicActivity.this,IntelbohAmdLohActivity.class);
                startActivity(intent);
            }
        });
        btndals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BasicActivity.this,TiarActivity.class);
                startActivity(intent);
            }
        });

        imageView = (ImageView) findViewById(R.id.imageView);



        Button PickImage = (Button) findViewById(R.id.button);

        PickImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);

                photoPickerIntent.setType("image/*");

                startActivityForResult(photoPickerIntent, Pick_image);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case Pick_image:
                if (resultCode == RESULT_OK) {
                    try {


                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        imageView.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}