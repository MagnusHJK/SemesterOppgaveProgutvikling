package org.openjfx.logic.AppInfo;


//Enkel klasse for versjon info, github link, etc i "About"

public class AppInfo {

    private final static String versjon = "DAILY_13-TORSDAG";
    private final static String git = "https://github.com/MagnusHJK/SemesterOppgaveProgutvikling";

    public String getVersjon(){
        return versjon;
    }

    public String getGit(){
        return git;
    }
}
