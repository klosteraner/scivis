package MinJV;

import java.applet.Applet;
import java.awt.*;

import jv.loader.PgLoader;
import jv.object.PsConfig;
import jv.object.PsPanel;
import jv.object.PsViewerIf;
import jv.project.PjProject;
import jv.viewer.PvViewer;
import jv.project.PjProject_IP;

@SuppressWarnings("serial")
public class MinJV extends Applet {

    static String DEFAULTGEO = "models/byu/Cow_5804.byu";

    public Frame jvFrame;
    public PvViewer jvViewer;

    public MinJV(String modelFile) {

        jvFrame = new jv.object.PsMainFrame(this, null);
        jvViewer = new PvViewer(this, jvFrame);

        PjProject project = new PjProject("this");
        jvViewer.addProject(project);
        jvViewer.selectProject(project);
        
        //project.addTitle("Torus Knot");
        //project.add(new PsPanel());
        //project.addLine(1);
        this.setLayout(new BorderLayout());
        this.add(jvViewer.getDisplay().getCanvas(), BorderLayout.CENTER); //Add 3D-Window
        this.add(jvViewer.getPanel(PsViewerIf.PROJECT), BorderLayout.EAST); //Add Panel
        jvFrame.pack();
        jvFrame.setVisible(true);
    }

    public void loadModel(String modelFile) {
        if (modelFile == null) {
            modelFile = PsConfig.getCodeBase() + DEFAULTGEO;
        }
        PgLoader loader = new PgLoader();
        jvViewer.getCurrentProject().addGeometry((loader.loadGeometry(modelFile))[0]);
    }

    public MinJV() {
        this(null);
    }

    public static void main(String args[]) {
        new MinJV(null);
    }
}
