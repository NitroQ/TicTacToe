package maingame;


public class Credentials {
	   private String Fname;
	   private  String Uname;
	   private  String pass1;
	   private  String email;
	   
	    public void setFname(String Fname){
	        this.Fname = Fname;
	        
	    }
	    public void setUname(String Uname){
	        this.Uname = Uname;
	       
	    }
	    public void setpass1(String pass1){
	        this.pass1 = pass1;
	       
	    }
	    public void setemail(String email){
	        this.email = email;
	       
	    }
	   
	    public String getFname(){
	    	
	        return Fname;
	    	
	    }
	    public String getUname(){
	    
	        return Uname;
	   
	    }
	    public String getpass1(){
	    	
	        return pass1;
	   
	    }
	    public String getemail(){
	    	
	        return email;
	    
	    }
	   
}
