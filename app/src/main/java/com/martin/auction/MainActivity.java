package com.martin.auction;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button loadButton;
    private ImageView image;
    private EditText edtTxtPrice;
    private EditText edtTxtDesc;
    private static final int REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        image = (ImageView) findViewById(R.id.imageView);
        loadButton = (Button) findViewById(R.id.button);
        edtTxtPrice = (EditText) findViewById(R.id.editTextPrice);
        edtTxtDesc = (EditText) findViewById(R.id.editTextDescription);

        loadButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //  getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType("image/*");
        startActivityForResult(i, REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap img = null;

        if (requestCode == REQUEST && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            try {
                img = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            image.setImageBitmap(img);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /* public void onClickEdtBox(View v) {
        if (edtTxtPrice.getText().toString().equals("Ціна")) {
            edtTxtPrice.setText("");
            edtTxtPrice.setTextColor(Color.BLACK);
        }
    }
    public void onClickEdtDesc(View v) {
        if (edtTxtDesc.getText().toString().equals("Введіть опис товару")) {
            edtTxtDesc.setText("");
            edtTxtDesc.setTextColor(Color.BLACK);
        }
    } */
}