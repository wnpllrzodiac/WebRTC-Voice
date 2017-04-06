package cc.dot.camerafilters.entity;




public class FilterInfo {
    public boolean isExt;//是否使用扩展的滤镜(自己定义的滤镜)
    public int index;
    public FilterInfo(boolean isExt, int index) {
        this.isExt = isExt;
        this.index = index;
    }
}
