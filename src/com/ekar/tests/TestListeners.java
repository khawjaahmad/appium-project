package com.ekar.tests;

import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class TestListeners implements ITestNGListener {

	 public void onFinish(ITestContext arg0) 
	 {					
	        // TODO Auto-generated method stub
	    }
	 public void onStart(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    
	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    	public void onTestFailure(ITestResult Result) {					
	    	{		
	    	    System.out.println("The name of the testcase failed is :" + Result.getName());					
	    	    }				
	        		
	    }		

	  	
	    public void onTestSkipped(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	 	
	    public void onTestStart(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	 	
	    public void onTestSuccess(ITestResult Result) {					
    	    System.out.println("The name of the testcase passed is :" + Result.getName());					
	        		
}
	  
}

