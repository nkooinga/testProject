package com.stc.roster.api;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.File;

/**
 * Created by nkooinga on 6/12/2017.
 */
public class RosterDownloadUpload {

    File rosterDownload = new File(System.getProperty("/*Download Directory Location*/")+File.separator+"/*File name*/");

    int expectedSize = (int)rosterDownload.length();

    System.out.println("Expected file size: " + expectedSize + " bytes")
}
