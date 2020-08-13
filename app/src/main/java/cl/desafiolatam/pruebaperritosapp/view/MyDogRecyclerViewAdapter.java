package cl.desafiolatam.pruebaperritosapp.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.desafiolatam.pruebaperritosapp.R;



public class MyDogRecyclerViewAdapter extends RecyclerView.Adapter<MyDogRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "MyDogRecyclerViewAdapter";
    private final List<String> mValues;
    private OnItemClickListener mListener;

    public MyDogRecyclerViewAdapter(List<String> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_dog, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //holder.mIdView.setText(mValues.get(position));
        holder.mContentView.setText(mValues.get(position));
        Log.i("Valor holderItem", holder.mItem);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onItemClick(position);
                    Log.d("TAG", String.valueOf(position));

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener mListener) {

        this.mListener = mListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public String mItem;

        public ViewHolder(View view, OnItemClickListener mListener) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(getAdapterPosition());
                }
            });
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
