//package com.sk.p2p.camera.video;
//
///**
// * Created by wsj on 2018/8/23.
// */
//import java.io.File;
//import java.util.ArrayList;
//
//import org.jim2mov.core.DefaultMovieInfoProvider;
//import org.jim2mov.core.FrameSavedListener;
//import org.jim2mov.core.ImageProvider;
//import org.jim2mov.core.Jim2Mov;
//import org.jim2mov.core.MovieInfoProvider;
//import org.jim2mov.core.MovieSaveException;
//import org.jim2mov.utils.MovieUtils;
//
//public class FilesToMov implements ImageProvider, FrameSavedListener{
//    // 文件数组
//    private ArrayList<String> fileArray = null;
//    // 文件类型
//    private int type = MovieInfoProvider.TYPE_QUICKTIME_JPEG;
//    // 主函数
//    public static void main(String[] args) throws MovieSaveException {
//        ArrayList<String> fileArray = new ArrayList<>();
//        File[] listFiles = new File("C:\\Users\\wsj\\Desktop\\images").listFiles();
//
//        for (int i = 0; i < listFiles.length; i++) {
//            fileArray.add(listFiles[i].getAbsolutePath());
//        }
//        new FilesToMov(fileArray, MovieInfoProvider.TYPE_QUICKTIME_JPEG, "Test.mov");
//    }
//
//    /**
//     * 图片转视频
//     * @param filePaths 文件路径数组
//     * @param type 格式
//     * @param path 文件名
//     * @throws MovieSaveException
//     */
//    public FilesToMov(ArrayList<String> fileArray, int type, String path) throws MovieSaveException {
//        this.fileArray = fileArray;
//        this.type = type;
//        DefaultMovieInfoProvider dmip = new DefaultMovieInfoProvider(path);
//        // 设置帧频率
//        dmip.setFPS(1);
//        // 设置帧数--一张图片一帧
//        dmip.setNumberOfFrames(fileArray.size());
//        // 设置视频高度
//        dmip.setMWidth(320);
//        // 设置视频宽度
//        dmip.setMHeight(240);
//        new Jim2Mov(this, dmip, this).saveMovie(this.type);;
//    }
//
//    @Override
//    public void frameSaved(int frameNumber) {
//        System.out.println("Saved frame: " + frameNumber);
//    }
//
//    @Override
//    public byte[] getImage(int frame) {
//        try {
//            return MovieUtils.convertImageToJPEG(new File(fileArray.get(frame)), 1.0f);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
