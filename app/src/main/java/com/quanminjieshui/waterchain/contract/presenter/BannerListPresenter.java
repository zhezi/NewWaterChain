package com.quanminjieshui.waterchain.contract.presenter;

import com.quanminjieshui.waterchain.base.BaseActivity;
import com.quanminjieshui.waterchain.contract.BasePresenter;
import com.quanminjieshui.waterchain.contract.model.BannerListModel;
import com.quanminjieshui.waterchain.contract.view.BannerListViewImpl;

import java.util.List;

/**
 * Created by WanghongHe on 2018/12/13 14:43.
 */

public class BannerListPresenter extends BasePresenter<BannerListViewImpl> {

    private BannerListModel bannerListModel;

    public BannerListPresenter(){}

    public BannerListPresenter(BannerListModel bannerListModel){
        this.bannerListModel = bannerListModel;
    }

    public void getBannerList(BaseActivity activity, int cate, int position){
        if (bannerListModel == null){
            bannerListModel = new BannerListModel();
        }

        bannerListModel.getBannerList(activity, cate, position, new BannerListModel.BannerListCallBack() {

            @Override
            public void success(List<Object> list) {
                if (mView!=null){
                    mView.onBannerListSuccess(list);
                }
            }

            @Override
            public void failed(String msg) {
                if (mView!=null){
                    mView.onBannerListFailed(msg);
                }

            }
        });
    }
}
