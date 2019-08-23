package com.example.testit;

public class DateEntity {
    private String date;//日期
    private String startTime;//上班时间
    private String endTime;//下班时间
    private String overWorkDate;//加班时段
    private String outWordDate;//出差时段
    private String mark;//备注
    public int year;//年
    public int month;//月
    public int day;//日
    public int week;//周几
    private boolean isToday;//当前日期是否为今天
    private boolean isLate;//是否迟到
    private boolean isEarly;//是否早退
    private boolean isNormal;//状态是否正常

    public DateEntity(String date){
        this.date = date;
    }

    public void Start(String startTime){
        this.startTime = startTime;
    }

    public void End(String endTime){
        this.endTime = endTime;
    }
}
