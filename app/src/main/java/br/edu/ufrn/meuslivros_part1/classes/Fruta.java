package br.edu.ufrn.meuslivros_part1.classes;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import br.edu.ufrn.meuslivros_part1.R;

@Entity(tableName = "tabela_fruta")
public class Fruta {

    String nome;
    String maturacao;
    double preco;

    @PrimaryKey(autoGenerate = true)
    int id;

    int img;
    boolean bitten;

    public Fruta(String nome,String maturacao, double preco){
        this.nome = nome;
        this.maturacao = maturacao;
        this.preco = preco;
        this.img = R.drawable.livro_icon_png_3;
        this.bitten = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public boolean isBitten() {
        return bitten;
    }

    public void setBitten(boolean bitten) {
        this.bitten = bitten;
    }

    public String getMaturacao() {
        return maturacao;
    }

    public void setMaturacao(String maturacao) {
        this.maturacao = maturacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
