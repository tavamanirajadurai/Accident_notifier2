package com.example.accident_notifier.utils.interfaces;

import com.example.accident_notifier.utils.models.RectModel;

public interface FaceDetectStatus {
    void onFaceLocated(RectModel rectModel);
    void onFaceNotLocated() ;
}
