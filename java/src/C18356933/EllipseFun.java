package C18356933;

public class EllipseFun 
{
    MyVisual mv;

    public EllipseFun(MyVisual mv) 
    {
        this.mv = mv;
    }
    
    public void render1() 
    {
        // variables
        float x1,y1,x2,y2;
        // values
        x1 = 1000;
        y1 = 1000;
        x2 = 0;
        y2 = 0 ;
        // centre
        mv.translate(mv.width / 2, mv.height / 2);
        for (int j = 0; j < 1; j++) 
        {
            mv.fill(153, 0, 153);
            x1 = mv.getSmoothedBands()[2 - 1 - 1];
            y1 = mv.getSmoothedBands()[2 - 1 - 1];
            mv.ellipse(x2, y2, x1, y1);        
        }
    }

    public void render2() 
    {
        int numofEll ;
        float x1,y1,x2,y2;
        x1 = 10;
        y1 = 100;
        x2 = 0;
        y2 = 0;
        numofEll=4;
        mv.translate(mv.width / 2, mv.height / 2);
        mv.noStroke();
        for (int i = 0; i < 9; i++) {
            mv.fill(0, 0, 255);
            y1 = MyVisual.map(mv.getSmoothedBands()[i], 0, 1000, mv.height / 6, mv.height / 1);
            for (int j = 0; j < numofEll; j++) {
                mv.ellipse(x2, y2 + y1 / 2, x1, y1);
                mv.rotate(MyVisual.TWO_PI / numofEll);
            }   
        }
    }

    public void render3() 
    {
        //variables
        int numofEll;
        float x1,y1,x2,y2,r,g,b;
        //values
        x1= 1000;
        y1 = 500;
        x2 = 0;
        y2 = 0 ;
        r =0;
        g=204;
        b=0;
        numofEll= 8;
        //centre
        mv.translate(mv.width / 2, mv.height / 2);
        mv.strokeWeight(5);
        for (int i = 0; i < 4; i++) 
        {
            mv.fill(r, g, b);
            x1 = mv.getSmoothedBands()[4 - i - 1] * 0.6f;
            for (int j = 0; j < numofEll; j++) 
            {
                mv.ellipse(x2, y2, x1, y1);
                mv.rotate(MyVisual.TWO_PI / numofEll);
            }
            r=(r+100);
            g=(g/2);
            b=(b+200);
        }
    }

    public void render4()
    {
        //variables
        int numofEll;
        float x1,y1,x2,y2,r,g,b;
        //values
        x1= 1000;
        y1 = 500;
        x2 = 0;
        y2 = y1/2;
        r =150;
        g=204;
        b=255;
        numofEll= 32;
        //centre
        mv.translate(mv.width / 2, mv.height / 2);
        mv.strokeWeight(2);
        for (int i = 0; i < 4; i++) 
        {
            mv.fill(r, g, b);
            y1 = MyVisual.map(mv.getSmoothedBands()[i], 0, 500, mv.height/118, mv.height / 4);
            for (int j = 0; j < numofEll; j++) 
            {
                mv.ellipse(x2, y2, x1, y1);
                mv.rotate(MyVisual.TWO_PI / numofEll);
            }
            r=(r/100);
            g=(g/2);
            b=(b/200);
        }
    }
}