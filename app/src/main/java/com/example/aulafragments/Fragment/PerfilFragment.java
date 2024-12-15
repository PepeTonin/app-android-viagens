package com.example.aulafragments.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aulafragments.Database.DatabaseHelper;
import com.example.aulafragments.Model.PerfilUsuario;
import com.example.aulafragments.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {

    private PerfilUsuario perfil;
    private TextView tvNome;
    private TextView tvDataNascimento;
    private TextView tvGenero;
    private TextView tvEmail;
    private TextView tvTelefone;
    private ListView listViewLugares;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConversasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        tvNome = view.findViewById(R.id.tvNome);
        tvDataNascimento = view.findViewById(R.id.tvDataNascimento);
        tvGenero = view.findViewById(R.id.tvGenero);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvTelefone = view.findViewById(R.id.tvTelefone);
        listViewLugares = view.findViewById(R.id.listViewLugares);

        criarPerfil();

        tvNome.setText(perfil.getNome());
        tvDataNascimento.setText(perfil.getDataNascimento());
        tvGenero.setText(perfil.getGenero());
        tvEmail.setText(perfil.getEmail());
        tvTelefone.setText(perfil.getTelefone());

        ArrayAdapter<String> adapterLugares = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, perfil.getLugaresVisitados());
        listViewLugares.setAdapter(adapterLugares);

        salvarPerfil();

        return view;
    }

    public void criarPerfil() {
        perfil = new PerfilUsuario("John Doe", "07/03/1995", "Masculino", "example@email.com", "123456789");
        String[] lista = {"New York", "London", "Paris", "Tokyo", "Sydney", "Berlin", "Moscow", "Dubai", "Mumbai", "Singapore", "Hong Kong", "Shanghai", "Los Angeles", "Toronto", "São Paulo", "Buenos Aires", "Cape Town", "Cairo", "Istanbul", "Bangkok", "Mexico City", "Seoul", "Rome", "Madrid", "Lisbon", "Amsterdam", "Vienna", "Zurich", "Dublin", "Kuala Lumpur", "Jakarta", "Lima", "Bogotá", "Rio de Janeiro", "San Francisco", "Chicago", "Melbourne", "Barcelona", "Beijing", "Munich", "Stockholm", "Warsaw", "Prague", "Brussels", "Helsinki", "Athens", "Budapest", "Manila", "Johannesburg", "Montreal", "Vancouver"};
        perfil.setLugaresVisitados(lista);
    }

    public void salvarPerfil() {
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        long newRowId = dbHelper.inserirPerfil(perfil);
    }
}