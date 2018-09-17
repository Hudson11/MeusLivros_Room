package br.edu.ufrn.meuslivros_part1.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

import br.edu.ufrn.meuslivros_part1.BancoRoom.AppDatabase;
import br.edu.ufrn.meuslivros_part1.Interfaces.LivroDao;
import br.edu.ufrn.meuslivros_part1.R;
import br.edu.ufrn.meuslivros_part1.classes.Livro;

public class CadastraActivity extends AppCompatActivity {

    EditText autor;
    EditText titulo;
    EditText ano;
    RatingBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra);

        autor = findViewById(R.id.autor);
        titulo = findViewById(R.id.titulo);
        ano = findViewById(R.id.ano);
        bar = findViewById(R.id.ratingBar);
    }

    public void save(View v){
        int x = Integer.parseInt(ano.getText().toString());
        float y = bar.getRating();

        Intent t = new Intent();
        t.putExtra("autor", autor.getText().toString());
        t.putExtra("titulo", titulo.getText().toString());
        t.putExtra("ano", x);
        t.putExtra("nota", y);

        setResult(RESULT_OK, t);
        finish();
    }

    public void cancell(View v){
        setResult(RESULT_CANCELED);
        finish();
    }
}
