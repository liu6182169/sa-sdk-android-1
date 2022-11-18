/*
 * Created by dengshiwei on 2022/06/29.
 * Copyright 2015－2021 Sensors Data Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sensorsdata.analytics.android.sdk.visual;

import android.content.Context;

import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SensorsAnalyticsAutoTrackEventType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;

public class SAHelper {

    private final static String SA_SERVER_URL = "http://10.120.111.143:8106/sa?project=default";

    public static SensorsDataAPI initSensors(Context context) {
        SAConfigOptions configOptions = new SAConfigOptions(SA_SERVER_URL);
        // 打开自动采集, 并指定追踪哪些 AutoTrack 事件
        configOptions.setAutoTrackEventType(SensorsAnalyticsAutoTrackEventType.APP_CLICK | SensorsAnalyticsAutoTrackEventType.APP_VIEW_SCREEN)
                .enableJavaScriptBridge(true)
                .enableHeatMap(true)
                .enableVisualizedProperties(true);
        SensorsDataAPI.startWithConfigOptions(context, configOptions);
        SensorsDataAPI.sharedInstance(context).trackFragmentAppViewScreen();
        SensorsDataAPI.sharedInstance(context).setTrackEventCallBack(null);
        return SensorsDataAPI.sharedInstance();
    }

}
