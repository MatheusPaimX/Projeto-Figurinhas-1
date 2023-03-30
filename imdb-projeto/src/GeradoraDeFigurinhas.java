import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    public void criarFigurinha(InputStream inputStream, String nomeArquivo, String texto, InputStream inputfotoMinha) throws Exception{
        BufferedImage imagem = ImageIO.read(inputStream);
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        BufferedImage novaImagem = new BufferedImage(largura, altura, BufferedImage.TRANSLUCENT);
        Graphics2D graficos = (Graphics2D)novaImagem.getGraphics();
        graficos.drawImage(imagem, 0, 0, null);
        BufferedImage fotoMinha = ImageIO.read(inputfotoMinha);
        int posicaoImagemY = altura - fotoMinha.getHeight();
        graficos.drawImage(fotoMinha, 0, posicaoImagemY, null);
        var fonte = new Font("impact", Font.BOLD, 80);
        graficos.setColor(Color.PINK);
        graficos.setFont(fonte);
        FontMetrics fontMetrics = graficos.getFontMetrics();
        Rectangle2D retangulo = fontMetrics.getStringBounds(texto, graficos);
        int larguraTexto = (int) retangulo.getWidth();
        int posicaoX = (largura -larguraTexto)/2;
        int posicaoY = altura - 20;
        graficos.drawString(texto, posicaoX , posicaoY );
        FontRenderContext fontRenderContext = graficos.getFontRenderContext();
        var textLayout = new TextLayout(texto, fonte, fontRenderContext);
        Shape outline = textLayout.getOutline(null);
        AffineTransform transform = graficos.getTransform();
        transform.translate(posicaoX, posicaoY);
        graficos.setTransform(transform);
        var outlineStroke = new BasicStroke(largura * 0.004f);
        graficos.setStroke(outlineStroke);
        graficos.setColor(Color.MAGENTA);
        graficos.draw(outline);
        
       
        ImageIO.write(novaImagem, "png",new File("saida/" + nomeArquivo));
    }
    
}
