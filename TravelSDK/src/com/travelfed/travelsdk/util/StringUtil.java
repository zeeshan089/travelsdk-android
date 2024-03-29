/*
 * Copyright (c) 2013, Perennial UG & Co.KG.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * - Neither the name of the Perennial UG & Co.KG nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package com.travelfed.travelsdk.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import com.travelfed.travelsdk.Logger;

public class StringUtil {
	
	public final static String SPACE_STRING = " ";
	public static final String COMA_STRING = ", ";

	private static Logger logger = new Logger(StringUtil.class);
	
    public static boolean isNullOrEmpty(String string) {
    	
        if(string == null) {
            return true;
        }
        if(string.trim().equals("")) {
            return true;
        }
        return false;
    }	

	public static String[] split(String stringToSplit, String splitString) {
		if(StringUtil.isNullOrEmpty(stringToSplit)) {
			return new String[]{};
		}
		int splitStringLenght = splitString.length();
		int searchIndex = stringToSplit.indexOf(splitString);
		int startIndex = 0;
		Vector<String> resultVector = new Vector<String>();
		while (true) {
			if(searchIndex == -1) {
				resultVector.addElement(stringToSplit.substring(startIndex));
				break;
			}
			if(searchIndex > startIndex) {
				resultVector.addElement(stringToSplit.substring(startIndex, searchIndex));
				startIndex = searchIndex;
			}
			startIndex +=splitStringLenght;
			if(startIndex >= stringToSplit.length()) {
				break;
			}
			searchIndex = stringToSplit.indexOf(splitString, startIndex);
		}
		String[] result = new String[resultVector.size()];
		for(int i=0; i< result.length; i++) {
			result[i] = (String) resultVector.elementAt(i);
		}
		return result;
	}
    
    
    /**
     * 
     * @param longDate
     * @return date string in format yyyy-MM-dd
     */
    public static String toDateSting_YYYY_MM_DD(int year, int month, int dayOfMonth) {
		StringBuffer result = new StringBuffer();
		// year
		result.append(year);
		// month
		result.append("-");
		month++;
		if(month < 10 ) {
			result.append("0");
		}
		result.append(month);
		// day of month
		result.append("-");
		if(dayOfMonth < 10) {
			result.append("0");
		}
		result.append(dayOfMonth);		
		
		return result.toString();
    }
    
    /**
     * 
     * @param year
     * @param month
     * @param dayOfMonth
     * @return Date string in format dd.MM.yyy
     */
	public static String toDateString(int year, int month, int dayOfMonth) {

		StringBuffer result = new StringBuffer();
		// day of month
		if(dayOfMonth < 10) {
			result.append("0");
		}
		result.append(dayOfMonth);
		// month
		result.append(".");
		month++;
		if(month < 10 ) {
			result.append("0");
		}
		result.append(month);
		// year
		result.append(".").append(year);
		
		return result.toString();
	}
	

	/**
	 * 
	 * @param date - String in one of these formats. dd.MM.yyyy, yyyy.MM.dd, yyyy-MM-dd, yyyyMMddThhmm, yyyy-MM-ddThh:mm 
	 * @return
	 */
	public static Date parseDate(String date) {
		int indexOf = date.indexOf('.');
		int lastIndexOf = date.lastIndexOf('.');
		Calendar calendar = new GregorianCalendar();
		int dayOfMonth=0, month=0, year=0;
		int hours = 0;
		int minutes = 0;
		
		if(date.length() < 8) {
			return new Date();
		}
		try {
			if(indexOf == lastIndexOf) {
				indexOf = date.indexOf('-');
				lastIndexOf = date.lastIndexOf('-');
				if(indexOf == lastIndexOf) {
					//parse yyyyMMddThhmm
					dayOfMonth = Integer.parseInt(date.substring(6, 8));
					month = Integer.parseInt(date.substring(4, 6)) - 1;
					year = Integer.parseInt(date.substring(0, 4));
					indexOf = date.indexOf("T"); 
					if(indexOf != -1) {
						hours = Integer.parseInt(date.substring(9 , 11));
						minutes = Integer.parseInt(date.substring(11 , 13));
					}
				} else {
					//parse  yyyy-MM-dd
					year = Integer.parseInt(date.substring(0, indexOf));
					month = Integer.parseInt(date.substring(indexOf+ 1, indexOf+ 3)) - 1;
					dayOfMonth = Integer.parseInt(date.substring(indexOf+4, indexOf+6));
					
					int indexOfT = date.indexOf("T"); 
					if(indexOfT != -1) {
						//parse yyyy-MM-ddThh:mm 						
						hours = Integer.parseInt(date.substring(11 , 13));
						minutes = Integer.parseInt(date.substring(14 , 16));
					}
				}
			} else if (indexOf == 2) {		
				dayOfMonth = Integer.parseInt(date.substring(0, indexOf));
				month = Integer.parseInt(date.substring(indexOf+ 1, lastIndexOf)) - 1;
				year = Integer.parseInt(date.substring(lastIndexOf+1, lastIndexOf+5));
			} else if(indexOf == 4) {
//				logger.debug(date);
//				logger.debug("month: "+Integer.parseInt(date.substring(indexOf + 1, lastIndexOf)));
				year = Integer.parseInt(date.substring(0, indexOf));
				month = Integer.parseInt(date.substring(indexOf + 1, lastIndexOf)) - 1;
				dayOfMonth = Integer.parseInt(date.substring(lastIndexOf+1, lastIndexOf+3));
			}
		} catch (Exception e) {
			logger.error(e, "parseDate: " + date);
		}
		
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		calendar.set(Calendar.HOUR_OF_DAY, hours);
		calendar.set(Calendar.MINUTE, minutes);
		
		return calendar.getTime();
	}
	
	/**
	 * 
	 * @param time date and time in format yyyyMMddThhmm
	 * @return time string
	 */
	public static String parseTime(String time) {
		int indexOfT = time.indexOf("T");
		if(indexOfT != -1) {
			StringBuffer result = new StringBuffer(time.substring(indexOfT + 1, indexOfT + 5));
			result.insert(2, ":");
			return result.toString();
		}
		return "";
	}

	
	/**
	 * 
	 * @param time - string in format hhmm or hmm
	 * @return time string in format hh:mm
	 */
	public static String convertTimeToNormalForm(String time) {
		boolean hasDelitel = (time.indexOf(":") != -1);
		StringBuffer result = new StringBuffer(time);
		if(time.length() < 4 || (time.length() == 4 && hasDelitel)) {
			result.insert(0, "0");
		}
		if(result.length() == 4) {
			result.insert(2, ":");
		}
		return result.toString();
	}
	
	public static final String md5(final String s) {
	    try {
	        // Create MD5 Hash
	        MessageDigest digest = java.security.MessageDigest
	                .getInstance("MD5");
	        digest.update(s.getBytes());
	        byte messageDigest[] = digest.digest();

	        // Create Hex String
	        StringBuffer hexString = new StringBuffer();
	        for (int i = 0; i < messageDigest.length; i++) {
	            String h = Integer.toHexString(0xFF & messageDigest[i]);
	            while (h.length() < 2)
	                h = "0" + h;
	            hexString.append(h);
	        }
	        return hexString.toString();

	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return "";
	}
	

}
