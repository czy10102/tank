import fram.TankFrame;

public class MAIN {
    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame();

        for(;;){
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
            tankFrame.repaint();
        }
    }
}
