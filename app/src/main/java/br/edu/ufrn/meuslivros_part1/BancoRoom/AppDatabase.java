package br.edu.ufrn.meuslivros_part1.BancoRoom;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.edu.ufrn.meuslivros_part1.Interfaces.FrutaDao;
import br.edu.ufrn.meuslivros_part1.Interfaces.LivroDao;
import br.edu.ufrn.meuslivros_part1.classes.Fruta;
import br.edu.ufrn.meuslivros_part1.classes.Livro;

@Database(entities = {Livro.class}, version=1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract LivroDao livroDao();
    //public abstract FrutaDao frutaDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context){

        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "Livro_Database_Room").allowMainThreadQueries().build();
                }
            }
        }

        return INSTANCE;
    }
}
