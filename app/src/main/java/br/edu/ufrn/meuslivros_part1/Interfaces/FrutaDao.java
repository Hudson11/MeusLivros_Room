package br.edu.ufrn.meuslivros_part1.Interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.edu.ufrn.meuslivros_part1.classes.Fruta;

@Dao
public interface FrutaDao {

    @Insert
    long inserir(Fruta fruta);

    @Delete
    int delete(Fruta fruta);

    @Query("SELECT * FROM tabela_fruta")
    List<Fruta> listAll();

}
