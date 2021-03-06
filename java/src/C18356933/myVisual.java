package C18356933;

import ie.tudublin.*;

public class MyVisual extends Visual
{    
    EllipseFun wf;
    AudioBandsVisual abv;
    BandFun bf;

    public void settings()
    {
        size(1024, 500);
        
        // Use this to make fullscreen
        fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("notsobad.mp3");   

        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wf = new EllipseFun(this);
        abv = new AudioBandsVisual(this);
        bf = new BandFun(this);
    }

    public void keyPressed()
    {
        
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
        
    }

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
}