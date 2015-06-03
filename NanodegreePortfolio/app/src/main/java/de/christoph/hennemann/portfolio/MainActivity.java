package de.christoph.hennemann.portfolio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();
        setupButtons();
    }

    private void setupButtons() {

        Button[] projectButtons = new Button[6];

        projectButtons[0] = (Button) findViewById(R.id.btn_project_one);
        projectButtons[1] = (Button) findViewById(R.id.btn_project_two);
        projectButtons[2] = (Button) findViewById(R.id.btn_project_three);
        projectButtons[3] = (Button) findViewById(R.id.btn_project_four);
        projectButtons[4] = (Button) findViewById(R.id.btn_project_five);
        projectButtons[5] = (Button) findViewById(R.id.btn_project_six);

        for(Button button : projectButtons) {
            button.setOnClickListener(this);
        }
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setSubtitle(R.string.app_subtitle);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_about:
                String url = "http://www.christoph-hennemann.de";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String toastText = "This button will launch my ";

        switch (id) {
            case R.id.btn_project_one:
                toastText += "Spotify Streamer App.";
                break;
            case R.id.btn_project_two:
                toastText += "Scores App.";
                break;
            case R.id.btn_project_three:
                toastText += "Library App.";
                break;
            case R.id.btn_project_four:
                toastText += "Build It Bigger App.";
                break;
            case R.id.btn_project_five:
                toastText += "Bacon Reader App.";
                break;
            case R.id.btn_project_six:
                toastText += "Capstone App.";
                break;
        }

        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
    }
}
