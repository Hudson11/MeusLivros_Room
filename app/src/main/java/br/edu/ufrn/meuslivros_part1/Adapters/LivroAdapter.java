package br.edu.ufrn.meuslivros_part1.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.edu.ufrn.meuslivros_part1.R;
import br.edu.ufrn.meuslivros_part1.classes.Livro;

public class LivroAdapter extends RecyclerView.Adapter{

    Context context;
    List<Livro> listaLivros;

    public LivroAdapter(Context context, List<Livro> listaLivros){
        this.context = context;
        this.listaLivros = listaLivros;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.activity_listar_holder, parent, false);

        LivroViewHolder lv = new LivroViewHolder(view);
        return lv;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position){

        LivroViewHolder livroholder = (LivroViewHolder) holder;
        final Livro livroEscolhido = listaLivros.get(position);

        livroholder.text.setText(livroEscolhido.getTitulo());
        livroholder.image.setImageResource(livroEscolhido.getImg());

    }

    @Override
    public int getItemCount(){
        return listaLivros == null ? 0 : listaLivros.size();
    }


    //Class Livro Holder
    public class LivroViewHolder extends RecyclerView.ViewHolder{
        final TextView text;
        final ImageView image;

        public LivroViewHolder(View v) {
            super(v);
            text = v.findViewById(R.id.nomeFruta);
            image = v.findViewById(R.id.imgFruta);
        }

    }
}
