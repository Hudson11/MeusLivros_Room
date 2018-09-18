package br.edu.ufrn.meuslivros_part1.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufrn.meuslivros_part1.BancoRoom.AppDatabase;
import br.edu.ufrn.meuslivros_part1.Interfaces.LivroDao;
import br.edu.ufrn.meuslivros_part1.R;
import br.edu.ufrn.meuslivros_part1.classes.Livro;

public class BuscarActivity extends AppCompatActivity {

    TextView autor_busca, titulo_busca, ano_busca, nota_busca;
    AutoCompleteTextView complete;

    private AppDatabase db;
    private LivroDao livroDao;
    private List<Livro> livros;
    private String[] LIVRO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        autor_busca = findViewById(R.id.autor_busca);
        titulo_busca = findViewById(R.id.titulo_busca);
        ano_busca = findViewById(R.id.ano_busca);
        nota_busca = findViewById(R.id.nota_busca);

        db = AppDatabase.getDatabase(this);
        livroDao = db.livroDao();

        livros = new ArrayList<>();
        livros = livroDao.listAll();

        LIVRO = new String[livros.size()];

        int i = 0;
        for(Livro f: livros){
            LIVRO[i] = f.getTitulo();
            i++;
        }

        //Criando Adapter para o AutoCompleteTextView
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LIVRO);
        complete = findViewById(R.id.autoCompleteTextView);
        complete.setAdapter(adaptador);

    }

}
