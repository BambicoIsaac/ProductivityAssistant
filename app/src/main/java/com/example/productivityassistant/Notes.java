package com.example.productivityassistant;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.RelativeLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Notes extends AppCompatActivity {
    private ListView obj;
    NotesDatabase mydb;
    FloatingActionButton btnadd;
    ListView mylist;
    Menu menu;
    AlertDialog.Builder alertDialogBuilder;
    AlertDialog alertDialog;
    Context context = this;
    RelativeLayout relativeLayout;
    SimpleCursorAdapter adapter;
    Snackbar snackbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notedisplay);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        mydb = new NotesDatabase(this);
        btnadd = (FloatingActionButton) findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", 0);
                Intent intent = new Intent(getApplicationContext(),
                        DisplayNotes.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
                finish();
            }
        });
        Cursor c = mydb.fetchAll();
        String[] fieldNames = new String[] { NotesDatabase.name, NotesDatabase._id, NotesDatabase.dates, NotesDatabase.remark };
        int[] display = new int[] { R.id.txtnamerow, R.id.txtidrow,
                R.id.txtdate,R.id.txtremark };
        adapter = new SimpleCursorAdapter(this, R.layout.listofnotestemplate, c, fieldNames,
                display, 0);
        mylist = (ListView) findViewById(R.id.listView1);
        mylist.setAdapter(adapter);
        mylist.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                LinearLayout linearLayoutParent = (LinearLayout) arg1;
                LinearLayout linearLayoutChild = (LinearLayout) linearLayoutParent
                        .getChildAt(0);
                TextView m = (TextView) linearLayoutChild.getChildAt(1);
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id",
                        Integer.parseInt(m.getText().toString()));
                Intent intent = new Intent(getApplicationContext(),
                        DisplayNotes.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenufornotes, menu);
        this.menu = menu;
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.add:
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", 0);
                Intent intent = new Intent(getApplicationContext(),
                        DisplayNotes.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}