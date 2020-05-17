# Music Visualiser Project

Name: Adam Bermingham

Student Number: C18356933

# Description of the assignment
For this OOP assignment we were tasked with creating something visually pleasing that you could look at while listening to music.
I felt this assingment would match perfectly with the genre of music i like to listen to (house/techno). So i was excited to do the project.
I tried to incooperate alot of different aspects into the project by including shapes using ellipses and doing waveform and audio bands all in the one project.
Altogether i have 6 different functions that render different visuals.
You can change the visuals by pressing a key.(1-6)

# Instructions
I kept everything in the master branch so that it was easy to find for Bryan. I use kept the provided files given at the started and created two new file 
1.EllipseFun.java(this contains 4 visuals that i used ellipse to create)
2.BandFun (this contains audio band and waveform )
You access the 4 visuals from ellipsefun by pressing 1,2,3 or 4 
You access the bandfun by pressing 5 or 6
# How it works
There are 6 functions render1() render2() render3() render4() band1() band()2
Each function when called with draw a different shape which will react to the beat of the music 

In the draw() function of MyVisual i have an if pressed component that will call the function that is assigned to that key 
```Java
public void draw()
    {
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 
 
        // Call this is you want to get the average amplitude
        calculateAverageAmplitude(); 
        
        // this used to call different drawings 
        if (key == '1')
        {
            wf.render1();
        }
        if (key == '2')
        {
            wf.render2();
        }
       if (key == '3')
        {
            wf.render3();
        }
        if (key == '4')
        {
            wf.render4();
        }
        if (key == '5')
        {
            bf.band1();
        }
        if (key == '6')
        {
            bf.band2();
        }
        
	}
	```
If 1 is pressed it will call the function render1() from the ellipse fun class hence the wf.render1()
```Java
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
```
If 2 is pressed it will call the function render2() from the ellipse fun class hence the wf.render2()
```Java
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
```
If 3 is pressed it will call the function render3() from the ellipse fun class hence the wf.render3()
```Java
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
```
If 4 is pressed it will call the function render4() from the ellipse fun class hence the wf.render4()
```Java
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
```
If 5 is pressed it will call the function band1() from the ellipse fun class hence the bf.band1()
```Java
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
```
If 6 is pressed it will call the function band2() from the ellipse fun class hence the bf.band2()
```Java
public void band2()
    { 
        mv.colorMode(PApplet.HSB);
        float cy = 0;
        cy = mv.height;
        for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
        {
            mv.stroke(
                PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );

            mv.line(i,cy, i, cy+ cy * mv.getAudioBuffer().get(i));
        }
    }
```
# What I am most proud of in the assignment
I am proud of some of 2 of the crazy shapes i made in render 3 and 4 and i am proud of the audio band and i am proud that i was able to use some simple components and make them fit well with the team.
I am super proud of finishing the assignment to a high standard with the bombardment of new assessments due to there being no exam i was thrilled i found time to do all assignments to such a high standerd while being dource to work fulltime due to low staff during pandemic.
I am delighted with the if pressed display a certain shape.
I am delighted with how simple i kept the code and file structure as it is so easy to see how each class is passed and how things are called.
Overal this project turned out much better than i expect as i am really not that artistic so coming up with some of the cool shapes was a real surprise to me.
Hope you enjoy the project as much as i did.

Adam Bermingham C18356933

This is a youtube video:

[![YouTube](http://i3.ytimg.com/vi/rjho1_HyVC8/maxresdefault.jpg)](https://www.youtube.com/watch?v=rjho1_HyVC8&feature=youtu.be)

