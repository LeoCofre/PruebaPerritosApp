package cl.desafiolatam.pruebaperritosapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;



import java.util.List;

import cl.desafiolatam.pruebaperritosapp.R;


public class DogPhotoRecycleViewAdapter extends RecyclerView.Adapter<DogPhotoRecycleViewAdapter.ViewHolderImages> {

    private ImageView imagenes;
    private List<String> mUrl;

    public DogPhotoRecycleViewAdapter(List<String> mUrl) {
        this.mUrl = mUrl;
    }

    @Override
    public String toString() {
        return "DogPhotoRecycleViewAdapter{" +
                "mUrl=" + mUrl +
                '}';
    }

    @NonNull
    @Override
    public DogPhotoRecycleViewAdapter.ViewHolderImages onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_dog_image, parent, false);
        return new ViewHolderImages(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderImages holder, int position) {
        // incorporacion de glide para las imagenes
        Glide.with(holder.perrito.getContext())
                .load(mUrl.get(position))
                .centerCrop()
                .into(holder.perrito);
    }



    @Override
    public int getItemCount() {
        return mUrl.size();
    }

    private String getUrl(int position){
        return position != RecyclerView.NO_POSITION ? mUrl.get(position) : "No";
    }

    public class ViewHolderImages extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTextView;
        public final ImageView perrito;

        @Override
        public String toString() {
            return "ViewHolderImages{" +
                    "mView=" + mView +
                    ", mTextView=" + mTextView +
                    ", perrito=" + perrito +
                    '}';
        }

        public ViewHolderImages(@NonNull View view) {
            super(view);
            mView = view;
            mTextView = (TextView) itemView.findViewById(R.id.nombreRazaDetalle);
            perrito = itemView.findViewById(R.id.imagenPerrito);
        }
    }
}


