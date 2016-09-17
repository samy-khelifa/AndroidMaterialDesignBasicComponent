package com.annie.smartherd.androidmaterialdesignbasiccomponent;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.annie.smartherd.androidmaterialdesignbasiccomponent.R;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout rootLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = (CoordinatorLayout)findViewById(R.id.myLayout);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(rootLayout, "Simple Snack Bar Example", Snackbar.LENGTH_LONG).show();

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Basic Components");
        toolbar.inflateMenu(R.menu.menu_main);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.simple_snackbar:
                        showSimpleSnackBar();
                        break;

                    case R.id.snackbar_action_callback:
                        showSnackBarWithActionCallBack();
                        break;

                    case R.id.custom_sackbar:
                        showSnackBarWithColoredText();
                        break;

                }

                return false;
            }
        });
    }

    public void showSimpleSnackBar() {

        Snackbar.make(rootLayout, "Simple Snack Bar Example", Snackbar.LENGTH_LONG).show();

    }

    public void showSnackBarWithActionCallBack() {

        Snackbar snackbar = Snackbar.make(rootLayout, "File Deleted Successfully", Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rootLayout, "File Recovered Successfully", Snackbar.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }

    public void showSnackBarWithColoredText() {

        Snackbar snackbar = Snackbar.make(rootLayout, "Error Deleting File", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Do something
                    }
                });

        View snackbarLayout = snackbar.getView();
        snackbarLayout.setBackgroundColor(Color.RED);

        // SnackBar Message Text color
        TextView textView = (TextView) snackbarLayout.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.DKGRAY);

        // OR Change Action Button Text Color
        //      Button btn = (Button) snackbarLayout.findViewById(android.support.design.R.id.snackbar_action);
        //	btn.setTextColor(Color.WHITE);

        // Changing Action Button Text Color
        snackbar.setActionTextColor(Color.WHITE);


        snackbar.show();
    }
}
