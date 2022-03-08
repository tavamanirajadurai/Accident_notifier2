package com.example.accident_notifier;

public class details {

        String name;
        String username;
        String userid;
        String drive;
        String aadhar,phno,blood;

        public details(String text,String feedname,String userid,String drive) {
            this.name= text;
            this.username=feedname;
            this.userid=userid;
            this.drive=drive;
            this.aadhar=aadhar;
            this.blood=blood;
            this.phno=phno;
        }
        public String getusername() {
            return username;
        }
        public String getname() {
            return name;
        }
    public String getuserid() {
        return userid;
    }
    public String getdrive() {
        return drive;
    }
    public String getblood() {
        return blood;
    }
    public String getaadhar() {
        return aadhar;
    }
    public String getPhno() {
        return phno;
    }

        public void setusername(String username) {
            this.username = username;
        }
    public void setdrive(String drive) {
        this.drive = drive;
    }
        public void setname(String name) {
            this.name = name;
        }
       public void setuserid(String userid) {
        this.userid = userid;
    }
    public void setAadhar(String aadhar) {this.aadhar=aadhar;}
    public void setPhno(String phno){this.phno=phno;}
    public void setBlood(String blood){this.blood=blood;}

        public details() {
        }





}
