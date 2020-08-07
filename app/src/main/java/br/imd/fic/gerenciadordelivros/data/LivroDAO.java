package br.imd.fic.gerenciadordelivros.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.imd.fic.gerenciadordelivros.dominio.Livro;

public class LivroDAO {

    private SQLiteDatabase bd;
    private static LivroDAO instance;

    private LivroDAO(Context context) {
        DBHelper dbHelper = DBHelper.getInstance(context);
        bd = dbHelper.getWritableDatabase();
    }

    public static LivroDAO getInstance(Context context) {
        if (instance == null) {
            instance = new LivroDAO(context.getApplicationContext());
        }

        return instance;
    }

    public List<Livro> list() {

        String[] columns = {
            LivroContract.Columns._ID,
            LivroContract.Columns.titulo,
            LivroContract.Columns.autor,
            LivroContract.Columns.editora,
            LivroContract.Columns.emprestado
        };

        try (
            Cursor c = bd.query(LivroContract.TABLE_NAME,
                    columns,
                    null,
                    null,
                    null,
                    null,
                    LivroContract.Columns.titulo);
                ) {
            if (c.moveToFirst())
                //https://youtu.be/0pQ9aRK0ggY?t=3028
        }

    }
}
