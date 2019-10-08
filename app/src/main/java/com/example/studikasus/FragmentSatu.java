package com.example.studikasus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentSatu extends Fragment {
    //membuat class fragment

    View Aflah; //membuat variabel global
    EditText edtTxt;
    TextView txtView;
    Button bt;

    @Nullable
    @Override
    //tipe data View on create untuk mengembalikan activity
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //cara memanggil tampilan fragment
        Aflah = inflater.inflate(R.layout.activity_fragment_satu, container, false);
        //memanggil variabel global "Aflah", agar layout tidak masuk manifest tulis "false"

        edtTxt = Aflah.findViewById(R.id.edtText1);
        txtView = Aflah.findViewById(R.id.tView1);
        bt = Aflah.findViewById(R.id.bt1);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //panggil text String
                String input = edtTxt.getText().toString();
                //merubah string menjadi huruf kecil semua
                input.toLowerCase(); //normalisasi
                String[] ArrayInputCamelCase = input.split(" ");
                String Hasil = " ";
                for (int i = ArrayInputCamelCase.length-1; i > 0;  i--)
                {
                    System.out.println(ArrayInputCamelCase[i]);
                    if (ArrayInputCamelCase[i].equals("Bohong")) {
                        ArrayInputCamelCase[i - 1] = malek(ArrayInputCamelCase[i - 1]);
                    }
                    Hasil = ArrayInputCamelCase[0];
                }
                txtView.setText(Hasil);
            }
        });
        return Aflah; //untuk menampilkan layout
    }

    public String malek(String inputan) {
        String result = " ";
        if (inputan.equals("Bohong")) //jika string gunakan equals, jika int / float gunakan "=="
        {
            result = "Jujur";
        }else {
            result = "bohong";
        }
        return result;
    }
}
