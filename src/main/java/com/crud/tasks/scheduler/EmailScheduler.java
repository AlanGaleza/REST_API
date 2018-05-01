package com.crud.tasks.scheduler;

import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.trello.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * *")
    //@Scheduled(fixedDelay = 10000)// - send email every 10 sec - test
    public void sendInformationEmail() {
        long size = taskRepository.count();
        simpleEmailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT, String.format("Currently in database you got: %s (%s)", size, taskOrTasks())));
    }

    private String taskOrTasks() {
        return (taskRepository.count() > 1) ? " tasks" : " task";
    }

}
