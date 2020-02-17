package com.example.hr_thema.slider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hr_thema.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class Slider extends
        SliderViewAdapter<Slider.SliderAdapterVH> {
    // temp strings
    String header = "Lorem Ipsum, dizgi";
    String description1 = "Lorem Ipsum, dizgi ve baskı endüstrisi\n" +
            "kullanılan mıgır metinlerdir. Lorem Ipsum, \n" +
            "adı bilinmeyen bir matbaacının bir hurufat \n" +
            "numune kitabı";
    String description2 = "Lorem Ipsum, dizgi ve baskı endüstrisi\n" +
            "kullanılan mıgır metinlerdir. Lorem Ipsum, \n" +
            "adı bilinmeyen bir matbaacının bir hurufat \n" +
            "numune kitabı";
    String description3 = "Lorem Ipsum, dizgi ve baskı endüstrisi\n" +
            "kullanılan mıgır metinlerdir. Lorem Ipsum, \n" +
            "adı bilinmeyen bir matbaacının bir hurufat \n" +
            "numune kitabı";
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
                viewHolder.textViewHeader.setText(header);
                viewHolder.textViewDescription.setText(description1);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.image_slider1)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;
            case 1:
                viewHolder.textViewHeader.setText(header);
                viewHolder.textViewDescription.setText(description2);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.image_slider2)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;
            case 2:
                viewHolder.textViewHeader.setText(header);
                viewHolder.textViewDescription.setText(description3);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.image_slider3)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;
            default:
                viewHolder.textViewHeader.setText(header);
                viewHolder.textViewDescription.setText(description1);
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

        ImageView logo;
        Button btn_skip;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            textViewHeader = itemView.findViewById(R.id.tv_slider_header);
            textViewDescription = itemView.findViewById(R.id.tv_slider_body);
            logo = itemView.findViewById(R.id.img_logo_activity_main);
            //btn_skip = itemView.findViewById(R.id.btn_skip_welcome_page);
            this.itemView = itemView;
        }
    }


}