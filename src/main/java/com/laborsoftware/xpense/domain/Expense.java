package com.laborsoftware.xpense.domain;

import com.laborsoftware.xpense.domain.enumeration.ExpenseState;
import com.laborsoftware.xpense.service.ExpenseService;
import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    // description

    @Column(name = "start_date_time")
    private ZonedDateTime startDateTime;

    @Column(name = "end_date_time")
    private ZonedDateTime endDateTime;

    @Enumerated(EnumType.STRING)
    private ExpenseState state;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private ApplicationUser applicationUser;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne()
    @JoinColumn(name = "weekly_timecard_id")
    private WeeklyTimecard weeklyTimecard;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(ZonedDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public ZonedDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(ZonedDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public ExpenseState getState() {
        return state;
    }

    public void setState(ExpenseState state) {
        this.state = state;
    }

    public ApplicationUser getUser() {
        return applicationUser;
    }

    public void setUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public WeeklyTimecard getWeeklyTimecard() {
        return weeklyTimecard;
    }

    public void setWeeklyTimecard(WeeklyTimecard weeklyTimecard) {
        this.weeklyTimecard = weeklyTimecard;
    }
}
