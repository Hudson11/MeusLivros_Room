package br.edu.ufrn.meuslivros_part1.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufrn.meuslivros_part1.Adapters.LivroAdapter;
import br.edu.ufrn.meuslivros_part1.BancoRoom.AppDatabase;
import br.edu.ufrn.meuslivros_part1.Interfaces.LivroDao;
import br.edu.ufrn.meuslivros_part1.R;
import br.edu.ufrn.meuslivros_part1.classes.Livro;

public class ListarActivity extends AppCompatActivity {

    private List<Livro> listaLivro = new ArrayList<>();
    private AppDatabase db;
    private LivroDao livroDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        //Init_Livro();
        db = AppDatabase.getDatabase(this);
        livroDao = db.livroDao();
        listaLivro = livroDao.listAll();

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);

        final LivroAdapter livroAdapter = new LivroAdapter(this, listaLivro);
        recyclerView.setAdapter(livroAdapter);

        //declarando um layout ao adapter
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    public void Init_Livro(){

        listaLivro.add(new Livro("Hudson","hudson", 1, 3.0, R.drawable.livro_icon_png_3));
        listaLivro.add(new Livro("taniro","taniro", 1, 3.0, R.drawable.livro_icon_png_3));
        listaLivro.add(new Livro("tuany","tuany", 1, 3.0, R.drawable.livro_icon_png_3));
        listaLivro.add(new Livro("joão","joão", 1, 3.0, R.drawable.livro_icon_png_3));
        listaLivro.add(new Livro("maria","maria", 1, 3.0, R.drawable.livro_icon_png_3));
        listaLivro.add(new Livro("lucas","lucas", 1, 3.0, R.drawable.livro_icon_png_3));
        listaLivro.add(new Livro("pedro","pedro", 1, 3.0, R.drawable.livro_icon_png_3));

        for(int i = 0; i < 1000; i++){
            listaLivro.add(new Livro("livro "+i,"livro "+i, 4, 4.0, R.drawable.livro_icon_png_3));
        }

    }

}
