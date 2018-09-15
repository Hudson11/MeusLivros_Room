package br.edu.ufrn.meuslivros_part1.Activities;

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

    AppDatabase db;
    LivroDao livroDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra);

        autor = findViewById(R.id.autor);
        titulo = findViewById(R.id.titulo);
        ano = findViewById(R.id.ano);
        bar = findViewById(R.id.ratingBar);

        db = AppDatabase.getDatabase(this);
        livroDao = db.livroDao();

    }

    public void save(View v){
        int x = Integer.parseInt(ano.getText().toString());
        float y = bar.getRating();

        Livro livro = new Livro(autor.getText().toString(), titulo.getText().toString(), x, y);
        livroDao.inserir(livro);
        Log.i("SALVOU", "Dado: " + y);

        finish();

        Snackbar snackbar = Snackbar.make((View) v.getParent(), "Livro Cadastrado com Sucesso", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    public void cancell(View v){
        finish();

        Snackbar snackbar = Snackbar.make((View) v.getParent(), "Cancelou", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }
}
