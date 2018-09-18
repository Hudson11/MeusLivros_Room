package br.edu.ufrn.meuslivros_part1.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufrn.meuslivros_part1.BancoRoom.AppDatabase;
import br.edu.ufrn.meuslivros_part1.Interfaces.LivroDao;
import br.edu.ufrn.meuslivros_part1.R;
import br.edu.ufrn.meuslivros_part1.classes.Livro;

public class VisualizaActivity extends AppCompatActivity {

    private int cont = 0;
    private int index;

    TextView autor_livro;
    TextView titulo_livro;
    TextView ano_livro;
    TextView nota_livro;

    private List<Livro> livros = new ArrayList<>();
    private Livro v = new Livro();

    AppDatabase db;
    LivroDao livroDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        autor_livro = findViewById(R.id.autor_livro);
        titulo_livro = findViewById(R.id.titulo_livro);
        ano_livro = findViewById(R.id.ano_livro);
        nota_livro = findViewById(R.id.nota_livro);

        db = AppDatabase.getDatabase(this);
        livroDao = db.livroDao();

        livros = livroDao.listAll();
        index = livros.size();
        v = livros.get(0);

        setTextView(v);

    }

    public void proximo_rg(View view){
        cont++;

        if(cont == index) {
            cont = index - 1;
            return;
        }

        v = livros.get(cont);

        setTextView(v);
    }

    public void anterior_rg(View view){
        cont--;

        if(cont == -1){
            cont = 0;
            return;
        }

        v = livros.get(cont);
        setTextView(v);
    }


    public void setTextView(Livro v){
        autor_livro.setText(v.getAutor().toString());
        titulo_livro.setText(v.getTitulo().toString());
        ano_livro.setText(String.valueOf(v.getAno()).toString());
        nota_livro.setText(String.valueOf(v.getNota()).toString());
    }

}
