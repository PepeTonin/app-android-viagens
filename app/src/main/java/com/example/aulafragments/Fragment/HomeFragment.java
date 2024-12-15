package com.example.aulafragments.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.aulafragments.Activity.DetalhesViagem;
import com.example.aulafragments.Adapter.AdapterHome;
import com.example.aulafragments.Listener.RecyclerItemClickListener;
import com.example.aulafragments.Model.PacoteViagem;
import com.example.aulafragments.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView tvTitle;
    private RecyclerView recyclerView;
    private List<PacoteViagem> pacoteViagemList = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContatosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tvTitle = view.findViewById(R.id.tvTitle);
        recyclerView = view.findViewById(R.id.recyclerView);

        this.popularLista();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        AdapterHome adapterHome = new AdapterHome(pacoteViagemList);

        recyclerView.setAdapter(adapterHome);

        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                getContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getContext(), DetalhesViagem.class);

                        PacoteViagem item = pacoteViagemList.get(position);
                        intent.putExtra("origem", item.getOrigem());
                        intent.putExtra("destino", item.getDestino());
                        intent.putExtra("dataIda", item.getDataIda());
                        intent.putExtra("dataVolta", item.getDataVolta());
                        intent.putExtra("pessoas", item.getPessoasInclusas());
                        intent.putExtra("valor", item.getValor());

                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
            )
        );


        return view;
    }

    private void popularLista() {
        pacoteViagemList.add(new PacoteViagem("São Paulo", "Rio de Janeiro", "01/01/2024", "05/01/2024", 2, 1500));
        pacoteViagemList.add(new PacoteViagem("Curitiba", "Florianópolis", "10/02/2024", "15/02/2024", 4, 2000));
        pacoteViagemList.add(new PacoteViagem("Belo Horizonte", "Salvador", "20/03/2024", "30/03/2024", 1, 2500));
        pacoteViagemList.add(new PacoteViagem("Porto Alegre", "Gramado", "01/04/2024", "03/04/2024", 3, 800));
        pacoteViagemList.add(new PacoteViagem("Manaus", "Fortaleza", "05/05/2024", "12/05/2024", 2, 3000));
        pacoteViagemList.add(new PacoteViagem("Recife", "João Pessoa", "15/06/2024", "20/06/2024", 5, 1800));
        pacoteViagemList.add(new PacoteViagem("Brasília", "Bonito", "10/07/2024", "17/07/2024", 2, 2200));
        pacoteViagemList.add(new PacoteViagem("Rio de Janeiro", "São Paulo", "12/01/2024", "16/01/2024", 1, 1200));
        pacoteViagemList.add(new PacoteViagem("Fortaleza", "Natal", "05/02/2024", "10/02/2024", 3, 1700));
        pacoteViagemList.add(new PacoteViagem("Salvador", "Recife", "18/03/2024", "25/03/2024", 2, 1400));
        pacoteViagemList.add(new PacoteViagem("Florianópolis", "Curitiba", "01/04/2024", "05/04/2024", 4, 900));
        pacoteViagemList.add(new PacoteViagem("São Paulo", "Porto Alegre", "10/05/2024", "15/05/2024", 1, 2500));
        pacoteViagemList.add(new PacoteViagem("Belo Horizonte", "Rio de Janeiro", "20/06/2024", "24/06/2024", 2, 1800));
        pacoteViagemList.add(new PacoteViagem("Manaus", "Belém", "01/07/2024", "08/07/2024", 2, 2100));
    }
}