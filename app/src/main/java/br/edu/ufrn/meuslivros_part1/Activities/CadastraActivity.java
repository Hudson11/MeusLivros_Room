package br.edu.ufrn.meuslivros_part1.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import br.edu.ufrn.meuslivros_part1.BancoSqLite.BancoHelper;
import br.edu.ufrn.meuslivros_part1.R;
import br.edu.ufrn.meuslivros_part1.classes.Livro;

public class CadastraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra);

        final BancoHelper bh = new BancoHelper(this);
        final EditText autor = findViewById(R.id.autor);
        final EditText titulo = findViewById(R.id.titulo);
        final EditText ano = findViewById(R.id.ano);
        final RatingBar bar = findViewById(R.id.ratingBar);

        Button cadastrar = findViewById(R.id.salvar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(ano.getText().toString());
                float y = bar.getRating();

                Log.i("SALVOU", "Dado: " + y);

                Livro v = new Livro(autor.getText().toString(), titulo.getText().toString(), x, y);
                bh.save(v);
            }
        });


    }

    public void click(View v){
        finish();
    }

}
