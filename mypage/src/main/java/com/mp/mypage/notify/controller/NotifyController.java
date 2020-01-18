package com.mp.mypage.notify.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.mp.mypage.common.Result;
import com.mp.mypage.notify.entity.NotifyConfig;
import com.mp.mypage.notify.service.NotifyService;
import com.mp.mypage.user.entity.UserBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "api/notify")
public class NotifyController {
    @Resource
    NotifyService notifyService;


    @CrossOrigin
    @RequestMapping(value = "/announce", method = RequestMethod.POST)
    @ResponseBody
    Result createAnnounce(long sender, String title, String content, Model model){
        return notifyService.createAnnounce(sender, title, content);
    }

    @CrossOrigin
    @RequestMapping(value = "/remind", method = RequestMethod.POST)
    @ResponseBody
    Result createRemind(Integer type, Integer subjectType, Long subjectId,
                        Integer action, Integer objectType, Long objectId, Model model){
        return notifyService.createRemind(type, subjectType, subjectId, action, objectType, objectId);
    }

    @CrossOrigin
    @RequestMapping(value = "/announce", method = RequestMethod.GET)
    @ResponseBody
    Result pullAnnounce(long userId, Model model){
        return notifyService.pullAnnounce(userId);
    }

    @CrossOrigin
    @RequestMapping(value = "/remind", method = RequestMethod.GET)
    @ResponseBody
    Result pullRemind(long userId, Model model){
        return notifyService.pullRemind(userId);
    }

    @CrossOrigin
    @RequestMapping(value = "/notify-box", method = RequestMethod.GET)
    @ResponseBody
    Result getNotifyBox(long userId, Model model){
        return notifyService.getNotifyBox(userId);
    }

    @CrossOrigin
    @RequestMapping(value = "/subscription", method = RequestMethod.POST)
    @ResponseBody
    Result subcribe(Long userId, Integer subjectType, Long subjectId, Integer action, Model model){
        return notifyService.subcribe(userId, subjectType, subjectId, action);
    }

    @CrossOrigin
    @RequestMapping(value = "/subscription", method = RequestMethod.DELETE)
    @ResponseBody
    Result cancelSubcribe(Long userId, Integer subjectType, Long subjectId, Integer action, Model model){
        return notifyService.cancelSubcribe(userId, subjectType, subjectId, action);
    }

    @CrossOrigin
    @RequestMapping(value = "/subscription", method = RequestMethod.GET)
    @ResponseBody
    Result getSubcriptions(long userId, Model model){
        return notifyService.getSubcriptions(userId);
    }

    @CrossOrigin
    @RequestMapping(value = "/config", method = RequestMethod.POST)
    @ResponseBody
    Result createConfig(Long userId, Model model){
        return notifyService.createConfig(userId);
    }

    @CrossOrigin
    @RequestMapping(value = "/config", method = RequestMethod.PUT)
    @ResponseBody
    Result modifyConfig(long userId, NotifyConfig config, Model model){
        return notifyService.modifyConfig(userId, config);
    }

    @CrossOrigin
    @RequestMapping(value = "/config", method = RequestMethod.GET)
    @ResponseBody
    Result getConfig(long userId, Model model){
        return notifyService.getConfig(userId);
    }

    @CrossOrigin
    @RequestMapping(value = "/read", method = RequestMethod.PUT)
    @ResponseBody
    Result readNotify(long notifyBoxId, Model model){
        return notifyService.readNotify(notifyBoxId);
    }
}
