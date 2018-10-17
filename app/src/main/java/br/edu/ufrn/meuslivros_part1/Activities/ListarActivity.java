package br.edu.ufrn.meuslivros_part1.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufrn.meuslivros_part1.Adapters.LivroAdapter;
import br.edu.ufrn.meuslivros_part1.BancoRoom.AppDatabase;
import br.edu.ufrn.meuslivros_part1.Interfaces.LivroDao;
import br.edu.ufrn.meuslivros_part1.R;
import br.edu.ufrn.meuslivros_part1.RecyclerViewTouchListener.RecyclerViewTouchListener;
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
        RecyclerView.LayoutManager layout = new GridLayoutManager(this,  2);
        // set layout no recyclerView
        recyclerView.setLayoutManager(layout);

        //criando o uso dos gestos do recycler view
        recyclerView.addOnItemTouchListener(
                new RecyclerViewTouchListener(this, recyclerView, new RecyclerViewTouchListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(ListarActivity.this, "Clique curto", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                        Toast.makeText(ListarActivity.this, "Clique longo", Toast.LENGTH_LONG).show();
                    }
                })
        );

        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
