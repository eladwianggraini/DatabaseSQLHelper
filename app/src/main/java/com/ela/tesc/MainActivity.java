package com.ela.tesc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText inputnama;
    private Button tambahdat, tampildat;
//    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputnama = (EditText) findViewById(R.id.nama);
        tambahdat = (Button) findViewById(R.id.tambahdata);
        tampildat = (Button) findViewById(R.id.tampill);
//
//        progressBar = (ProgressBar) findViewById(R.id.progressbar);


        final Database db = new Database(this);


        tambahdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = inputnama.getText().toString();
                db.tambahdata(nama);
                Toast.makeText(MainActivity.this, "tambah  data berhasil", Toast.LENGTH_SHORT).show();
                inputnama.setText("");
            }
        });

        tampildat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ListView listdata = (ListView) findViewById(R.id.listdata);
                List<String> datanama = db.tampildata();
                ArrayAdapter<String> listadapter = new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, datanama);

                listdata.setAdapter(listadapter);

            }
        });
//        progressBar.setMax(2);

    }
//    public void setValue(int progress) {
//        this.progressBar.setProgress(progress);
//    }
}

