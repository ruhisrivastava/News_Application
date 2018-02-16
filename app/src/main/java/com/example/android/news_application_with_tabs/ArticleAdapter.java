package com.example.android.news_application_with_tabs;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import com.example.android.news_application_with_tabs.model.Item;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.DataHolder> {

    private List<Item> items;

    private Context context;
    private LayoutInflater inflater;

    private TabFragment fragment;


    public ArticleAdapter(Context context, List<Item> items, TabFragment fragment) {
        this.context = context;
        this.items = items;
        inflater = LayoutInflater.from(context);
        this.fragment = fragment;
    }

    @Override
    public DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.article, parent, false);
        return new DataHolder(binding);

    }

    @Override
    public void onBindViewHolder(DataHolder holder, int position) {
        final Item currentItem = items.get(position);
        holder.bind(currentItem);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    class DataHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ViewDataBinding binding;


        public DataHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void bind(final Item currentItem) {
            binding.setVariable(com.example.android.news_application_with_tabs.BR.item, currentItem);
            binding.getRoot().findViewById(R.id.title).setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            fragment.articleClicked(currentItem.getId(),
                                    currentItem.getTitle(), currentItem.getBody());
                        }
                    }
            );
            binding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            //do nothing
        }
    }
}
