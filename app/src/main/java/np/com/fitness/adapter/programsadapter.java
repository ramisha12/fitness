package np.com.fitness.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import np.com.fitness.R;
import np.com.fitness.model.programs;

public class programsadapter  extends RecyclerView.Adapter<programsadapter.ProgramViewHolder> {

    private Context context;
    private List<programs> programList;

    public programsadapter(Context context, List<programs> programList) {
        this.context = context;
        this.programList = programList;
    }

    @NonNull
    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_programs, parent, false);
        return new ProgramViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramViewHolder holder, int position) {
        programs program = programList.get(position);
        holder.imageView.setImageResource(program.getImageResource());
        holder.textView.setText(program.getTitle());
    }

    @Override
    public int getItemCount() {
        return programList.size();
    }

    public static class ProgramViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ProgramViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.tvprograms);
            textView = itemView.findViewById(R.id.textViewLabel1);
        }
    }
}

