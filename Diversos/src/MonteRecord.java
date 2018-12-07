import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.wet.wired.jsr.converter.RecordingConverter;
import com.wet.wired.jsr.recorder.DesktopScreenRecorder;
import com.wet.wired.jsr.recorder.ScreenRecorderListener;

public class MonteRecord implements ScreenRecorderListener {

private class MyScreenRecorder extends DesktopScreenRecorder {

public MyScreenRecorder(OutputStream out, ScreenRecorderListener listen) {
super(out, listen);
}

public Rectangle initialiseScreenCapture() {
super.initialiseScreenCapture();
Rectangle rec = new Rectangle(100, 200, 1000, 500);
return rec;
}

}

public void frameRecorded(boolean arg0) throws IOException {
}

public void recordingStopped() {
}

public void record() throws IOException {

System.out.println("CAPTURANDO 10 SEGUNDOS DO LINK https://www.youtube.com/watch?v=xIjV4GOxkWU");

File file = new File("C:\\temp”, “video.cap");
OutputStream out = new FileOutputStream(file);

MyScreenRecorder screenRecorder = new MyScreenRecorder(out, this);
screenRecorder.startRecording();

try {
Thread.sleep(10 * 1000);
} catch (Exception e) {
}

System.out.println( "PARANDO A GRAVACAO");
screenRecorder.stopRecording();

System.out.println("CONVERTENDO VIDEO PARA MOVIE");
RecordingConverter.main(new String[] { file.getAbsolutePath() });

System.out.println("VIDEO CONVERTIDO");

out.close();

System.out.println("FIM");

}

public static void main(String[] args) {
}

}



