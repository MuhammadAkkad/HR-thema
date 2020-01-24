package com.example.hr_thema.slider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hr_thema.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class Slider extends
        SliderViewAdapter<Slider.SliderAdapterVH> {

    private Context context;
    private int mCount;

    public Slider(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });


        switch (position) {
            case 0:
                viewHolder.textViewHeader.setText("Lorem Ipsum, dizgi");
                viewHolder.textViewDescription.setText("Lorem Ipsum, dizgi ve baskı endüstrisi\n" +
                        "kullanılan mıgır metinlerdir. ");
                Glide.with(viewHolder.itemView)
                        .load("https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;
            case 1:
                viewHolder.textViewHeader.setText("Lorem Ipsum, dizgi");
                viewHolder.textViewDescription.setText("Lorem Ipsum, dizgi ve baskı endüstrisi\n" +
                        "kullanılan mıgır metinlerdir. ");
                Glide.with(viewHolder.itemView)
                        .load("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260")
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;
            case 2:
                viewHolder.textViewHeader.setText("Lorem Ipsum, dizgi");
                viewHolder.textViewDescription.setText("Lorem Ipsum, dizgi ve baskı endüstrisi\n" +
                        "kullanılan mıgır metinlerdir. ");
                Glide.with(viewHolder.itemView)
                        .load("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;
            default:
                viewHolder.textViewHeader.setText("Lorem Ipsum, dizgi");
                viewHolder.textViewDescription.setText("Lorem Ipsum, dizgi ve baskı endüstrisi\n" +
                        "kullanılan mıgır metinlerdir. ");
                Glide.with(viewHolder.itemView);
                break;

        }

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mCount;
    }

    public void setCount(int count) {
        this.mCount = count;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView textViewHeader;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            textViewHeader = itemView.findViewById(R.id.tv_slider_header);
            textViewDescription = itemView.findViewById(R.id.tv_slider_body);
            this.itemView = itemView;
        }
    }


}