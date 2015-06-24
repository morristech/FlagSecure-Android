package flagsecure.dt.com.flagsecureexample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        clear flags: It can be used when user need to enable screen capturing in some applications
         */
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
    }


    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}
