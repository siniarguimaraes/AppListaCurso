package devandroid.ssg.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.ssg.applistacurso.R;

import devandroid.ssg.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Pessoa outraPessoa;

    String dadosPessoa;
    String dadosOutraPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Sinair");
        pessoa.setSobreNome("Silva Guimarães");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("65-9614-6994");

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Luiz");
        outraPessoa.setSobreNome("Alves");
        outraPessoa.setCursoDesejado("Android");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("065 99664-3105");

        dadosPessoa = "Primeiro nome : ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += " Curso Desejado ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone de Contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        int parada = 0;




    }
}