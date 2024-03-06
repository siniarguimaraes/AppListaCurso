package devandroid.ssg.applistacurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.ssg.applistacurso.model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller","Controller Iniciada...");

        return super.toString();
    }
    public void salvar(Pessoa pessoa) {
        Log.i("MVC_Controller","Salvo :   "+pessoa.toString());
    }
}
