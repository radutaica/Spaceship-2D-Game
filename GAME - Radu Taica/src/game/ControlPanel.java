package game;

import city.cs.engine.World;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ControlPanel  {

    private JButton quitButton;
    private JPanel MainPanel;
    private JButton resumeButton;
    private JButton pauseButton;
    private JProgressBar Health;
    private JProgressBar BossHP;
    private JMenuBar MenuBar;
    private JMenu MyMenu;
    private JLabel Volume;
    private JSlider sldVolume;
    private JButton Mute;
    private JList list1;


    public void setHealth(int i){
        Health.setValue(i);
    }
    public void setBossHP(int i){BossHP.setValue(i);}
    ControlPanel(Game game){
        super();

        Mute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                    Sounds.getBackground().setVolume(0.0001);
                    Sounds.getBackground2().setVolume(0.0001);
                    Sounds.getBackground3().setVolume(0.0001);

                    sldVolume.setValue(1);
                }

        });
        sldVolume.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                float volume = scale((float)sldVolume.getValue(),1.0f,10.0f,0.0001f,2.0f);
                Sounds.getBackground().setVolume(volume);
                Sounds.getBackground2().setVolume(volume);
                Sounds.getBackground3().setVolume(volume);
            }
        });

        quitButton.addActionListener(actionEvent -> System.exit(0));
        pauseButton.addActionListener(actionEvent -> game.pauseGame());
        resumeButton.addActionListener(actionEvent -> game.resumeGame());

        Health.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        BossHP.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);

            }
        });
    }
    public JPanel getMainPanel() {
        return MainPanel;
    }
    private float scale(float value, float MinInput,float MaxInput,float MinRange, float MaxRange){
        return ((MaxRange-MinRange)*(value-MinInput)/(MaxInput-MinInput))+MinRange;
    }


}
