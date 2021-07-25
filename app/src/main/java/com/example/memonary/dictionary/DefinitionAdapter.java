package com.example.memonary.dictionary;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memonary.R;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionAdapter.ViewHolder>{

    List<Definition> definitions;
    Context context;

    public DefinitionAdapter(List<Definition> definitions, Context context) {
        this.definitions = definitions;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_definition, parent, false);
        return new ViewHolder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Definition definition = definitions.get(position);
        holder.definition.setText(definition.getDefinition());
        holder.example.setText(definition.getExample());
        String synonyms = null;
        if (definition.getSynonyms() != null)
            synonyms = "synonyms: " + String.join(", ", definition.getSynonyms());
        holder.synonyms.setText(synonyms);
    }

    @Override
    public int getItemCount() {
        if (definitions == null)
            return 0;
        return definitions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView definition;
        private TextView example;
        private TextView synonyms;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.definition = itemView.findViewById(R.id.definitionTextView);
            this.example = itemView.findViewById(R.id.exampleTextView);
            this.synonyms = itemView.findViewById(R.id.synonymsTextView);
        }
    }
}
