package com.example.test007;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataHandler extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DB_NAME="WJcon";
    private static final String TABLE_NAME1="admins";
    private static final String TABLE_NAME2="supervisors";
    private static final String TABLE_NAME3="workers";
    private static final String TABLE_NAME4="conSites";
    private static final String TABLE_NAME5="attendance";

    public DataHandler(@Nullable Context context) {

        super(context, DB_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME1+" (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name text,address text ,age INT,gender text,username text,password text,email text )");
        db.execSQL("CREATE TABLE "+TABLE_NAME2+" (SID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name text,birth text,address text ,username text,password text,phone text,nic text,email text )");
        db.execSQL("CREATE TABLE "+TABLE_NAME3+" (WID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name text,address text,birthday text,role text,phone text,nic text,email text )");
        db.execSQL("CREATE TABLE "+TABLE_NAME4+" (CSID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name text,address text,superV text,workerC text,budget text,duration text )");
        db.execSQL("CREATE TABLE "+TABLE_NAME5+" (AID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name text,email text,date text )");

        ContentValues contentValues = new ContentValues();
        contentValues.put("name","default user");
        contentValues.put("address","default user");
        contentValues.put("age",0);
        contentValues.put("gender","NA");
        contentValues.put("username","admin");
        contentValues.put("password","admin123");
        contentValues.put("email","default user");
        db.insert(TABLE_NAME1,null,contentValues);

        ContentValues contentValues1 = new ContentValues();
        contentValues1.put("name","default user");
        contentValues1.put("birth","0");
        contentValues1.put("address","default user");
        contentValues1.put("username","supervisor");
        contentValues1.put("password","super123");
        contentValues1.put("phone","NA");
        contentValues1.put("nic","NA");
        contentValues1.put("email","default user");
        db.insert(TABLE_NAME2,null,contentValues1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    public void createSupervisor(Supervisor supervisor) {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put("name", supervisor.getName());
        contentValues1.put("birth", supervisor.getBirth());
        contentValues1.put("address", supervisor.getAddress());
        contentValues1.put("username", supervisor.getUsername());
        contentValues1.put("password", supervisor.getPassword());
        contentValues1.put("phone", supervisor.getPhone());
        contentValues1.put("nic" , supervisor.getNic());
        contentValues1.put("email", supervisor.getEmail());
        db.insert("supervisors", null, contentValues1);
    }
    public void createSite(Construction construction) {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues4 = new ContentValues();
        contentValues4.put("name", construction.getNameC());
        contentValues4.put("address", construction.getAddressC());
        contentValues4.put("superV", construction.getSupervisorN());
        contentValues4.put("workerC", construction.getWorkers());
        contentValues4.put("budget", construction.getBudget());
        contentValues4.put("duration" , construction.getDuration());
        db.insert(TABLE_NAME4, null, contentValues4);
    }
    public ArrayList<Supervisor> getAllPatients(){
        return null;
    }

    public boolean checkForEmail(String email){
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from admins where email='"+email +"'",null);
        if (cursor.getCount()>0){
            return true;
        }
        return false;
    }
    public boolean checkSupervisorEmail(Supervisor supervisor){
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from supervisors where email='"+supervisor.getEmail() +"'",null);
        if (cursor.moveToFirst()){
            return true;
        }
        return false;
    }
    public boolean checkForAdmin(Admin admin) throws Exception{
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from admins where username='"+admin.getUsername() +"'and password ='"+admin.getPassword()+"'",null);
        if (cursor.moveToFirst()){
            return true;
        }
        return false;
    }
    public boolean checkForSupervisor(Supervisor supervisor) throws Exception{
        SQLiteDatabase db= getReadableDatabase();

        Cursor cursor=db.rawQuery("select * from supervisors where username='"+supervisor.getUsername() +"'and password ='"+supervisor.getPassword()+"'",null);
        if (cursor.moveToFirst()){
            return true;
        }
        return false;
    }
    public int countToDo(){
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME2;

        Cursor cursor=db.rawQuery(query,null);
        return cursor.getCount();
    }
    public int countToDoW(){
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME3;

        Cursor cursor=db.rawQuery(query,null);
        return cursor.getCount();
    }
    public List<Supervisor> getAllSupervisors(){
        List<Supervisor> supervisors = new ArrayList<>();
        SQLiteDatabase db= getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME2;

        Cursor cursor=db.rawQuery(query, null);

        if (cursor.moveToFirst()){
            do{
                Supervisor supervisor= new Supervisor();
                supervisor.setSID(cursor.getInt(0));
                supervisor.setName(cursor.getString(1));
                supervisor.setBirth(cursor.getString(2));
                supervisor.setAddress(cursor.getString(3));
                supervisor.setUsername(cursor.getString(4));
                supervisor.setPassword(cursor.getString(5));
                supervisor.setPhone(cursor.getString(6));
                supervisor.setNic(cursor.getString(7));
                supervisor.setEmail(cursor.getString(8));

                supervisors.add(supervisor);
            }while(cursor.moveToNext());
        }
        return  supervisors;
    }
    public List<Construction> getAllSites(){
        List<Construction> constructions = new ArrayList<>();
        SQLiteDatabase db= getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME4;

        Cursor cursor=db.rawQuery(query, null);

        if (cursor.moveToFirst()){
            do{
                Construction construction= new Construction();
                construction.setCSID(cursor.getInt(0));
                construction.setNameC(cursor.getString(1));
                construction.setAddressC(cursor.getString(2));
                construction.setSupervisorN(cursor.getString(3));
                construction.setWorkers(cursor.getString(4));
                construction.setBudget(cursor.getString(5));
                construction.setDuration(cursor.getString(6));
                constructions.add(construction);
            }while(cursor.moveToNext());
        }
        return  constructions;
    }
    public List<Worker> getAllWorkers(){
        List<Worker> workers = new ArrayList<>();
        SQLiteDatabase db= getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME3;

        Cursor cursor=db.rawQuery(query, null);

        if (cursor.moveToFirst()){
            do{
                Worker worker= new Worker();
                worker.setWID(cursor.getInt(0));
                worker.setName(cursor.getString(1));
                worker.setAddress(cursor.getString(2));
                worker.setBirthday(cursor.getString(3));
                worker.setPhone(cursor.getString(5));
                worker.setNic(cursor.getString(6));
                worker.setEmail(cursor.getString(7));

                workers.add(worker);
            }while(cursor.moveToNext());
        }
        return  workers;
    }

    public void deleteSupervisors(int SID){
        SQLiteDatabase db=getWritableDatabase();
        db.delete("supervisors","SID=?",new String[]{String.valueOf(SID)});
    }
    public void deleteWorkers(int WID){
        SQLiteDatabase db=getWritableDatabase();
        db.delete(TABLE_NAME3,"WID=?",new String[]{String.valueOf(WID)});
    }

    public Supervisor getSingleSupervisor(int SID){
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.query(TABLE_NAME2,new String[]{"SID","name","birth","address","username","password","phone","nic","email"},
                "SID=?",new String[]{String.valueOf(SID)},null,null,null);
        Supervisor supervisor;
        if (cursor!=null){
            cursor.moveToFirst();
            supervisor=new Supervisor(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8)
            );
            return supervisor;
        }
        return null;
    }
    public Worker getSingleWorker(int WID){
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.query(TABLE_NAME3,new String[]{"WID","name","address","birthday","role","phone","nic","email"},
                "WID=?",new String[]{String.valueOf(WID)},null,null,null);
        Worker worker;
        if (cursor!=null){
            cursor.moveToFirst();
            worker=new Worker(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7)
            );
            return worker;
        }
        return null;
    }
    public int updateSingleSupervisor(Supervisor supervisor){
        SQLiteDatabase db=getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put("name",supervisor.getName());
        contentValues.put("birth",supervisor.getBirth());
        contentValues.put("address",supervisor.getAddress());
        contentValues.put("username",supervisor.getUsername());
        contentValues.put("password",supervisor.getPassword());
        contentValues.put("phone",supervisor.getPhone());
        contentValues.put("nic",supervisor.getNic());
        contentValues.put("email",supervisor.getEmail());

        int status=db.update("supervisors",contentValues,"SID=?",new String[]{ String.valueOf(supervisor.getSID())});

        return status;

    }
    public void createWorker(Worker worker) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("name", worker.getName());
        contentValues.put("birthday", worker.getBirthday());
        contentValues.put("address", worker.getAddress());
        contentValues.put("role", worker.getRole());
        contentValues.put("phone", worker.getPhone());
        contentValues.put("nic", worker.getNic());
        contentValues.put("email", worker.getEmail());

        db.insert(TABLE_NAME3, null, contentValues);

    }
    public void createAttendance(Attendance attendance) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", attendance.getName());
        contentValues.put("email", attendance.getEmail());
        contentValues.put("date", attendance.getDate());

        db.insert(TABLE_NAME5, null, contentValues);

    }
    public int updateSingleWorker(Worker worker) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("name", worker.getName());
        contentValues.put("birthday", worker.getBirthday());
        contentValues.put("address", worker.getAddress());
        contentValues.put("phone", worker.getPhone());
        contentValues.put("nic", worker.getNic());
        contentValues.put("email", worker.getEmail());

        int status = db.update(TABLE_NAME3, contentValues, "WID=?", new String[]{String.valueOf(worker.getWID())});

        return status;
    }

    }
