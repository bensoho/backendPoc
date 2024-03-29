package com.expd.geodev.backendpoc.service.impl;

import com.expd.geodev.backendpoc.job.DepartureNoticeJob;
import com.expd.geodev.backendpoc.model.Order;
import com.expd.geodev.backendpoc.model.QuartzGroupEnum;
import com.expd.geodev.backendpoc.service.OrderService;
import com.expd.geodev.backendpoc.utils.QuartzUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private QuartzUtil quartzUtil;

    @Override
    public String bookTicket(String userId, String ticketId) {
        //TODO 查询余票下订单等一些列操作
        Order order = new Order();
        //…………
        //创建一个定时任务
        LocalDateTime noticeTime = order.getDepartureTime().minusHours(2); //通知时间为发车前两小时
        quartzUtil.addJob(String.valueOf(order.getId()), QuartzGroupEnum.DEPARTURE_NOTICE.getValue(),
                DepartureNoticeJob.class, noticeTime, null, null, null);
        return "";
    }

    @Override
    public String rebook(Order order) {
        //TODO 修改订单等一系列操作
        //修改定时任务
        LocalDateTime noticeTime = order.getDepartureTime().minusHours(2); //通知时间为发车前两小时
        quartzUtil.modifyJobTime(String.valueOf(order.getId()), QuartzGroupEnum.DEPARTURE_NOTICE.getValue(),
                noticeTime, null, null);
        return "";
    }

    @Override
    public String cancelOrder(Order order) {
        //TODO 取消订单等一系列操作
        //取消定时任务
        quartzUtil.cancelJob(String.valueOf(order.getId()), QuartzGroupEnum.DEPARTURE_NOTICE.getValue());
        return "";
    }
}
