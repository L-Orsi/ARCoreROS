package com.jamie.android_ros.arcore_ros.ros.sensors;

import com.google.ar.core.Camera;
import com.google.ar.core.Frame;
import com.google.ar.core.TrackingState;
import com.jamie.android_ros.arcore_ros.common.LiveData;

/** Sensor that retrieves {@code Frame} updates.
 *
 * As suggested for ARCore dependent sensors, it observes a {@code Frame} object via this codebase's
 * {@code LiveData} class.
 *
 * @author Lucas Scheinkerman (LucasJSch)
 * @since 1-04-2021
 */
public class CameraSensor extends BaseSensor<Frame>  implements LiveData.Observer<Frame> {

    private final LiveData<Frame> liveFrame;

    public CameraSensor(LiveData<Frame> liveFrame) {
        this.liveFrame = liveFrame;
    }

    @Override
    public void start() {
        liveFrame.observe(this);
    }

    @Override
    public void stop() {
        liveFrame.removeObserver(this);
    }

    @Override
    public void onChanged(Frame frame) {
        Camera camera = liveFrame.getValue().getCamera();
        if(camera.getTrackingState() == TrackingState.TRACKING){
            notifyListeners(frame);
        }
    }
}
