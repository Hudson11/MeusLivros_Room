package br.edu.ufrn.meuslivros_part1.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufrn.meuslivros_part1.BancoSqLite.BancoHelper;
import br.edu.ufrn.meuslivros_part1.R;
import br.edu.ufrn.meuslivros_part1.classes.Livro;

public class VisualizaActivity extends AppCompatActivity {

    private int cont = 0;

    TextView autor_livro;
    TextView titulo_livro;
    TextView ano_livro;
    TextView nota_livro;
    BancoHelper db;
    List<Livro> livros;
    Livro v = new Livro();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        autor_livro = findViewById(R.id.autor_livro);
        titulo_livro = findViewById(R.id.titulo_livro);
        ano_livro = findViewById(R.id.ano_livro);
        nota_livro = findViewById(R.id.nota_livro);

        db = new BancoHelper(this);

        Button proximo = findViewById(R.id.proximo);
        Button anterior = findViewById(R.id.anterior);

        livros = db.findAll();
        v = livros.get(0);

        autor_livro.setText(v.getAutor());
        titulo_livro.setText(v.getTitulo());
        ano_livro.setText(v.getAno());
        nota_livro.setText((int) v.getNota());

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cont++;

                if(livros.get(cont) == null)
                    return;

                v = livros.get(cont);

                autor_livro.setText(v.getAutor());
                titulo_livro.setText(v.getTitulo());
                ano_livro.setText(v.getAno());
                nota_livro.setText((int) v.getNota());

            }
        });

        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cont++;

                if(livros.get(cont) == null || cont == 0)
                    return;

                v = livros.get(cont);

                autor_livro.setText(v.getAutor());
                titulo_livro.setText(v.getTitulo());
                ano_livro.setText(v.getAno());
                nota_livro.setText((int) v.getNota());

            }
        });

    }
}
