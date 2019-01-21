package framgia.phannam.android.nmusic.data.model.home;

/**
 * Created by namp5 on 1/18/2019.
 */

public class Categories {
    private String mCateName;
    private int mCate;
    private int mCateImage;

    public Categories(String cateName, int cate, int cateImage) {
        mCateName = cateName;
        mCate = cate;
        mCateImage = cateImage;
    }

    public String getCateName() {
        return mCateName;
    }

    public void setCateName(String cateName) {
        mCateName = cateName;
    }

    public int getCate() {
        return mCate;
    }

    public void setCate(int cate) {
        mCate = cate;
    }

    public int getCateImage() {
        return mCateImage;
    }

    public void setCateImage(int cateImage) {
        mCateImage = cateImage;
    }
}
