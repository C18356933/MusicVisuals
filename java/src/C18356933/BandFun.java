package C18356933;
import processing.core.*;
public class BandFun {
    MyVisual mv;

    public BandFun(MyVisual mv) 
    {
        this.mv = mv;
    }
    public void band1()
    {
        float gap = mv.width / (float) mv.getBands().length;
        mv.strokeWeight(5);
        for(int i = 0 ; i < mv.getBands().length ; i ++)
        {
            mv.fill(PApplet.map(i, 0,160, 255, 255), 0, 130);
            mv.rect(i * gap, mv.height, 50,-mv.getSmoothedBands()[i]+4); 
        }
    }
    
}