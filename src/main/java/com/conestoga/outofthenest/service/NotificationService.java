package com.conestoga.outofthenest.service;

import com.conestoga.outofthenest.mapper.EventMapper;
import com.conestoga.outofthenest.mapper.UserMapper;
import com.conestoga.outofthenest.model.Event;
import com.conestoga.outofthenest.model.FamilyMember;
import com.conestoga.outofthenest.model.Notification;
import com.conestoga.outofthenest.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    private final EventMapper eventMapper;
    private final UserMapper userMapper;

    public NotificationService(EventMapper eventMapper, UserMapper userMapper) {
        this.eventMapper = eventMapper;
        this.userMapper = userMapper;
    }

    public List<Notification> getUserNotifications(String userId) {
        User user = userMapper.getUserById(userId);
        if (user == null) return new ArrayList<>();
        String id = String.valueOf(user.getId());
        List<FamilyMember> familyMembers = userMapper.getFamilyMembersByUserId(id);
        List<Event> events = eventMapper.getAllEventsWithAudience();

        List<Notification> notifications = new ArrayList<>();

        for (Event event : events) {
            for (FamilyMember member : familyMembers) {
                if (matchesTargetAudience(event.getTargetAudience(), member)) {
                    Notification notification = new Notification();
                    notification.setUserId(userId);
                    notification.setEventId(event.getId());
                    notification.setTitle(event.getTitle());
                    notification.setMessage(event.getDescription());
                    notification.setScheduledTime(event.getDatetime());
                    notifications.add(notification);
                    break;
                }
            }
        }

        return notifications;
    }

    private boolean matchesTargetAudience(List<String> audienceTags, FamilyMember member) {
        int age = member.getAge();
        String type = member.getType();

        boolean ageMatch = audienceTags.contains("All ages") || (
                (age <= 2 && audienceTags.contains("Babies (0-2 years)")) ||
                        (age >= 3 && age <= 5 && audienceTags.contains("Early childhood (3-5 years)")) ||
                        (age >= 6 && age <= 9 && audienceTags.contains("Children (6-9 years)")) ||
                        (age >= 10 && age <= 12 && audienceTags.contains("Pre-teens (10-12 years)")) ||
                        (age >= 13 && age <= 17 && audienceTags.contains("Teenagers (13-17 years)")) ||
                        (age >= 18 && audienceTags.contains("Adults"))
        );

        boolean genderMatch = audienceTags.contains("All genders") ||
                (type.equals("BOY") && audienceTags.contains("Boys")) ||
                (type.equals("GIRL") && audienceTags.contains("Girls")) ||
                (type.equals("MAN") && audienceTags.contains("Adults")) ||
                (type.equals("WOMAN") && audienceTags.contains("Adults"));

        return ageMatch && genderMatch;
    }
}
