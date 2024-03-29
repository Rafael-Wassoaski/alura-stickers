import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.util.regex.Pattern;

public class StickerGenerator {

    public void generateSticker(InputStream inputStream, String bottomMsg) throws IOException{
        
        BufferedImage originalImage = ImageIO.read(inputStream);

        int originalImageWidth = originalImage.getWidth();
        int originalImageHeight = originalImage.getHeight();
        int newImageHeight = originalImageHeight + 50;

        BufferedImage newImage = new BufferedImage(originalImageWidth, newImageHeight, BufferedImage.TRANSLUCENT);
        Graphics2D newImageGraphics = (Graphics2D) newImage.getGraphics();
        newImageGraphics.drawImage(originalImage, 0, 0, null);

        Font imageTextFont = new Font(Font.SERIF, Font.BOLD, 52);
        newImageGraphics.setFont(imageTextFont);
        newImageGraphics.setColor(Color.YELLOW);
        newImageGraphics.drawString(bottomMsg, originalImageWidth / 2 - ((bottomMsg.length() / 2) * (52/2)), newImageHeight - 11);

        String sanitizedFileName = sanitizeFileName(bottomMsg);
        System.out.println(sanitizedFileName);
        ImageIO.write(newImage, "png", new File("src/public/images/" + sanitizedFileName + ".png"));
    }


    private String sanitizeFileName(String stickerName){
        String spaceSanitizedFileName =  stickerName.replaceAll(" ", "_");
        String dashSanitizedFileName =  spaceSanitizedFileName.replaceAll("/", "_");
        String colonSanitizedFileName =  spaceSanitizedFileName.replaceAll(":", "_");

        return colonSanitizedFileName;
    }
    // public static void main(String[] args) {

    //     try {
    //         InputStream inputStream = new URL("blob:https://web.whatsapp.com/19286860-d970-4261-839a-4ab2f2b922d4").openStream();
    //         generateSticker(inputStream, "Sapatenis");
    //     } catch (Exception e) {
    //         System.out.println("Erro: " + e.getMessage());
    //         e.printStackTrace();
    //     }
    // }
}
