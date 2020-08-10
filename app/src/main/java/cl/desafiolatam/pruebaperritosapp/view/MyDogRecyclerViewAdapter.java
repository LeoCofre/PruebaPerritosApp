package cl.desafiolatam.pruebaperritosapp.view;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.desafiolatam.pruebaperritosapp.R;

public class MyDogRecyclerViewAdapter extends RecyclerView.Adapter<MyDogRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "MyDogRecyclerViewAdapter";
    private final List<String> mValues;
    private final ListDogFragment.OnListFragmentInteractionListener mListener;

    MyDogRecyclerViewAdapter(List<String> items, ListDogFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_dog, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position));
        holder.mContentView.setText(mValues.get(position));
        Log.i("Valor holderItem", holder.mItem);


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    private String getId(int position){
        return position != RecyclerView.NO_POSITION ? mValues.get(position) : "No";
    }

    @SuppressLint("LongLogTag")
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final View mView;
        final TextView mIdView;
        final TextView mContentView;
        String mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.item_number);
            mContentView = view.findViewById(R.id.content);
            view.setOnClickListener(this);
            mIdView.setOnClickListener(this);
            mContentView.setOnClickListener(this);
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick entrando..");
            mListener.onListFragmentInteraction(getId(getAdapterPosition()));
        }
    }
}


