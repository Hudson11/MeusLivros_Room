package br.edu.ufrn.meuslivros_part1.Interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.edu.ufrn.meuslivros_part1.classes.Livro;

@Dao
public interface LivroDao {

    @Insert
    long inserir(Livro livro);

    @Delete
    int delete(Livro livro);

    @Query("SELECT * FROM tabela_livro")
    List <Livro> listAll();

}
