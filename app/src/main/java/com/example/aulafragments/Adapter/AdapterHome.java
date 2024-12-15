package com.example.aulafragments.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aulafragments.Model.PacoteViagem;
import com.example.aulafragments.R;

import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {

    private List<PacoteViagem> pacoteViagemList;

    public AdapterHome(List<PacoteViagem> pacoteViagemList) {
        this.pacoteViagemList = pacoteViagemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list_home, parent, false);
        return new ViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PacoteViagem pacoteViagem = pacoteViagemList.get(position);
        holder.tvOrigem.setText(pacoteViagem.getOrigem());
        holder.tvDestino.setText(pacoteViagem.getDestino());
        holder.tvDataIda.setText(pacoteViagem.getDataIda());
        holder.tvDataVolta.setText(pacoteViagem.getDataVolta());

        int pessoasInclusas = pacoteViagem.getPessoasInclusas();
        String pessoasInclusasString;
        if (pessoasInclusas == 1) {
            pessoasInclusasString = Integer.toString(pacoteViagem.getPessoasInclusas()) + " pessoa";
        } else {
            pessoasInclusasString = Integer.toString(pacoteViagem.getPessoasInclusas()) + " pessoas";
        }
        holder.tvPessoasInclusas.setText(pessoasInclusasString);

        float valor = pacoteViagem.getValor();
        String valorString = "R$ " + String.format("%.2f", valor);
        holder.tvValor.setText(valorString);

    }

    @Override
    public int getItemCount() {
        return pacoteViagemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvOrigem;
        TextView tvDestino;
        TextView tvDataIda;
        TextView tvDataVolta;
        TextView tvPessoasInclusas;
        TextView tvValor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOrigem = itemView.findViewById(R.id.tvOrigem2);
            tvDestino = itemView.findViewById(R.id.tvDestino);
            tvDataIda = itemView.findViewById(R.id.tvDataIda);
            tvDataVolta = itemView.findViewById(R.id.tvDataVolta);
            tvPessoasInclusas = itemView.findViewById(R.id.tvPessoasInclusas);
            tvValor = itemView.findViewById(R.id.tvValor);
        }
    }

}
