//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package br.com.andreikeda.x_maps.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import br.com.andreikeda.x_maps.R.layout;

public final class SelectSkinFragment_
    extends SelectSkinFragment
{

    private View contentView_;

    private void init_(Bundle savedInstanceState) {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    private void afterSetContentView_() {
        lySkin = ((LinearLayout) findViewById(br.com.andreikeda.x_maps.R.id.ly_skin));
        imgSport = ((ImageView) findViewById(br.com.andreikeda.x_maps.R.id.img_sport));
        {
            View view = findViewById(br.com.andreikeda.x_maps.R.id.btn_select);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        SelectSkinFragment_.this.onBtnSelectClicked();
                    }

                }
                );
            }
        }
        {
            View view = findViewById(br.com.andreikeda.x_maps.R.id.ly_skin);
            if (view!= null) {
                view.setOnTouchListener(new OnTouchListener() {


                    @Override
                    public boolean onTouch(View view, MotionEvent event) {
                        return changeSkin(event);
                    }

                }
                );
            }
        }
        loadSkin();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView_ = super.onCreateView(inflater, container, savedInstanceState);
        if (contentView_ == null) {
            contentView_ = inflater.inflate(layout.frag_select_skin, container, false);
        }
        afterSetContentView_();
        return contentView_;
    }

    public View findViewById(int id) {
        if (contentView_ == null) {
            return null;
        }
        return contentView_.findViewById(id);
    }

    public static SelectSkinFragment_.FragmentBuilder_ builder() {
        return new SelectSkinFragment_.FragmentBuilder_();
    }

    public static class FragmentBuilder_ {

        private Bundle args_;

        private FragmentBuilder_() {
            args_ = new Bundle();
        }

        public SelectSkinFragment build() {
            SelectSkinFragment_ fragment_ = new SelectSkinFragment_();
            fragment_.setArguments(args_);
            return fragment_;
        }

    }

}
