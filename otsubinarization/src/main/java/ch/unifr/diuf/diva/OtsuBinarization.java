package ch.unifr.diuf.diva;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.apache.commons.io.FilenameUtils;
import org.openimaj.image.FImage;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.processing.threshold.OtsuThreshold;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLConnection;


public class OtsuBinarization {
    /***
     * Entry point for OtsuBinarization
     *
     * @param args 0: Path to input image
     *             1: Path to output folder
     */
    public static void main(String[] args) {

        try {
            BufferedImage bufferedImage = ImageIO.read(new File(args[0]));
            FImage inputImage = ImageUtilities.createFImage(bufferedImage);
            OtsuThreshold otsuThreshold = new OtsuThreshold();
            otsuThreshold.processImage(inputImage);
            BufferedImage outputImage = ImageUtilities.createBufferedImageForDisplay(inputImage);
            String ext = FilenameUtils.getExtension(args[0]);
            //ByteArrayOutputStream os = new ByteArrayOutputStream();
            File outputFile = new File(args[1] + "otsuBinaryImage." + ext);
            ImageIO.write(outputImage,ext, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
