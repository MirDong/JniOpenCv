package com.example.v_zakudong.jniopencv;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView mIv;
    Button btnNdk,btnRtn;
    static {
        System.loadLibrary("ImgFun");
    }
    public static native int[] ImgFun(int[] buf,int w,int h);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*TextView mtv=(TextView)findViewById(R.id.tv1);
        mtv.setText("你好！");*/
        mIv=(ImageView)findViewById(R.id.image);
        btnNdk=(Button)findViewById(R.id.button1);
        btnRtn=(Button)findViewById(R.id.button2);
        btnRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap img = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_launcher)).getBitmap();
                mIv.setImageBitmap(img);
            }
        });
        btnNdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long current = System.currentTimeMillis();
                Bitmap img1 = ((BitmapDrawable) getResources().getDrawable(
                        R.drawable.ic_launcher)).getBitmap();
                int w = img1.getWidth(), h = img1.getHeight();
                int[] pix = new int[w * h];
                img1.getPixels(pix, 0, w, 0, 0, w, h);
                int[] resultInt = ImgFun(pix, w, h);
                Bitmap resultImg = Bitmap.createBitmap(w, h, Bitmap.Config.RGB_565);
                resultImg.setPixels(resultInt, 0, w, 0, 0, w, h);
                long performance = System.currentTimeMillis() - current;
                mIv.setImageBitmap(resultImg);
            }
        });
    }

}
