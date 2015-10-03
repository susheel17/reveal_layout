package com.example.susheel.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RevealLayout mRevealLayout;
    private boolean mIsAnimationSlowDown = false;
    private boolean mIsBaseOnTouchLocation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRevealLayout = (RevealLayout) findViewById(R.id.reveal_layout);

        initRevealLayout();


    }

    private void initRevealLayout() {

        if (mIsBaseOnTouchLocation) {
            mRevealLayout.setOnClickListener(null);
            mRevealLayout.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                        Log.d("SingleChildActivity", "x: " + event.getX() + ", y: " + event.getY());
                        if (mRevealLayout.isContentShown()) {
                            if (mIsAnimationSlowDown) {
                                mRevealLayout.hide((int) event.getX(), (int) event.getY(), 2000);
                            } else {
                                mRevealLayout.hide((int) event.getX(), (int) event.getY());
                            }
                        } else {
                            if (mIsAnimationSlowDown) {
                                mRevealLayout.show((int) event.getX(), (int) event.getY(), 2000);
                            } else {
                                mRevealLayout.show((int) event.getX(), (int) event.getY());
                            }
                        }
                        return true;
                    }
                    return false;
                }
            });
        } else {
            mRevealLayout.setOnTouchListener(null);
            mRevealLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mRevealLayout.isContentShown()) {
                        if (mIsAnimationSlowDown) {
                            mRevealLayout.hide(2000);
                        } else {
                            mRevealLayout.hide();
                        }
                    } else {
                        if (mIsAnimationSlowDown) {
                            mRevealLayout.show(2000);
                        } else {
                            mRevealLayout.show();
                        }
                    }
                }
            });

        }

    }


}
