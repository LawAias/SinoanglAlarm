package com.sinoangel.sazalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.lidroid.xutils.exception.DbException;
import com.sinoangel.sazalarm.bean.AlarmBean;

import java.util.List;

/**
 * Created by Z on 2017/2/15.
 */

public class DateTimeChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        try {
            AlarmUtils.outputLog("日期改变广播");
            List<AlarmBean> alab = AlarmUtils.getDbUtisl().findAll(AlarmBean.class);
            if (alab != null)
                for (AlarmBean ab : alab) {
                    if (ab.getStatus() == AlarmBean.STATUS_ON && ab.getType() != AlarmBean.ALARM_JISHIQI) {
                        ab.checkTime();
                    }
                }
        } catch (DbException e) {
            e.printStackTrace();
        }


    }
}
