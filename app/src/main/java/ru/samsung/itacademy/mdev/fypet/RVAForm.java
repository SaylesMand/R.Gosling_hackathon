package ru.samsung.itacademy.mdev.fypet;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RVAForm extends RecyclerView.Adapter<RVAForm.FormViewHolder> {

    private List<Form> formList;

    public RVAForm(List<Form> formList) {
        this.formList = formList;
    }

    @NonNull
    @Override
    public FormViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_form, parent, false);
        return new FormViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FormViewHolder holder, int position) {
        Form form = formList.get(position);
        holder.tvFormNameDog.setText(form.getNameDog());
        holder.tvFormAgeDog.setText(form.getAgeDog());
        holder.tvFormBreedDog.setText(form.getBreedDog());
        holder.imFormPhotoDog.setImageResource(form.getPhotoDog());

    }

    @Override
    public int getItemCount() {
        return formList.size();
    }

    public static class FormViewHolder extends RecyclerView.ViewHolder {
        TextView tvFormNameDog;
        TextView tvFormAgeDog;
        TextView tvFormBreedDog;
        ImageView imFormPhotoDog;

        public FormViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFormNameDog = itemView.findViewById(R.id.nameDog);
            tvFormAgeDog = itemView.findViewById(R.id.ageDog);
            tvFormBreedDog = itemView.findViewById(R.id.breedDog);
            imFormPhotoDog = itemView.findViewById(R.id.photoDog);
        }
    }
}