package com.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date extends java.util.Date{
	   
    /**
     *
     */
    private static final long serialVersionUID = 2155545266875552658L;
     
    /**
     * ���ܣ�ת��ΪCalendar��
     
     * Aug 21, 2013 8:58:31 AM
     * @return Calendar
     */
    public Calendar toCalendar() {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        return c;
    }
     
    /**
     * ���ܣ��ж������Ƿ�͵�ǰdate������ͬһ�졣
     
     * Aug 21, 2013 7:15:53 AM
     * @param date �Ƚϵ�����
     * @return boolean ����ڷ���true�����򷵻�false��
     */
    public  boolean isSameDay(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("���ڲ���Ϊnull");
        }
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date);
        return this.isSameDay(cal2);
    }
     
    /**
     * ���ܣ��ж������Ƿ�͵�ǰdate������ͬһ�졣
     
     * Aug 21, 2013 7:15:53 AM
     * @param cal �Ƚϵ�����
     * @return boolean ����ڷ���true�����򷵻�false��
     */
    public  boolean isSameDay(Calendar cal) {
        if (cal == null) {
            throw new IllegalArgumentException("���ڲ���Ϊnull");
        }
        //��ǰdate�����ʱ��
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(this);
        return (cal1.get(Calendar.ERA) == cal.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR));
    }
     
    /**
     * ���ܣ�����ǰ���ڵ����������������á�
     
     * Jul 31, 2013 2:42:36 PM
     * @param second ����
     * @return ���ú������
     */
    public Date setSecondNew(int second){
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.SECOND,second);
        return new Date(c.getTimeInMillis());
    }
     
    /**
     * ���ܣ�����ǰ���ڵķ��ӽ����������á�
     
     * Jul 31, 2013 2:42:36 PM
     * @param minute ������
     * @return ���ú������
     */
    public Date setMinuteNew(int minute){
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.MINUTE,minute);
        return new Date(c.getTimeInMillis());
    }
     
    /**
     * ���ܣ�����ǰ���ڵ�Сʱ�����������á�
     
     * Jul 31, 2013 2:42:36 PM
     * @param hours Сʱ�� (24Сʱ��)
     * @return ���ú������
     */
    public Date setHourNew(int hour){
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.HOUR_OF_DAY, hour);
        return new Date(c.getTimeInMillis());
    }
     
    /**
     * ���ܣ�����ǰ���ڵ�������������á�
     
     * Jul 31, 2013 2:42:36 PM
     * @param days ĳһ��
     * @return ���ú������
     */
    public Date setDayNew(int day){
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.DATE,day);
        return new Date(c.getTimeInMillis());
    }
     
    /**
     * ���ܣ�����ǰ���ڵ��½����������á�
     
     * Jul 31, 2013 2:42:36 PM
     * @param months ĳһ��
     * @return ���ú������
     */
    public Date setMonthNew(int month){
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.MONTH, month-1);
        return new Date(c.getTimeInMillis());
    }
     
    /**
     * ���ܣ�����ǰ���ڵ�������������á�
     
     * Jul 31, 2013 2:42:36 PM
     * @param years ĳһ��
     * @return ���ú������
     */
    public Date setYearNew(int year){
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.YEAR, year);
        return new Date(c.getTimeInMillis());
    }
     
    /**
     * ���ܣ��õ������ж����졣
     
     * Jul 2, 2013 4:59:41 PM
     * @return int
     */
    public int daysNumOfMonth(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(this);
        return cal.getActualMaximum(Calendar.DATE);
    }
     
    /**
     * ��yyyy-MM-dd HH:mm:ss�ַ���ת��������(net.maxt.util.Date)<br/>
     * @param dateStr ʱ���ַ���
     * @param ��ǰʱ���ַ����ĸ�ʽ��
     * @return net.maxt.util.Date ���� ,ת���쳣ʱ����null��
     */
    public static Date parseDate(String dateStr,SimpleDateFormat dataFormat){
        try {
            java.util.Date d = dataFormat.parse(dateStr);
            return new Date(d.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
     
    /**
     * ��yyyy-MM-dd HH:mm:ss�ַ���ת��������(net.maxt.util.Date)<br/>
     * @param dateStr yyyy-MM-dd HH:mm:ss�ַ���
     * @return net.maxt.util.Date ���� ,ת���쳣ʱ����null��
     */
    public static Date parseDate(String dateStr){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            java.util.Date d = sdf.parse(dateStr);
            return new Date(d.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
     
     
     
    /**
     * ���ܣ���ǰʱ�����Ӻ�������
     
     * May 29, 2013 11:26:27 AM
     * @param milliseconds ��ֵʱʱ���Ӻ󣬸�ֵʱʱ����ǰ��
     * @return Date
     */
    public Date addMilliseconds(int milliseconds){
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.MILLISECOND, c.get(Calendar.MILLISECOND)+milliseconds);
        return new Date(c.getTimeInMillis());
    }
     
    /**
     * ���ܣ���ǰʱ������������
     
     * May 29, 2013 11:26:27 AM
     * @param seconds ��ֵʱʱ���Ӻ󣬸�ֵʱʱ����ǰ��
     * @return Date
     */
    public Date addSeconds(int seconds){
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.SECOND, c.get(Calendar.SECOND)+seconds);
        return new Date(c.getTimeInMillis());
    }
     
    /**
     * ���ܣ���ǰʱ�����ӷ�������
     
     * May 29, 2013 11:26:27 AM
     * @param minutes ��ֵʱʱ���Ӻ󣬸�ֵʱʱ����ǰ��
     * @return Date
     */
    public Date addMinutes(int minutes){
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.MINUTE, c.get(Calendar.MINUTE)+minutes);
        return new Date(c.getTimeInMillis());
    }
     
    /**
     * ���ܣ���ǰʱ������Сʱ����
     
     * May 29, 2013 11:26:27 AM
     * @param hours ��ֵʱʱ���Ӻ󣬸�ֵʱʱ����ǰ��
     * @return Date
     */
    public Date addHours(int hours){
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.HOUR, c.get(Calendar.HOUR)+hours);
        return new Date(c.getTimeInMillis());
    }
     
    /**
     * ���ܣ���ǰʱ������������
     
     * May 29, 2013 11:26:27 AM
     * @param days ��ֵʱʱ���Ӻ󣬸�ֵʱʱ����ǰ��
     * @return Date
     */
    public Date addDays(int days){
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.DATE, c.get(Calendar.DATE)+days);
        return new Date(c.getTimeInMillis());
    }
     
    /**
     * ���ܣ���ǰʱ������������
     
     * May 29, 2013 11:26:27 AM
     * @param months ��ֵʱʱ���Ӻ󣬸�ֵʱʱ����ǰ��
     * @return Date
     */
    public Date addMonths(int months){
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH)+months);
        return new Date(c.getTimeInMillis());
    }
     
    /**
     * ���ܣ���ǰʱ������������ע������2��29�������ϵͳ���Զ��Ӻ���߼���һ�졣
     
     * May 29, 2013 11:26:27 AM
     * @param years ��ֵʱʱ���Ӻ󣬸�ֵʱʱ����ǰ��
     * @return Date
     */
    public Date addYears(int years){
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.YEAR, c.get(Calendar.YEAR)+years);
        return new Date(c.getTimeInMillis());
    }
     
    /**
     * �õ��롣��ʽ��56<br/>
     * @return int
     */
    public int secondInt() {
        return Integer.parseInt(toString("ss"));
    }
     
    /**
     * �õ����ӡ���ʽ��56<br/>
     * @return int
     */
    public int minuteInt() {
        return Integer.parseInt(toString("mm"));
    }
     
    /**
     * �õ�Сʱ����ʽ��23<br/>
     * @return int
     */
    public int hourInt() {
        return Integer.parseInt(toString("HH"));
    }
     
    /**
     * �õ��ա���ʽ��26<br/>
     * ע�⣺����1�շ���1,2�շ���2��
     * @return int
     */
    public int dayInt() {
        return Integer.parseInt(toString("dd"));
    }
     
    /**
     * �õ��¡���ʽ��5<br/>
     * ע�⣺����1�·���1,2�·���2��
     * @return int
     */
    public int monthInt() {
        return Integer.parseInt(toString("MM"));
    }
     
    /**
     * �õ��ꡣ��ʽ��2013
     * @return int
     */
    public int yearInt() {
        return Integer.parseInt(toString("yyyy"));
    }
     
    /**
     * �õ���ʱ�䡣��ʽ��12:01
     * @return String
     */
    public String shortTime() {
        return toString("HH:mm");
    }
     
    /**
     * �õ���ʱ�䡣��ʽ��12:01:01
     * @return String
     */
    public String longTime() {
        return toString("HH:mm:ss");
    }
     
    /**
     * �õ�����ĵ�һ���ʱ�䡣
     * @return Date
     */
    public Date dayStart() {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return new Date(c.getTimeInMillis());
    }
     
    /**
     * �õ���ǰ������Ȼ�µĵ�һ��Ŀ�ʼ,��ʽΪ�����ڸ�ʽ�����磺2012-03-01 00:00:00��
     * @return Date
     */
    public Date monthStart(){
        Calendar c=Calendar.getInstance();
        String startStr= toString("yyyy-M-")+c.getActualMinimum(Calendar.DATE)+" 00:00:00";
        return Date.parseDate(startStr);
    }
 
    /**
     * �õ���������һ���ʱ�䡣
     * @return Date
     */
    public Date dayEnd() {
        Calendar c = Calendar.getInstance();
        c.setTime(this);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return new Date(c.getTimeInMillis());
    }
     
    /**
     * �������ڵõ����ڼ�,�õ����֡�<br/>
     * 7, 1, 2, 3, 4, 5, 6
     * @return Integer �磺6
     */
    public int dayOfWeekInt() {
        Integer dayNames[] = { 7, 1, 2, 3, 4, 5, 6 };
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0)
            dayOfWeek = 0;
        return dayNames[dayOfWeek];
    }
     
    /**
     * ������ת���ɳ������ַ��� ���磺2009-09-09 01:01:01
     * @return String
     */
    public String toLongDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return (null == this) ? null : df.format(this);
    }
     
    /**
     * �����ڰ���һ���ĸ�ʽ���и�ʽ��Ϊ�ַ�����<br/>
     * �����뽫ʱ���ʽ��Ϊ2012-03-05 12:56 ,��ֻ��Ҫ����formateΪyyyy-MM-dd HH:mm���ɡ�
     * @param formate ��ʽ����ʽ���磺yyyy-MM-dd HH:mm
     * @return String ��ʽ��������ַ����������ǰ����Ϊnull����ֱ�ӷ���null��
     */
    public String toString(String formate) {
        DateFormat df = new SimpleDateFormat(formate);
        return (null == this) ? null : df.format(this);
    }
 
    /**
     * �õ�ĳ��ʱ���ʱ���yyyyMMddHHmmss��
     * @param date ʱ��
     * @return String �����ǰ����Ϊnull����ֱ�ӷ���null��
     */
    public String toTimeStamp() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return (null == this) ? null : df.format(this);
    }
     
    /**
     * ������ת���ɶ������ַ���,���磺2009-09-09��
     * @return String ,�����ǰ����Ϊnull������null��
     */
    public String toShortDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return (null == this) ? null : df.format(this);
    }
     
    /**
     * ���ܣ���java.util.Date���й��졣
     
     * May 29, 2013 10:59:05 AM
     * @param java.util.Date date
     */
    public Date(java.util.Date date) {
        super(date.getTime());
    }
     
    /**
     * ���ܣ��ú�����й��졣
     
     * May 29, 2013 10:59:05 AM
     * @param timeInMillis
     */
    public Date(long timeInMillis) {
        super(timeInMillis);
    }
 
 
    /**
     * ���ܣ�Ĭ�Ϲ��캯����
     
     * May 29, 2013 11:00:05 AM
     */
    public Date() {
        super();
    }
}
