package innerclasses;

import javax.sound.midi.Track;

/**
 * @author lh
 */
public class Parcel6 {
    private void internalTracking(boolean b) {
        if(b) {
            class TrackingSlip{
                private String id;

                public TrackingSlip(String s) {
                    this.id = s;
                }

                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
}
